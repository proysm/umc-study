package umc.study.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class ReviewDto{
        @NotNull
        Long memberId;
        @NotNull
        Long storeId;
        @NotNull
        Long score;
        @NotNull
        String text;
    }
}
