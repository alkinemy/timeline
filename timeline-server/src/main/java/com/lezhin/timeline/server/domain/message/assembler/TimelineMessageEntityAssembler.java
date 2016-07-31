package com.lezhin.timeline.server.domain.message.assembler;

import com.lezhin.timeline.common.domain.base.assembler.AbstractAssembler;
import com.lezhin.timeline.server.domain.base.assembler.SmartAssembler;
import com.lezhin.timeline.server.domain.common.user.TimelineUser;
import com.lezhin.timeline.server.domain.message.dto.TimelineMessageInsertForm;
import com.lezhin.timeline.server.domain.message.model.TimelineMessageEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TimelineMessageEntityAssembler extends AbstractAssembler<TimelineMessageInsertForm, TimelineMessageEntity> {

	@Autowired
	private SmartAssembler assembler;

	@Override
	protected TimelineMessageEntity doAssemble(TimelineMessageInsertForm insertForm) {
		TimelineMessageEntity message = new TimelineMessageEntity();
		BeanUtils.copyProperties(insertForm, message);
		TimelineUser author = assembler.assemble(insertForm.getUser(), TimelineUser.class);
		message.setAuthor(author);
		return message;
	}

}
