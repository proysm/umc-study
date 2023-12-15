package umc.study.web.controller;

import com.google.protobuf.Api;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MemberConverter;
import umc.study.converter.MemberMissionConverter;
import umc.study.converter.MissionConverter;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.mapping.MemberMission;
import umc.study.service.member_mission.MemberMissionService;
import umc.study.service.mission.MissionCommandService;
import umc.study.validation.annotation.CheckPage;
import umc.study.web.dto.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/missions")
public class MissionController {

    private final MissionCommandService missionCommandService;
    private final MemberMissionService memberMissionService;

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

    @GetMapping("/list/{storeId}/{pageId}")
    public ApiResponse<?> getUserReviewList(@PathVariable(name = "storeId") Long storeId, @CheckPage @PathVariable(name = "pageId") Long pageId){

        // 유효성 검사 실패 시, ExceptionAdvice 클래스에 의해 자동으로 처리됨.

        Pageable pageable = PageRequest.of((int) (pageId - 1), 2); // 페이지 크기: 2
        Page<Mission> missionsPage = missionCommandService.findStoreMission(storeId, pageable);

        List<MissionResponseDTO.MissionResultDTO> missionDtos = missionsPage.getContent().stream()
                .map(MissionConverter::toMissionResultDTO)
                .collect(Collectors.toList());

        MissionRequestDTO.MissionPreViewListDTO data = MissionRequestDTO.MissionPreViewListDTO.builder()
                .missionList(missionDtos)
                .listSize(missionDtos.size())
                .totalPage(missionsPage.getTotalPages())
                .totalElements(missionsPage.getTotalElements())
                .isFirst(missionsPage.isFirst())
                .isLast(missionsPage.isLast())
                .build();

        return ApiResponse.onSuccess(data);
    }


    @GetMapping("/list2/{memberId}/{pageId}")
    public ApiResponse<?> getUserActiveMissionList(@PathVariable(name = "memberId") Long memberId, @CheckPage @PathVariable(name = "pageId") Long pageId){

        // 유효성 검사 실패 시, ExceptionAdvice 클래스에 의해 자동으로 처리됨.

        Pageable pageable = PageRequest.of((int) (pageId - 1), 2); // 페이지 크기: 2
        Page<Mission> missionsPage = memberMissionService.findActiveMission(memberId, pageable);

        List<MissionResponseDTO.MissionResultDTO> missionDtos = missionsPage.getContent().stream()
                .map(MissionConverter::toMissionResultDTO)
                .collect(Collectors.toList());

        MissionRequestDTO.MissionPreViewListDTO data = MissionRequestDTO.MissionPreViewListDTO.builder()
                .missionList(missionDtos)
                .listSize(missionDtos.size())
                .totalPage(missionsPage.getTotalPages())
                .totalElements(missionsPage.getTotalElements())
                .isFirst(missionsPage.isFirst())
                .isLast(missionsPage.isLast())
                .build();

        return ApiResponse.onSuccess(data);
    }

}
