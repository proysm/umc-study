package umc.study.converter;

import umc.study.domain.FoodCategory;
import umc.study.domain.mapping.MemberPrefer;

import java.util.List;
import java.util.stream.Collectors;

public class MemberPreferConverter {

    public static List<MemberPrefer> toMemberPreferList(List<FoodCategory> foodCategoryList){

        return foodCategoryList.stream()
                .map(foodCategory ->
                        MemberPrefer.builder()
                                .foodCategory(foodCategory)
                                .build()
                        ).collect(Collectors.toList());
    }
}
// 양방향 연관 관계 설정은 Converter 보다는 service에서 하는 것이 좋다.
// 단방향은 Converter에서 설정을 해도 괜찮다.
