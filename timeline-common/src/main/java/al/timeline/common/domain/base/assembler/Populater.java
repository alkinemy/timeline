package al.timeline.common.domain.base.assembler;

public interface Populater<S, T> {

	void populate(S source, T target);

}
