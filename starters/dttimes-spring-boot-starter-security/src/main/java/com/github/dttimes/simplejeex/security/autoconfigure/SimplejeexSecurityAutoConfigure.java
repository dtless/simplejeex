package com.github.dttimes.simplejeex.security.autoconfigure;

import com.github.dttimes.simplejeex.security.autoconfigure.coc.SimplejeexSecurityConfiguration;
import com.github.dttimes.simplejeex.security.autoconfigure.coc.handler.*;
import com.github.dttimes.simplejeex.security.autoconfigure.coc.mvc.MvcArgumentResolverConfigurer;
import com.github.dttimes.simplejeex.security.autoconfigure.coc.user.SecurityUser;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p><b>Slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-04 16:38<p>
 *
 * @author 王輝
 */
@ConditionalOnClass(SecurityContextHolder.class)
@ConditionalOnWebApplication
@ImportAutoConfiguration(SimplejeexSecurityConfiguration.class)
public class SimplejeexSecurityAutoConfigure {

    @ConditionalOnClass(SecurityUser.class)
    @Bean
    public WebMvcConfigurer mvcConfigurer() {
        return new MvcArgumentResolverConfigurer();
    }

    @ConditionalOnMissingBean(AuthenticationEntryPoint.class)
    @Bean
    public AuthenticationEntryPoint entryPoint() {
        return new SxAuthenticationEntryPoint();
    }

    /**
     * 无权限处理器
     */
    @ConditionalOnMissingBean(AccessDeniedHandler.class)
    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new SxAccessDeniedHandler();
    }

    @ConditionalOnMissingBean(AuthenticationSuccessHandler.class)
    @Bean
    public AuthenticationSuccessHandler successHandler() {
        return new SxAuthenticationSuccessHandler();
    }

    @ConditionalOnMissingBean(AuthenticationFailureHandler.class)
    @Bean
    public AuthenticationFailureHandler failureHandler() {
        return new SxAuthenticationFailureHandler();
    }

    @ConditionalOnMissingBean(LogoutSuccessHandler.class)
    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
        return new SxLogoutSuccessHandler();
    }
}
