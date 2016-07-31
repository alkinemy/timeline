package com.lezhin.timeline.client.domain.user.service;

import com.lezhin.timeline.client.domain.message.service.TimelineMemberAdapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TimelineUserDetailsService implements UserDetailsService {

	@Autowired
	private TimelineMemberAdapterService timelineMemberAdapterService;

	@Override
	public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
		return Optional.ofNullable(timelineMemberAdapterService.getUser(loginId))
			.map(user -> {
				List<GrantedAuthority> authorities = new ArrayList<>();
				authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
				return new User(user.getLoginId(), user.getPassword(), authorities);
			}).orElseThrow(() -> new UsernameNotFoundException("User " + loginId + " was not found"));
	}

}
