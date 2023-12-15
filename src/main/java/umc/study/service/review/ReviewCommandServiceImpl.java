package umc.study.service.review;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.repository.MemberRepository;
import umc.study.repository.ReviewRepository;
import umc.study.web.dto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewCommandServiceImpl implements ReviewCommandService{

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;

    @Override
    public Review writeReview(ReviewRequestDTO.ReviewDto request) {

        Review newReview = ReviewConverter.toReview(request);
        return reviewRepository.save(newReview);
    } // 가게에 리뷰 추가하기

    @Override
    public Page<Review> findMemberReview(Long storeId, Pageable pageable) {

        return reviewRepository.findAllByStoreId(storeId, pageable);
    } // 가게에 리뷰 추가하기
}
