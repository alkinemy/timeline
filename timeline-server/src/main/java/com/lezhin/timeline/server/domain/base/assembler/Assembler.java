package com.lezhin.timeline.server.domain.base.assembler;

public interface Assembler<F, T> {

	T assemble(F f);

}
