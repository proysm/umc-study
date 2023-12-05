package umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class StoreRequestDTO {

    @Getter
    public static class JoinDto{
        @NotNull
        Long regionId;
        @NotBlank
        String name;
        @NotBlank
        String address;
        @NotNull
        Float score;
    }
}
