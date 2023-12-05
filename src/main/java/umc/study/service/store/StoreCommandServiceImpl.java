package umc.study.service.store;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.StoreConverter;
import umc.study.domain.Store;
import umc.study.repository.FoodCategoryRepository;
import umc.study.repository.RegionRepository;
import umc.study.repository.StoreRepository;
import umc.study.web.dto.StoreRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional
public class StoreCommandServiceImpl implements StoreCommandService{

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;
    private final FoodCategoryRepository foodCategoryRepository;



    @Override
    @Transactional
    public Store addStore(StoreRequestDTO.JoinDto request) {

        Store newStore = StoreConverter.toStore(request);
        return storeRepository.save(newStore);
    } // 특정 지역에 가게 추가하기
}
