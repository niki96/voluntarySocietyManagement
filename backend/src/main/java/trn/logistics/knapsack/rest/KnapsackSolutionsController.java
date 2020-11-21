package trn.logistics.knapsack.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public static final String API = "/api/v1/knapsackSolutions";
    @Autowired
    private KnapsackSolutionService knapsackSolutionService;


    @PostMapping
    @CrossOrigin
    public Long createKnapsackSolution(@RequestBody SolutionRequest request) {
        //TODO Handel with Jakson that Attributes of requestObject are Not null
        List<Long> materialList = new ArrayList<>(requestObject.getMaterialIdCollection());
        List<Long> vehicleList = new ArrayList<>(requestObject.getVehicleIdCollection());
        KnapsackSolution result = knapsackSolutionService.createKnapsackSolutions(vehicleList, materialList, requestObject.getName());

        return result.getId();
    }

    @GetMapping()
    @CrossOrigin
    public List<KnapsackSolution> getKnapsackSolutions() {
        return knapsackSolutionService.loadKnapsackSolutions();
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<byte[]> getKnapsackSolutionAsPdf(@PathVariable("id") Long id) {
        byte[] contents = knapsackSolutionService.createAndLoadKnapsackSolutionPdf(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        //TODO fix this with good name headers.setContentDispositionFormData("", "LoadingList.pdf");
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        return new ResponseEntity<>(contents, headers, HttpStatus.OK);

    }
}
