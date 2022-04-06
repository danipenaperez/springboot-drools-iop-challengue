package com.dppware.swa.infrastructure.controllers.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.dppware.swa.infrastructure.controllers.filter.JWTAuthorizationFilter;

/**
 * It not only web security, is the whole application security  configuration
 * @author dpena
 *
 */
@Configuration
@EnableGlobalMethodSecurity(
        securedEnabled = true, //Enables @Security annotation
        jsr250Enabled = true, //Enables @RolesAllowed and @PermitAll annotations
        prePostEnabled = true) //@PreAuthorize and @PostAuthorize
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
	@Override
    protected void configure(HttpSecurity http) throws Exception {

    	http.csrf().disable()
		.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
		.authorizeRequests()
		.antMatchers(HttpMethod.POST, "/iop-grd/api/v1/security/login").permitAll()
		.anyRequest().authenticated();
    }
    
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

}
