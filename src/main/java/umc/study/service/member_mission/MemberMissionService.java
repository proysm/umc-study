package umc.study.service.member_mission;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.study.domain.Mission;

public interface MemberMissionService {
    Page<Mission> findActiveMission(Long userId, Pageable pageable);
}
