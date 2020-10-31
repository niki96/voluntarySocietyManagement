package trn.logistics.knapsack.service;

import org.springframework.stereotype.Service;
import trn.logistics.knapsack.database.VehicleRepository;
import trn.logistics.knapsack.dto.Vehicle;

import java.util.List;

@Service
public class VehicleService {

    private VehicleRepository vehicleRepository;

    public void putVehicles(Vehicle v1) {
        vehicleRepository.save(v1);

    }

    public Vehicle getVehicles(Long id) {
        if (id != null) {
            return vehicleRepository.findById(id).orElse(null);
        }
        return null;
    }

    public List<Vehicle> getVehicles() {

        return vehicleRepository.findAll();
    }
}
