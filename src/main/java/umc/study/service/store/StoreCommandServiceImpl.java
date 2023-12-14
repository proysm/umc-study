package umc.study.service.store;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.StoreConverter;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.FoodCategoryRepository;
import umc.study.repository.RegionRepository;
import umc.study.repository.ReviewRepository;
import umc.study.repository.StoreRepository;
import umc.study.web.dto.StoreRequestDTO;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class StoreCommandServiceImpl implements StoreCommandService{

    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;
    private final RegionRepository regionRepository;
    private final FoodCategoryRepository foodCategoryRepository;



    @Override
    @Transactional
    public Store addStore(StoreRequestDTO.JoinDto request) {

        Store newStore = StoreConverter.toStore(request);
        return storeRepository.save(newStore);
    } // 특정 지역에 가게 추가하기

    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public Page<Review> getReviewList(Long StoreId, Integer page) {
        Store store = storeRepository.findById(StoreId).get();

        Page<Review> StorePage = reviewRepository.findAllByStore(store, PageRequest.of(page, 10));
        return StorePage;
    }
}
