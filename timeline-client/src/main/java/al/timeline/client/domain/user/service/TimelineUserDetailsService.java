package al.timeline.client.domain.user.service;

import al.timeline.client.domain.user.model.TimelineUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
	private TimelineUserAdapterService timelineUserAdapterService;

	@Override
	public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
		return Optional.ofNullable(timelineUserAdapterService.getUserDetails(loginId))
			.map(user -> {
				List<GrantedAuthority> authorities = new ArrayList<>();
				authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
				return new TimelineUser(user.getLoginId(), user.getPassword(), user.getName(), authorities);
			}).orElseThrow(() -> new UsernameNotFoundException("User " + loginId + " was not found"));
	}

}
