package com.switchfully.order.spring_exercise.security;

import com.switchfully.order.spring_exercise.domain.user.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
public class SecureUser implements UserDetails {
    private List<GrantedAuthority> authorities;
    private final User user;

    public SecureUser(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        setAuthorities(user.getSecurityInformation().getUserRole().name());
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getSecurityInformation().getPassword();
    }

    @Override
    public String getUsername() {
        return user.getSecurityInformation().getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setAuthorities(String... roles) {
        List<GrantedAuthority> authorities = new ArrayList(roles.length);
        String[] allRoles = roles;
        int var4 = roles.length;

        for (int index = 0; index < var4; ++index) {
            String role = allRoles[index];
            Assert.isTrue(!role.startsWith("ROLE_"), () -> role + " cannot start with ROLE_ (it is automatically added)");
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        }
        this.authorities = authorities;
    }
}
