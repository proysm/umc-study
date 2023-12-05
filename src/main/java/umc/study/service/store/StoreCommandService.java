package umc.study.service.store;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Store;
import umc.study.web.dto.StoreRequestDTO;

@Service
public interface StoreCommandService {

    @Transactional
    Store addStore(StoreRequestDTO.JoinDto request);
}
