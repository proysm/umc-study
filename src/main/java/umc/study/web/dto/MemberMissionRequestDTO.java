package umc.study.web.dto;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import umc.study.domain.Member;
import umc.study.domain.Mission;

import java.util.Date;

public class MemberMissionRequestDTO {

    @Getter
    public static class JoinDto{
        @NotNull
        Long memberId;
        @NotNull
        Long missionId;


    }
}
