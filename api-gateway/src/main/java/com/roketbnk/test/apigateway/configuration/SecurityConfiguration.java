package com.roketbnk.test.apigateway.configuration;

import com.roketbnk.test.apigateway.security.UaaRemoteAuthenticationManager;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.rcp.RemoteAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UaaRemoteAuthenticationManager authenticationManager;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        RemoteAuthenticationProvider authenticationProvider = new RemoteAuthenticationProvider();
        authenticationProvider.setRemoteAuthenticationManager(authenticationManager);
        auth.authenticationProvider(authenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
            .disable()
            .authorizeRequests()
            .anyRequest()
            .authenticated()
            .and()
            .formLogin()
            .defaultSuccessUrl("/servicea/swagger-ui.html")
            .permitAll()
            .and()
            .logout()
            .permitAll();
    }
}
