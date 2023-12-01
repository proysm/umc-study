package umc.study.service.review;

import umc.study.domain.Review;
import umc.study.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {

    Review writeReview(ReviewRequestDTO.ReviewDto request);
}
