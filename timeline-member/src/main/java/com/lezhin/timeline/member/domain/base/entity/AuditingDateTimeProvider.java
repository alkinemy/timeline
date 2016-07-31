package com.lezhin.timeline.member.domain.base.entity;

import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Service
public class AuditingDateTimeProvider implements DateTimeProvider {

	@Override
	public Calendar getNow() {
		return GregorianCalendar.from(ZonedDateTime.now());
	}

}
