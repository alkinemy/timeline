package com.lezhin.timeline.member.domain.base.assembler;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SmartAssembler extends com.lezhin.timeline.common.domain.base.assembler.SmartAssembler {

	public <F, T> Page<T> assemble(Pageable pageable, Page<F> fromList, Class<T> toClass) {
		if (fromList == null) {
			return null;
		}
		List<T> content = assemble(fromList.getContent(), toClass);
		return new PageImpl<>(content, pageable, fromList.getTotalElements());
	}

	public <F, T> Page<T> assemble(Pageable pageable, Page<F> fromList, Class<F> fromClass, Class<T> toClass) {
		if (fromList == null) {
			return null;
		}
		List<T> content = assemble(fromList.getContent(), fromClass, toClass);
		return new PageImpl<>(content, pageable, fromList.getTotalElements());
	}

}
