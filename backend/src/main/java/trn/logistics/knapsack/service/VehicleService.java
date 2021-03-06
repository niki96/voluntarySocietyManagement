package trn.logistics.knapsack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trn.logistics.knapsack.database.VehicleRepository;
import trn.logistics.knapsack.dto.Vehicle;

import java.util.List;

@Service

public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    public void addVehicle(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    public Vehicle getVehicle(Long id) {
        if (id != null) {
            return vehicleRepository.findById(id).orElse(null);
        }
        return null;
    }

    public List<Vehicle> getVehicles() {

        return vehicleRepository.findAll();
    }
}
