package trn.logistics.knapsack.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import trn.logistics.knapsack.dto.KnapsackSolution;
import trn.logistics.knapsack.dto.SolutionRequest;
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
        //TODO Handel with Jakson that Attributes of requestObject are Not null
        List<Long> materialList = new ArrayList<>(requestObject.getMaterialIdCollection());
        List<Long> vehicleList = new ArrayList<>(requestObject.getVehicleIdCollection());
        KnapsackSolution result = knapsackSolutionService.createKnapsackSolutions(vehicleList, materialList, requestObject.getName());

        return result.getId();
    }

    @GetMapping("/{id}")
    public KnapsackSolution getKnapsackSolutions(@PathVariable("id") Long id) {
        return knapsackSolutionService.loadKnapsackSolutions(id);
    }

}
