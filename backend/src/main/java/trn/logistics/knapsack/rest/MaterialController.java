package trn.logistics.knapsack.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import trn.logistics.knapsack.dto.Material;
import trn.logistics.knapsack.service.MaterialService;

import java.util.List;

import static trn.logistics.knapsack.rest.MaterialController.API;

@Slf4j
@RestController
@RequestMapping(API)
public class MaterialController {

    public static final String API = "/api/v1/material";

    private MaterialService materialService;

    @PutMapping
    public void addMaterials(@RequestBody Material material) {
        materialService.putMaterials(material);
    }

    @GetMapping("/{name}")
    public Material getMaterials(@PathVariable("name") String name) {
        log.info("Get material {} ", name);

        return materialService.getMaterials(name);
    }

    @GetMapping("/{id}")
    public Material getMaterials(@PathVariable("id") Long id) {
        log.info("Get material {} ", id);

        return materialService.getMaterials(id);
    }

    @GetMapping
    public List<Material> getAllMaterials() {
        return materialService.getAllMaterials();
    }

    @DeleteMapping("/{name}")
    public void deleteMaterials(@PathVariable("name") String name) {
        log.info("Deleting material {}", name);
    }

}
