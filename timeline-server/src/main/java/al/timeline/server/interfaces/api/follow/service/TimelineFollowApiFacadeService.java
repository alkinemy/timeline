package al.timeline.server.interfaces.api.follow.service;

import al.timeline.server.domain.base.assembler.SmartAssembler;
import al.timeline.server.domain.follow.dto.TimelineFollowDeleteForm;
import al.timeline.server.domain.follow.dto.TimelineFollowInsertForm;
import al.timeline.server.domain.follow.service.TimelineFollowFacadeService;
import al.timeline.server.interfaces.api.user.dto.TimelineUserDto;
import al.timeline.server.domain.common.user.TimelineUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimelineFollowApiFacadeService {

	@Autowired
	private TimelineFollowFacadeService timelineFollowFacadeService;

	@Autowired
	private SmartAssembler assembler;

	public List<TimelineUserDto> getFollowings(TimelineUserDto user) {
		List<TimelineUser> followings = timelineFollowFacadeService.getFollowings(user.getLoginId());
		return assembler.assemble(followings, TimelineUserDto.class);
	}

	public List<TimelineUserDto> getFollowers(TimelineUserDto user) {
		List<TimelineUser> followers = timelineFollowFacadeService.getFollowers(user.getLoginId());
		return assembler.assemble(followers, TimelineUserDto.class);
	}

	public void follow(TimelineFollowInsertForm insertForm) {
		timelineFollowFacadeService.insert(insertForm);
	}

	public void unfollow(TimelineFollowDeleteForm deleteForm) {
		timelineFollowFacadeService.delete(deleteForm);
	}

}
