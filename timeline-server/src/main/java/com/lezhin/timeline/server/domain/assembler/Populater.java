package com.lezhin.timeline.server.domain.assembler;

public interface Populater<S, T> {

	void populate(S source, T target);

}
