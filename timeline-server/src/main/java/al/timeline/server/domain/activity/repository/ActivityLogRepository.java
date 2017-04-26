package al.timeline.server.domain.activity.repository;

import al.timeline.server.domain.base.repository.TimelineJpaRepository;
import al.timeline.server.domain.activity.model.ActivityLogEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLogRepository extends TimelineJpaRepository<ActivityLogEntity,Long> {

	Page<ActivityLogEntity> findAllByToLoginId(String loginId, Pageable pageable);

}
