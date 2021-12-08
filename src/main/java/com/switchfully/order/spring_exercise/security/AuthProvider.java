package com.switchfully.order.spring_exercise.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AuthProvider implements AuthenticationProvider {

    private final SecurityService securityService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthProvider(SecurityService securityService, PasswordEncoder passwordEncoder) {
        this.securityService = securityService;
        this.passwordEncoder = passwordEncoder;
    }

    /**The authentication logic to use*/
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        SecureUser secureUser = securityService.loadUserByUsername(username);

        if (passwordEncoder.matches(password, secureUser.getPassword())) {
            return new UsernamePasswordAuthenticationToken(
                    secureUser.getUsername(),
                    secureUser.getPassword(),
                    secureUser.getAuthorities());
        } else {
            throw new BadCredentialsException("Bad Credentials");
        }
    }

    /**What kind of authentication object it supports*/
    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class
                .isAssignableFrom(authentication);
    }
}
