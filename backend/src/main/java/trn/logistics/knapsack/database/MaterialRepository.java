package trn.logistics.knapsack.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import trn.logistics.knapsack.dto.Material;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {

    @Query
    Material findByName(String name);
}
