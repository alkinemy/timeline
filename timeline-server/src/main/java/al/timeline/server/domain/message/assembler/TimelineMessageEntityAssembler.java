package al.timeline.server.domain.message.assembler;

import al.timeline.common.domain.base.assembler.AbstractAssembler;
import al.timeline.server.domain.base.assembler.SmartAssembler;
import al.timeline.server.domain.message.dto.TimelineMessageInsertForm;
import al.timeline.server.domain.message.model.TimelineMessageEntity;
import al.timeline.server.domain.common.user.TimelineUser;
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
