package umc.study.service.food;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class FoodCategoryServiceImpl implements FoodCategoryService{
    @Override
    public boolean existCategories(List<Long> values) {
        return false;
    }
}
