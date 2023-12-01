package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.StoreConverter;
import umc.study.domain.Store;
import umc.study.service.Store.StoreCommandService;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    public ApiResponse<StoreResponseDTO.StoreResultDTO> write(@RequestBody @Valid StoreRequestDTO.StoreDto request){
        Store store = storeCommandService.addStore(request);
        return ApiResponse.onSuccess(StoreConverter.toStoreResultDTO(store));
    }

    @PostMapping("/add/missions")
    public ApiResponse<StoreResponseDTO.StoreResultDTO> addMission(@RequestBody @Valid MissionRequestDTO.MiisionDto request){
        Store store = storeCommandService.addMission(request);
        return ApiResponse.onSuccess(StoreConverter.toStoreResultDTO(store));
    }

}
