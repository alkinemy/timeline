package com.lezhin.timeline.client.domain.user.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ActivityLogDto {

	private TimelineUserDto from;
	private String message;
	//TODO link url 생성 방식 수정 필요 -> DB에 저장하면 안될것같음, data 필드를 놓고 json으로 저장하는게 나을듯...
	private String linkUrl;
	private LocalDateTime createdDate;

}
