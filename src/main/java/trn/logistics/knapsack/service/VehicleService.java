package trn.logistics.knapsack.service;

import org.springframework.stereotype.Service;
import trn.logistics.knapsack.database.VehicleRepository;
import trn.logistics.knapsack.dto.Vehicle;

import java.util.Optional;

@Service
public class VehicleService {

    private VehicleRepository vehicleRepository;

    public void putVehicle(Vehicle v1){
        vehicleRepository.save(v1);

    }

    public Vehicle getVehicle(Long id) {
        Optional<Vehicle> result = new Optional<Vehicle>(null);
        if(id != null){
            result = vehicleRepository.findById(id);
        }

        return result.isPresent() ? result.get() : null;
    }
}
