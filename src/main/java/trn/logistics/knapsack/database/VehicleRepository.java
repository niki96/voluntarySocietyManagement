package trn.logistics.knapsack.database;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import trn.logistics.knapsack.dto.Vehicle;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
}
