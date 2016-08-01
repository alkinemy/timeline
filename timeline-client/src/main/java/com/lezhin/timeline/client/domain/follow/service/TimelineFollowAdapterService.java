package com.lezhin.timeline.client.domain.follow.service;

import com.lezhin.timeline.client.config.TimelineServerRestProperties;
import com.lezhin.timeline.client.domain.follow.dto.TimelineFollowInsertForm;
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

	public void addFollowing(TimelineFollowInsertForm followInsertForm) {
		String url = new StringBuilder().append(timelineServerRestProperties.getBaseUrl()).append("/follows").toString();
		timelineRetryTemplate.execute(context -> timelineRestTemplate.postForObject(url, followInsertForm, Void.class));
	}

}
