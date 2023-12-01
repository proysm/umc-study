package umc.study.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.Date;

public class MissionRequestDTO {

    @Getter
    public static class MiisionDto{
        @NotNull
        Long storeId;
        @NotNull
        Long reward;
        @NotNull
        Date deadline;
        @NotNull
        String missionSpec;
    }
}
