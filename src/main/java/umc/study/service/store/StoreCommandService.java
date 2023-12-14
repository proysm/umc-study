package umc.study.service.store;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.web.dto.StoreRequestDTO;

import java.util.Optional;

@Service
public interface StoreCommandService {

    @Transactional
    Store addStore(StoreRequestDTO.JoinDto request);


    Optional<Store> findStore(Long id);

    Page<Review> getReviewList(Long StoreId, Integer page);
}
