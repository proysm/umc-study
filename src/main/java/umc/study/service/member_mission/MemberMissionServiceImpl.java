package umc.study.service.member_mission;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Mission;
import umc.study.repository.MemberMissionRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberMissionServiceImpl implements MemberMissionService{

    private final MemberMissionRepository memberMissionRepository;


    @Override
    public Page<Mission> findActiveMission(Long memberId, Pageable pageable){

        return memberMissionRepository.findActiveMission(memberId, pageable);
    }
}
