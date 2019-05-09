package com.roketbnk.test.apigateway.security;

import com.roketbnk.test.apigateway.security.adapter.UaaComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.rcp.RemoteAuthenticationException;
import org.springframework.security.authentication.rcp.RemoteAuthenticationManager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UaaRemoteAuthenticationManager implements RemoteAuthenticationManager {

    private final UaaComponent uaaComponent;

    @Override
    public Collection<? extends GrantedAuthority> attemptAuthentication(String username, String password)
        throws RemoteAuthenticationException {
        List<String> roles = uaaComponent.auth(username, password);
        if (roles.isEmpty()) {
            throw new RemoteAuthenticationException("Login failed!");
        }
        return roles.stream()
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());
    }
}
