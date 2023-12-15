package umc.study.service.review;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.study.domain.Review;
import umc.study.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {

    Review writeReview(ReviewRequestDTO.ReviewDto request);

    Page<Review> findMemberReview(Long memberId, Pageable pageable);
}
