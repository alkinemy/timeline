package com.lezhin.timeline.common.domain.base.assembler;

import org.springframework.beans.BeanUtils;

public class DefaultPopulater implements Populater<Object, Object> {

	@Override public void populate(Object source, Object target) {
		BeanUtils.copyProperties(source, target);
	}

}
