package al.timeline.client.domain.base.assembler;

import al.timeline.client.web.base.response.PagedResources;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SmartAssembler extends al.timeline.common.domain.base.assembler.SmartAssembler {

	public <F, T> PagedResources<T> assemble(PagedResources<F> fromPagedResources, Class<T> toClass) {
		if (fromPagedResources == null) {
			return null;
		}
		List<T> content = assemble(fromPagedResources.getContent().stream().collect(Collectors.toList()), toClass);
		return new PagedResources<>(content, fromPagedResources.getMetadata());
	}

	public <F, T> PagedResources<T> assemble(PagedResources<F> fromPagedResources, Class<F> fromClass, Class<T> toClass) {
		if (fromPagedResources == null) {
			return null;
		}
		List<T> content = assemble(fromPagedResources.getContent().stream().collect(Collectors.toList()), fromClass, toClass);
		return new PagedResources<>(content, fromPagedResources.getMetadata());
	}

}
