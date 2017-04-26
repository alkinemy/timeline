package al.timeline.common.domain.base.assembler;

import java.util.List;

public interface ListAssembler<F, T> extends Assembler<F, T> {

	List<T> assemble(List<F> f);

}
