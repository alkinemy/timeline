package al.timeline.member.domain.user.repository;

import al.timeline.member.domain.user.model.TimelineUserEntity;
import al.timeline.member.domain.base.repository.TimelineJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TimelineUserRepository extends TimelineJpaRepository<TimelineUserEntity, Long> {

	Optional<TimelineUserEntity> findOneByUserLoginId(String loginId);

}
