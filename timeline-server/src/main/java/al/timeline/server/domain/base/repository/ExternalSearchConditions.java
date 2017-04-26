package al.timeline.server.domain.base.repository;

import com.mysema.query.types.Predicate;

public interface ExternalSearchConditions<C> {

	Predicate toPredicate(C context);

}
