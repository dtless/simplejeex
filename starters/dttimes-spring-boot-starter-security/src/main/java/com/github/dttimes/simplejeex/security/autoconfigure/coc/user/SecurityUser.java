package com.github.dttimes.simplejeex.security.autoconfigure.coc.user;

import com.google.common.collect.Lists;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * <p><b>Slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-04 17:11<p>
 *
 * @author 王輝
 */
public class SecurityUser implements UserDetails {
    /**
     * 用户ID
     */
    private Long id;
    /**
     * 权限列表
     */
    private List<GrantedAuthority> authorities;
    /**
     * 密码
     */
    private String password;
    /**
     * 登录名
     */
    private String username;
    /**
     * 账号是否锁定
     */
    private boolean accountLocked;

    /**
     * 账号是否可用
     */
    private boolean enabled;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public List<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.accountLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public SecurityUser() {
        this.authorities = Lists.newArrayList();
        this.accountLocked = false;
        this.enabled = true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isAccountLocked() {
        return accountLocked;
    }

    public void setAccountLocked(boolean accountLocked) {
        this.accountLocked = accountLocked;
    }
}
