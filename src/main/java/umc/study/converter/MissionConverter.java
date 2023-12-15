package umc.study.converter;

import javax.validation.constraints.NotNull;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

import java.util.ArrayList;
import java.util.Date;

public class MissionConverter {

    public static MissionResponseDTO.MissionResultDTO toMissionResultDTO(Mission mission){
        return MissionResponseDTO.MissionResultDTO.builder()
                .missionId(mission.getId())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.writeDto request){
        return Mission.builder()
                .reward(request.getReward())
                .deadline(request.getDeadline())
                .missionSpec(request.getMissionSpec())
                .build();
    }
}
