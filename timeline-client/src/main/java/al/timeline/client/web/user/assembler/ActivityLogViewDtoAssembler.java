package al.timeline.client.web.user.assembler;

import al.timeline.client.domain.activity.dto.ActivityLogDto;
import al.timeline.client.web.user.dto.ActivityLogViewDto;
import al.timeline.common.domain.base.assembler.AbstractListAssembler;
import org.springframework.stereotype.Component;

@Component
public class ActivityLogViewDtoAssembler extends AbstractListAssembler<ActivityLogDto, ActivityLogViewDto> {

	@Override
	protected ActivityLogViewDto doAssemble(ActivityLogDto logDto) {
		ActivityLogViewDto logViewDto = new ActivityLogViewDto();
		logViewDto.setActivityDate(logDto.getActivityDate());
		logViewDto.setMessage(logDto.buildMessage());
		logViewDto.setLinkUrl(logDto.buildLink());
		return logViewDto;
	}

}
