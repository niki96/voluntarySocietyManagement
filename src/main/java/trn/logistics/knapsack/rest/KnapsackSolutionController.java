package trn.logistics.knapsack.rest;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;
import trn.logistics.knapsack.dto.KnapsackSolution;
import trn.logistics.knapsack.dto.Material;
import trn.logistics.knapsack.dto.SolutionRequest;
import trn.logistics.knapsack.dto.Vehicle;
import trn.logistics.knapsack.service.KnapsackSolutionService;

import java.util.ArrayList;
import java.util.List;

import static trn.logistics.knapsack.rest.KnapsackSolutionController.API;


@Slf4j
@RestController
@RequestMapping(API)
public class KnapsackSolutionController {
    public static final String API = "/api/v1/knapsackSolution";
    private KnapsackSolutionService knapsackSolutionService;


        @PostMapping
        public Long createKnapsackSolution (@RequestBody SolutionRequest requestObject){
            //TODO exception handling for optional is null
            List<Material> materialList = new ArrayList<>(requestObject.getMaterialCollection()) ;
            List<Vehicle> vehicleList  = new ArrayList<>(requestObject.getVehicleCollection());
            KnapsackSolution result = knapsackSolutionService.createKnapsackSolution(vehicleList, materialList);

            return result.getId();
        }
        @GetMapping("/{id}")
        public KnapsackSolution getKnapsackSolution(@PathVariable("id") Long id){
            return  knapsackSolutionService.loadKnapsacksolution(id);
        }

}
