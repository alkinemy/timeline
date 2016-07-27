package com.lezhin.timeline.server.domain.assembler;

import java.util.List;

public interface ListAssembler<F, T> extends Assembler<F, T> {

	List<T> assemble(List<F> f);

}
