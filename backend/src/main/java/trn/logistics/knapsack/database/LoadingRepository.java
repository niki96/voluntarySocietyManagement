package trn.logistics.knapsack.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trn.logistics.knapsack.dto.Loading;

@Repository
public interface LoadingRepository extends JpaRepository<Loading, Long> {
}
