package umc.study.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.study.validation.annotation.ExistStore;

public class ReviewRequestDTO {

    @Getter
    public static class ReviewDto{
        @NotNull
        Long memberId;
        @ExistStore
        @NotNull
        Long storeId;
        @NotNull
        Float score;
        @NotNull
        String text;
        @NotNull
        String title;
    }

    @Getter
    public static class MemberReivew{
        Long pageId;
        Long userId;
    }
}
