package trn.logistics.knapsack.rest;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;
import trn.logistics.knapsack.dto.SolutionRequest;
import trn.logistics.knapsack.dto.Vehicle;
import trn.logistics.knapsack.service.KnapsackSolutionService;

import java.util.List;

import static trn.logistics.knapsack.rest.KnapsackSolutionController.API;


@Slf4j
@RestController
@RequestMapping(API)
public class KnapsackSolutionController {
    public static final String API = "/api/v1/knapsackSolution";
    private KnapsackSolutionService knapsackSolutionService;


        @PostMapping
        public int createKnapsackSolution (@RequestBody SolutionRequest requestObject){
            //TODO exception handling for optional is null


            return 0;
        }
}
