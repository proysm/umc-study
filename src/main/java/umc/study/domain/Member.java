package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.Gender;
import umc.study.domain.enums.MemberStatus;
import umc.study.domain.enums.SocialType;
import umc.study.domain.mapping.MemberAgree;
import umc.study.domain.mapping.MemberMission;
import umc.study.domain.mapping.MemberPrefer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder // 아래의 어노테이션은 Builder 패턴을 사용하기 위함
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // JPA가 통신하는 DBMS의 방식을 따른다는 뜻(나는 MYSQL을 따르게 된다.)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 40)
    private String address;

    @Column(nullable = false, length = 40)
    private String specAddress;     // 테이블에서는 spec_address인데 여기에서는 specAddress이다.
                                    // 순수 JPA와 달리 Spring data JPA를 사용하면, 실제 DB에 적용시 specAddress를 spec_address로 바꿔준다.

    @Column(columnDefinition = "VARCHAR(10)")
    @Enumerated(EnumType.STRING)    // 반드시 EnumType을 STRING으로 해야한다.
    private Gender gender;          // 기본 값인 ORDINAL을 사용하면 데이터베이스에 enum의 순서가 저장이 되는데,
                                    // 만약 Springboot에서 enum의 순서를 바꾸게 될 경우 에러가 생긴다.

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")  // @Column(nullable = false, length = 40) 이렇게도 가능
                                                                // 무조건 ''로 묶어야됨!! 아니면 DDL을 날림
    @Enumerated(EnumType.STRING)
    private MemberStatus status;

    private LocalDate inactiveDate;

    @Column(nullable = false, length = 50)
    private String email;

    private Integer point;

    // 양방향 매핑의 경우 1:N에서 1에 해당하는 엔티티에게 설정한다.
    // mappedBy 는 N에 해당하는 엔티티에서 ManyToOne이 설정된 멤버변수를 mappedBy 한다.
    // CascadeType.ALL이란 Member의 변화에 따라 MemberAgree 등의 엔티티가 영향을 받는 것을 의미한다.
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberAgree> memberAgreeList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberPrefer> memberPreferList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();
}
