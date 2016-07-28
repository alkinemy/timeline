package com.lezhin.timeline.server.domain.user.repository;

import com.lezhin.timeline.server.domain.base.repository.TimelineJpaRepository;
import com.lezhin.timeline.server.domain.user.model.TimelineUserEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TimelineUserRepository extends TimelineJpaRepository<TimelineUserEntity, Long> {

	Optional<TimelineUserEntity> findOneByLoginId(String loginId);

}
