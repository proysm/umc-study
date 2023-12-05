package umc.study.web.controller;

import com.google.protobuf.Api;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MemberConverter;
import umc.study.converter.MemberMissionConverter;
import umc.study.converter.MissionConverter;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.mapping.MemberMission;
import umc.study.service.mission.MissionCommandService;
import umc.study.web.dto.*;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/missions")
public class MissionController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/write")
    public ApiResponse<MissionResponseDTO.MissionResultDTO> write(@RequestBody @Valid MissionRequestDTO.writeDto request){
        Mission mission = missionCommandService.writeMission(request);
        return ApiResponse.onSuccess(MissionConverter.toMissionResultDTO(mission));
    } // 가게에 미션 추가하기

    @PostMapping("/write/member")
    public ApiResponse<MemberMissionResponseDTO.MemberMissionResultDTO> memberWrite(@RequestBody @Valid MemberMissionRequestDTO.JoinDto request){
        MemberMission memberMission = missionCommandService.writeMemberMission(request);
        return ApiResponse.onSuccess(MemberMissionConverter.toMemberMissionResultDTO(memberMission));
    }



}
