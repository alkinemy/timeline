package com.lezhin.timeline.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;

//@EnableWebSecurity
//@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.httpBasic()
			.and()
			.csrf().disable()
			.antMatcher("/api/**")
			.authorizeRequests().anyRequest().hasAuthority("ROLE_API")
			.and()
//			.addFilterAfter()
			.exceptionHandling()
			.authenticationEntryPoint(http403ForbiddenEntryPoint());
	}

	@Bean
	private Http403ForbiddenEntryPoint http403ForbiddenEntryPoint() {
		return new Http403ForbiddenEntryPoint();
	}

}
