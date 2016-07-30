package com.lezhin.timeline.server.domain.activity.repository;

import com.lezhin.timeline.server.domain.activity.model.ActivityLogEntity;
import com.lezhin.timeline.server.domain.base.repository.TimelineJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLogRepository extends TimelineJpaRepository<ActivityLogEntity,Long> {
}
