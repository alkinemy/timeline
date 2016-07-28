package com.lezhin.timeline.server.domain.message.assembler;

import com.lezhin.timeline.server.domain.base.assembler.AbstractAssembler;
import com.lezhin.timeline.server.domain.message.dto.TimelineMessageInsertForm;
import com.lezhin.timeline.server.domain.message.model.TimelineMessageEntity;
import com.lezhin.timeline.server.domain.user.model.TimelineUser;
import com.lezhin.timeline.server.domain.user.service.TimelineUserFacadeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TimelineMessageEntityAssembler extends AbstractAssembler<TimelineMessageInsertForm, TimelineMessageEntity> {

	@Autowired
	private TimelineUserFacadeService timelineUserFacadeService;

	@Override
	protected TimelineMessageEntity doAssemble(TimelineMessageInsertForm insertForm) {
		TimelineMessageEntity message = new TimelineMessageEntity();
		BeanUtils.copyProperties(insertForm, message);
		TimelineUser author = timelineUserFacadeService.getTimelineUser(insertForm.getLoginId()).getUser();
		message.setAuthor(author);
		return message;
	}

}
