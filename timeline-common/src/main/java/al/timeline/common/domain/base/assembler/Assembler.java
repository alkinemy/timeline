package al.timeline.common.domain.base.assembler;

public interface Assembler<F, T> {

	T assemble(F f);

}
