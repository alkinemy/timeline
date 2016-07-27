package com.lezhin.timeline.server.interfaces.api.message.service;

import com.lezhin.timeline.server.domain.assembler.SmartAssembler;
import com.lezhin.timeline.server.domain.message.dto.TimelineMessageInsertForm;
import com.lezhin.timeline.server.domain.message.service.TimelineMessageFacadeService;
import com.lezhin.timeline.server.interfaces.api.message.dto.TimelineMessageInsertApiForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimelineMessageApiFacadeService {

	@Autowired
	private TimelineMessageFacadeService timelineMessageFacadeService;

	@Autowired
	private SmartAssembler assembler;

	public void post(String loginId, TimelineMessageInsertApiForm insertApiForm) {
		TimelineMessageInsertForm insertForm = assembler.assemble(insertApiForm, TimelineMessageInsertForm.class);
		insertForm.setLoginId(loginId);
		timelineMessageFacadeService.insert(insertForm);
	}

}
