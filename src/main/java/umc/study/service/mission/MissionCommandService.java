package umc.study.service.mission;

import umc.study.domain.Mission;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.MemberMissionRequestDTO;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.ReviewRequestDTO;

public interface MissionCommandService {

    Mission writeMission(MissionRequestDTO.writeDto request);

    MemberMission writeMemberMission(MemberMissionRequestDTO.JoinDto request);
}
