package com.github.dttimes.simplejeex.security.autoconfigure.coc.mvc;

import com.github.dttimes.simplejeex.security.autoconfigure.coc.user.SecurityUser;
import jdk.nashorn.internal.ir.IfNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * 用于当前登录用户的自动注入
 *
 * <p><b>Slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-04 17:16<p>
 *
 * @author 王輝
 */
public class MvcArgumentResolverConfigurer implements WebMvcConfigurer {
    private static final Logger log = LoggerFactory.getLogger(MvcArgumentResolverConfigurer.class);

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        HandlerMethodArgumentResolver resolver = new HandlerMethodArgumentResolver() {
            @Override
            public boolean supportsParameter(MethodParameter parameter) {
                return SecurityUser.class.isAssignableFrom(parameter.getParameterType());
            }

            @Override
            public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
                Object principal = Optional.ofNullable(SecurityContextHolder.getContext())
                        .map(SecurityContext::getAuthentication)
                        .map(Authentication::getPrincipal)
                        .orElse(null);
                if (Objects.isNull(principal) && log.isWarnEnabled()) {
                    log.warn("inject login user Fail.");
                }
                return principal;
            }
        };
        resolvers.add(resolver);
    }
}
