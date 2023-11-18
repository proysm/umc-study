package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.Gender;
import umc.study.domain.enums.MemberStatus;
import umc.study.domain.enums.SocialType;

import java.time.LocalDate;

@Entity
@Getter
@Builder // 아래의 어노테이션은 Builder 패턴을 사용하기 위함
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // JPA가 통신하는 DBMS의 방식을 따른다는 뜻(나는 MYSQL을 따르게 된다.)
    private Long id;

    private String name;

    private String address;

    private String specAddress;     // 테이블에서는 spec_address인데 여기에서는 specAddress이다.
                                    // 순수 JPA와 달리 Spring data JPA를 사용하면, 실제 DB에 적용시 specAddress를 spec_address로 바꿔준다.

    @Enumerated(EnumType.STRING)    // 반드시 EnumType을 STRING으로 해야한다.
    private Gender gender;          // 기본 값인 ORDINAL을 사용하면 데이터베이스에 enum의 순서가 저장이 되는데,
                                    // 만약 Springboot에서 enum의 순서를 바꾸게 될 경우 에러가 생긴다.

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Enumerated(EnumType.STRING)
    private MemberStatus status;

    private LocalDate inactiveDate;

    private String email;

    private Integer point;
}
