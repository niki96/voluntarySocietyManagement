package trn.logistics.knapsack.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import trn.logistics.knapsack.dto.Material;
import trn.logistics.knapsack.service.MaterialService;

import static trn.logistics.knapsack.rest.MaterialController.API;

@Slf4j
@RestController
@RequestMapping(API)
public class MaterialController {

    public static final String API = "/api/v1/material";

    private MaterialService materialService;

    @PutMapping
    public void addMaterial(@RequestBody Material material) {

    }

    @GetMapping("/{name}")
    public Material getMaterial(@PathVariable("name") String name) {
        log.info("Get material {} ", name);

        //materialService.getMaterial(name);

        return null;
    }

    @DeleteMapping("/{name}")
    public void deleteMaterial(@PathVariable("name") String name) {
        log.info("Deleting material {}", name);
    }

}
