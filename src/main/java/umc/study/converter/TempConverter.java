package umc.study.converter;

import umc.study.web.dto.TempResponse;

public class TempConverter {

    // 컨버터 함수 이름은 to<만들려는 대상> 이렇게 지어야 한다.
    public static TempResponse.TempTestDTO toTempTestDTO(){
        return TempResponse.TempTestDTO.builder()
                .testString("This is Test!")
                .build();
    }

    public static TempResponse.TempExceptionDTO toTempExceptionDTO(Integer flag){
        return TempResponse.TempExceptionDTO.builder()
                .flag(flag)
                .build();
    }
}
