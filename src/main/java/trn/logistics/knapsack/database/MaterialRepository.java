package trn.logistics.knapsack.database;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import trn.logistics.knapsack.dto.Material;

@Repository
public interface MaterialRepository extends CrudRepository<Material, Long> {

    @Query
    Material findByName(String name);
}
