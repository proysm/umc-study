package umc.study.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.Date;

public class MissionRequestDTO {

    @Getter
    public static class writeDto{
        @NotNull
        Long storeId;
        @NotNull
        Integer reward;
        @NotNull
        Date deadline;
        @NotNull
        String missionSpec;
    }
}
