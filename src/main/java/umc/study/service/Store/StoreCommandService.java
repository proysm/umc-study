package umc.study.service.Store;

import umc.study.domain.Store;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.StoreRequestDTO;

public interface StoreCommandService {

    Store addStore(StoreRequestDTO.StoreDto request);
    Store addMission(MissionRequestDTO.MiisionDto request);
}
