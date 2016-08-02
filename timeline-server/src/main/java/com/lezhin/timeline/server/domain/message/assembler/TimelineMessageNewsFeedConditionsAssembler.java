package com.lezhin.timeline.server.domain.message.assembler;

import com.lezhin.timeline.common.domain.base.assembler.AbstractAssembler;
import com.lezhin.timeline.server.domain.message.dto.NewsFeedConditions;
import com.lezhin.timeline.server.domain.message.dto.TimelineUserMessageSearchConditions;
import com.lezhin.timeline.server.domain.message.model.TimelineMessageEntity;
import com.lezhin.timeline.server.domain.message.service.TimelineMessageFacadeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TimelineMessageNewsFeedConditionsAssembler extends AbstractAssembler<TimelineUserMessageSearchConditions, NewsFeedConditions> {

	@Autowired
	private TimelineMessageFacadeService timelineMessageFacadeService;

	@Override
	protected NewsFeedConditions doAssemble(TimelineUserMessageSearchConditions searchConditions) {
		NewsFeedConditions newsFeedConditions = new NewsFeedConditions();
		BeanUtils.copyProperties(searchConditions, newsFeedConditions);
		if (StringUtils.isNotBlank(searchConditions.getLastTimelineMessageId())) {
			TimelineMessageEntity message = timelineMessageFacadeService.getTimelineMessage(searchConditions.getLastTimelineMessageId());
			newsFeedConditions.setLastTimelineMessageId(message.getId());
		}
		return newsFeedConditions;
	}

}
