package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Region;
import umc.study.domain.Store;

import java.util.Optional;

public interface RegionRepository extends JpaRepository<Region, Long> {

}
