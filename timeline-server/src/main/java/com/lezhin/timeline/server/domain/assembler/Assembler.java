package com.lezhin.timeline.server.domain.assembler;

public interface Assembler<F, T> {

	T assemble(F f);

}
