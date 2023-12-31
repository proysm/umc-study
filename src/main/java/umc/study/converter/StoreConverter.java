package umc.study.converter;

import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class StoreConverter {

    public static StoreResponseDTO.StoreResultDTO toStoreResultDTO(Store store){
        return StoreResponseDTO.StoreResultDTO.builder()
                .storeId(store.getId())
                .build();
    }

    public static Store toStore(StoreRequestDTO.JoinDto store){
        return Store.builder()
                .name(store.getName())
                .score(store.getScore())
                .address(store.getAddress())
                .build();
    }

}
