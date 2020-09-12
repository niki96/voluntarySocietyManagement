package trn.logistics.knapsack.rest;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static trn.logistics.knapsack.rest.knapsackSolutionController.API;


@Slf4j
@RestController
@RequestMapping(API)
public class knapsackSolutionController {
    public static final String API = "/api/v1/knapsackSolution";
    private trn.logistics.knapsack.service.knapsackSolutionService knapsackSolutionService;
}
