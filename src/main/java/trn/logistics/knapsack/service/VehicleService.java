package trn.logistics.knapsack.service;

import org.springframework.stereotype.Service;
import trn.logistics.knapsack.database.VehicleRepository;
import trn.logistics.knapsack.dto.Vehicle;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class VehicleService {

    private VehicleRepository vehicleRepository;

    public void putVehicle(Vehicle v1) {
        vehicleRepository.save(v1);

    }

    public Vehicle getVehicle(Long id) {
        if (id != null) {
            return vehicleRepository.findById(id).orElse(null);
        }
        return null;
    }

    public ArrayList<Vehicle> getVehicle() {
        Stream<Vehicle> result = StreamSupport.stream(vehicleRepository.findAll().spliterator(), false);
        return result.collect(Collectors.toCollection(ArrayList::new));
    }
}
