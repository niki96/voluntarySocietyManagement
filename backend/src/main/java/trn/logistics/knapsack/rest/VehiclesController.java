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

    public static final String API = "/api/v1/vehicle";
    @Autowired
    private VehicleService vehicleService;

    @PutMapping
    public void putVehicles(@RequestBody Vehicle vehicle) {
        vehicleService.putVehicles(vehicle);
    }

    @GetMapping("/{id}")
    public Vehicle getVehicles(@PathVariable("id") Long id) {
        return vehicleService.getVehicles(id);
    }

    @GetMapping
    public List<Vehicle> getVehicles() {
        return vehicleService.getVehicles();
    }

    @PostMapping
    public void postVehicles(@RequestBody Vehicle vehicle) {
        vehicleService.putVehicles(vehicle);
    }
}
