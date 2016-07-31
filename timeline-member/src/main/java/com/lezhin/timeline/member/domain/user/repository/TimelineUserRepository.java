package com.lezhin.timeline.member.domain.user.repository;

import com.lezhin.timeline.member.domain.base.repository.TimelineJpaRepository;
import com.lezhin.timeline.member.domain.user.model.TimelineUserEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TimelineUserRepository extends TimelineJpaRepository<TimelineUserEntity, Long> {

	Optional<TimelineUserEntity> findOneByUserLoginId(String loginId);

}
