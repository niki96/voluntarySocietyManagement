package trn.logistics.knapsack.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import trn.logistics.knapsack.dto.KnapsackSolution;
import trn.logistics.knapsack.dto.Material;
import trn.logistics.knapsack.dto.SolutionRequest;
import trn.logistics.knapsack.dto.Vehicle;
import trn.logistics.knapsack.service.KnapsackSolutionService;

import java.util.ArrayList;
import java.util.List;

import static trn.logistics.knapsack.rest.KnapsackSolutionsController.API;


@Slf4j
@RestController
@RequestMapping(API)
public class KnapsackSolutionsController {
    public static final String API = "/api/v1/knapsackSolution";
    @Autowired
    private KnapsackSolutionService knapsackSolutionService;


    @PostMapping
    public Long createKnapsackSolutions(@RequestBody SolutionRequest requestObject) {
        //TODO exception handling for optional is null
        List<Material> materialList = new ArrayList<>(requestObject.getMaterialCollection());
        List<Vehicle> vehicleList = new ArrayList<>(requestObject.getVehicleCollection());
        KnapsackSolution result = knapsackSolutionService.createKnapsackSolutions(vehicleList, materialList);

        return result.getId();
    }

    @GetMapping("/{id}")
    public KnapsackSolution getKnapsackSolutions(@PathVariable("id") Long id) {
        return knapsackSolutionService.loadKnapsackSolutions(id);
    }

}
