package umc.study.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {


    @Query("SELECT m.mission FROM MemberMission m WHERE m.member.id = :memberId AND m.status = 'COMPLETE'")
    Page<Mission> findActiveMission(Long memberId, Pageable pageable);
}
