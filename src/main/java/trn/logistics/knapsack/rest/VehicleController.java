package trn.logistics.knapsack.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import trn.logistics.knapsack.dto.Vehicle;
import trn.logistics.knapsack.service.VehicleService;

import static trn.logistics.knapsack.rest.VehicleController.API;

@Slf4j
@RestController
@RequestMapping(API)
public class VehicleController {

    public static final String API = "/api/v1/vehicle";
    private VehicleService vehicleService;

    @PutMapping
    public void putVehicle (@RequestBody Vehicle vehicle){
        vehicleService.putVehicle(vehicle);
    }
}
