package com.lezhin.timeline.client.domain.user.service;

import com.lezhin.timeline.client.config.TimelineServerRestProperties;
import com.lezhin.timeline.client.domain.user.dto.TimelineUserFollowForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TimelineFollowAdapterService {

	@Autowired
	private RestTemplate timelineRestTemplate;

	@Autowired
	private RetryTemplate timelineRetryTemplate;

	@Autowired
	private TimelineServerRestProperties timelineServerRestProperties;

	public void addFollowing(TimelineUserFollowForm followForm) {
		String url = new StringBuilder().append(timelineServerRestProperties.getBaseUrl()).append("/follows/follow").toString();
		timelineRetryTemplate.execute(context -> timelineRestTemplate.postForObject(url, followForm, Void.class));
	}

	public void removeFollowing(TimelineUserFollowForm followForm) {
		String url = new StringBuilder().append(timelineServerRestProperties.getBaseUrl()).append("/follows/unfollow").toString();
		timelineRetryTemplate.execute(context -> timelineRestTemplate.postForObject(url, followForm, Void.class));
	}
}
