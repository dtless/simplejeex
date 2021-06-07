package com.github.dttimes.simplejeex.security.autoconfigure.coc;

import com.github.dttimes.simplejeex.security.autoconfigure.SimplejeexSecurityAutoConfigure;
import com.github.dttimes.simplejeex.security.autoconfigure.coc.filter.SimplejeexUsernamePasswordAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * <p><b>Slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-04 16:39<p>
 *
 * @author 王輝
 */
@ConditionalOnMissingBean(WebSecurityConfigurer.class)
@AutoConfigureAfter(SimplejeexSecurityAutoConfigure.class)
@EnableGlobalMethodSecurity(jsr250Enabled = true, prePostEnabled = true)
@EnableWebSecurity
public class SimplejeexSecurityConfiguration extends WebSecurityConfigurerAdapter {
    private static final Logger log = LoggerFactory.getLogger(SimplejeexSecurityConfiguration.class);
    @Autowired
    private ObjectProvider<AuthenticationEntryPoint> authenticationProvider;
    @Autowired
    private ObjectProvider<AccessDeniedHandler> AccessDeniedHandlerProvider;
    @Autowired
    private ObjectProvider<AuthenticationSuccessHandler> authenticationSuccessHandlerProvider;
    @Autowired
    private ObjectProvider<AuthenticationFailureHandler> authenticationFailureHandlerProvider;
    @Autowired
    private ObjectProvider<LogoutSuccessHandler> logoutSuccessHandlerProvider;

    @ConditionalOnMissingBean(PasswordEncoder.class)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter() throws Exception {
        SimplejeexUsernamePasswordAuthenticationFilter filter = new SimplejeexUsernamePasswordAuthenticationFilter();
        filter.setAuthenticationManager(authenticationManagerBean());
        filter.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/api/login", "POST"));
        return filter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .anonymous().disable().
                authorizeRequests()
                .antMatchers("/api/**")
                .authenticated()
                .and()
                .sessionManagement()
                .enableSessionUrlRewriting(false)
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .and()
                .csrf().disable()
                .formLogin()
                .loginProcessingUrl("/api/login")
                .and()
                .logout()
                .invalidateHttpSession(true)
                .logoutUrl("/api/logout");

        UsernamePasswordAuthenticationFilter filter = usernamePasswordAuthenticationFilter();
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        authenticationProvider.ifAvailable(c -> {
            try {
                http.exceptionHandling().authenticationEntryPoint(c);
            } catch (Exception e) {
                if (log.isErrorEnabled()) {
                    log.info("assemble authentication entry point fail", e);
                }
            }
        });

        AccessDeniedHandlerProvider.ifAvailable(c -> {
            try {
                http.exceptionHandling().accessDeniedHandler(c);
            } catch (Exception e) {
                if (log.isErrorEnabled()) {
                    log.error("assemble access denied handler fail.", e);
                }
            }
        });

        authenticationSuccessHandlerProvider.ifAvailable(c -> {
            try {
                http.formLogin().successHandler(c);
                filter.setAuthenticationSuccessHandler(c);
            } catch (Exception e) {
                if (log.isErrorEnabled()) {
                    log.error("assemble login success handler fail.", e);
                }
            }
        });

        authenticationFailureHandlerProvider.ifAvailable(c -> {
            try {
                http.formLogin().failureHandler(c);
                filter.setAuthenticationFailureHandler(c);
            } catch (Exception e) {
                if (log.isErrorEnabled()) {
                    log.error("assemble login failure handle fail.", e);
                }
            }
        });

        logoutSuccessHandlerProvider.ifAvailable(c -> {
            try {
                http.logout().logoutSuccessHandler(c);
            } catch (Exception e) {
                if (log.isErrorEnabled()) {
                    log.error("assemble logout success handler fail.", e);
                }
            }
        });
    }


}