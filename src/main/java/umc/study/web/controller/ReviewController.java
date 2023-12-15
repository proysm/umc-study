package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import javax.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Review;
import umc.study.service.review.ReviewCommandService;
import umc.study.validation.annotation.CheckPage;
import umc.study.validation.annotation.ExistStore;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;
import umc.study.web.dto.StoreRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/write")
    public ApiResponse<ReviewResponseDTO.ReviewResultDTO> write(@RequestBody @Valid ReviewRequestDTO.ReviewDto request){
        Review review = reviewCommandService.writeReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toReviewResultDTO(review));
    }

    @GetMapping("/{storeId}")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요") // API에 대한 설명을 넣게 되며 summary, description으로 설명을 적는다.
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<StoreRequestDTO.ReviewPreViewListDTO> getReviewList(@ExistStore @PathVariable(name = "storeId") Long storeId){
        return null;
    }

    @GetMapping("/list/{memberId}/{pageId}")
    public ApiResponse<?> getUserReviewList(@PathVariable(name = "memberId") Long memberId, @CheckPage @PathVariable(name = "pageId") Long pageId){

        // 유효성 검사 실패 시, ExceptionAdvice 클래스에 의해 자동으로 처리됨.

        Pageable pageable = PageRequest.of((int) (pageId - 1), 2); // 페이지 크기: 2
        Page<Review> reviewsPage = reviewCommandService.findMemberReview(memberId, pageable);

        List<ReviewResponseDTO.ReviewResultDTO> reviewDtos = reviewsPage.getContent().stream()
                .map(ReviewConverter::toReviewResultDTO)
                .collect(Collectors.toList());

        StoreRequestDTO.ReviewPreViewListDTO data = StoreRequestDTO.ReviewPreViewListDTO.builder()
                .reviewList(reviewDtos)
                .listSize(reviewDtos.size())
                .totalPage(reviewsPage.getTotalPages())
                .totalElements(reviewsPage.getTotalElements())
                .isFirst(reviewsPage.isFirst())
                .isLast(reviewsPage.isLast())
                .build();

        return ApiResponse.onSuccess(data);
    }
}
