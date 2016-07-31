package com.lezhin.timeline.server.domain.follow.repository;

import com.lezhin.timeline.server.domain.base.repository.TimelineJpaRepository;
import com.lezhin.timeline.server.domain.follow.model.TimelineFollowEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TimelineFollowRepository extends TimelineJpaRepository<TimelineFollowEntity, Long> {

	List<TimelineFollowEntity> findAllByFollowerLoginId(String loginId);

	Optional<TimelineFollowEntity> findOneByFollowerLoginIdAndFollowingLoginId(String loginId, String followingLoginId);

}
