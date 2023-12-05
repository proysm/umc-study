package umc.study.service.mission;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.MemberMissionConverter;
import umc.study.converter.MissionConverter;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.mapping.MemberMission;
import umc.study.repository.MemberMissionRepository;
import umc.study.repository.MemberRepository;
import umc.study.repository.MissionRepository;
import umc.study.web.dto.MemberMissionRequestDTO;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.ReviewRequestDTO;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MissionCommandServiceImpl implements MissionCommandService{

    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;

    @Override
    public Mission writeMission(MissionRequestDTO.writeDto request) {

        Mission newMission = MissionConverter.toMission(request);
        return missionRepository.save(newMission);
    } // 가게에 리뷰 추가하기

    @Override
    public MemberMission writeMemberMission(MemberMissionRequestDTO.JoinDto request) {

        Long memberId = request.getMemberId();
        Long missionId = request.getMissionId();
        Optional<Member> member = memberRepository.findById(memberId);
        Optional<Mission> mission = missionRepository.findById(missionId);

        MemberMission newMemberMission = MemberMissionConverter.toMemberMission(member.get(), mission.get());
        return memberMissionRepository.save(newMemberMission);
    }

}
