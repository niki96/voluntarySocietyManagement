package trn.logistics.knapsack.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trn.logistics.knapsack.dto.KnapsackSolution;

@Repository
public interface KnapsackSolutionRepository extends JpaRepository<KnapsackSolution, Long> {
}
