package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class TempResponse {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TempTestDTO{
        String testString;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TempExceptionDTO{
        Integer flag;
    }
    // public static class?
    // DTO들은 큰 묶음으로 클래스를 만들고, 내부적으로 static 클래스를 만드는 것이 좋다.
    // DTO는 활용 빈도가 높기 때문에 static class로 만들게 되면 범용적으로 DTO를 사용할 수 있다.

    // DTO에도 빌더 패턴?
    // 우리가 만드는 인스턴스들은 모두 빌더 패턴을 사용한다고 생각하면 된다.
    // 참고) RequestDTO는 우리가 만드는 것이 아닌, 프론트엔드에서 만든 객체를 받기 위함이다.
    // 따라서 RequestDTO는 빌더 패턴을 적용할 필요가 없다.
}
