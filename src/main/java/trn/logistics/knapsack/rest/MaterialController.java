package trn.logistics.knapsack.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import trn.logistics.knapsack.dto.Material;
import trn.logistics.knapsack.service.MaterialService;

import java.util.ArrayList;

import static trn.logistics.knapsack.rest.MaterialController.API;

@Slf4j
@RestController
@RequestMapping(API)
public class MaterialController {

    public static final String API = "/api/v1/material";

    private MaterialService materialService;

    @PutMapping
    public void addMaterial(@RequestBody Material material) {
        materialService.putMaterial(material);
    }

    @GetMapping("/{name}")
    public Material getMaterial(@PathVariable("name") String name) {
        log.info("Get material {} ", name);

        return materialService.getMaterial(name);
    }

    @GetMapping("/{id}")
    public Material getMaterial(@PathVariable("id") Long id) {
        log.info("Get material {} ", id);

        return materialService.getMaterial(id);
    }

    @GetMapping
    public ArrayList<Material> getAllMaterial() {
        return materialService.getMaterial();
    }

    @DeleteMapping("/{name}")
    public void deleteMaterial(@PathVariable("name") String name) {
        log.info("Deleting material {}", name);
    }

}
