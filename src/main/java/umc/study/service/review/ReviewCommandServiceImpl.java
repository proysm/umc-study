package umc.study.service.review;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.ReviewConverter;
import umc.study.converter.StoreConverter;
import umc.study.domain.Review;
import umc.study.repository.ReviewRepository;
import umc.study.web.dto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewCommandServiceImpl implements ReviewCommandService{

    private final ReviewRepository reviewRepository;
    @Override
    public Review writeReview(ReviewRequestDTO.ReviewDto request) {

        Review newReview = ReviewConverter.toReview(request);
        return reviewRepository.save(newReview);
    } // 가게에 리뷰 추가하기
}
