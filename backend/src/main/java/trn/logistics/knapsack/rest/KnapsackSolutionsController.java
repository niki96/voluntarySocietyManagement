package trn.logistics.knapsack.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import trn.logistics.knapsack.dto.KnapsackSolution;
import trn.logistics.knapsack.dto.SolutionRequest;
import trn.logistics.knapsack.service.KnapsackSolutionService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static trn.logistics.knapsack.rest.KnapsackSolutionsController.API;


@Slf4j
@RestController
@RequestMapping(API)
public class KnapsackSolutionsController {
    public static final String API = "/api/v1/knapsackSolutions";
    @Autowired
    private KnapsackSolutionService knapsackSolutionService;


    @PostMapping
    @CrossOrigin
    public Long createKnapsackSolution(@RequestBody SolutionRequest request) {
        //TODO Handel with Jakson that Attributes of requestObject are Not null
        List<Long> materialList = new ArrayList<>(request.getMaterialIds());
        List<Long> vehicleList = new ArrayList<>(request.getVehicleIds());
        KnapsackSolution result = knapsackSolutionService.createKnapsackSolutions(vehicleList, materialList, request.getName());

        return result.getId();
    }

    @GetMapping()
    @CrossOrigin
    public List<KnapsackSolution> getKnapsackSolutions() {
        return knapsackSolutionService.loadKnapsackSolutions();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_PDF_VALUE)
    @CrossOrigin
    public @ResponseBody
    byte[] getKnapsackSolutionAsPdf(@PathVariable("id") Long id) throws IOException {
        return knapsackSolutionService.createAndLoadKnapsackSolutionPdf(id);
    }
}
