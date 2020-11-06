package trn.logistics.knapsack.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import trn.logistics.knapsack.dto.Vehicle;
import trn.logistics.knapsack.service.VehicleService;

import java.util.List;

import static trn.logistics.knapsack.rest.VehiclesController.API;

@Slf4j
@RestController
@RequestMapping(API)
public class VehiclesController {

    public static final String API = "/api/v1/vehicles";
    
    @Autowired
    private VehicleService vehicleService;

    @PutMapping
    @CrossOrigin
    public void putVehicle(@RequestBody Vehicle vehicle) {
        vehicleService.addVehicle(vehicle);
    }

    @GetMapping("/{id}")
    public Vehicle getVehicle(@PathVariable("id") Long id) {
        return vehicleService.getVehicle(id);
    }

    @GetMapping
    @CrossOrigin
    public List<Vehicle> getVehicles() {
        return vehicleService.getVehicles();
    }

    @PostMapping
    @CrossOrigin
    public void postVehicle(@RequestBody Vehicle vehicle) {
        vehicleService.addVehicle(vehicle);
    }
}
