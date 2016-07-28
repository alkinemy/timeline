package com.lezhin.timeline.server.domain.base.assembler;

public interface Populater<S, T> {

	void populate(S source, T target);

}
