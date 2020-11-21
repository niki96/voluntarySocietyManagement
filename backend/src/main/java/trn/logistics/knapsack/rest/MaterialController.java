package trn.logistics.knapsack.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import trn.logistics.knapsack.dto.Material;
import trn.logistics.knapsack.service.MaterialService;

import java.util.List;

import static trn.logistics.knapsack.rest.MaterialController.API;

@Slf4j
@RestController
@RequestMapping(API)
public class MaterialController {

    public static final String API = "/api/v1/materials";
    
    @Autowired
    private MaterialService materialService;

    @CrossOrigin
    @PutMapping
    public void updateMaterial(@RequestBody Material material) {
        materialService.addMaterial(material);
    }

    @CrossOrigin
    @PostMapping(consumes = "application/json", produces = "application/json")
    public void addMaterial(@RequestBody Material material) {
        materialService.addMaterial(material);
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

    @CrossOrigin
    @GetMapping
    public List<Material> getAllMaterials() {
        return materialService.getAllMaterials();
    }

    @DeleteMapping("/{name}")
    public void deleteMaterial(@PathVariable("name") String name) {

        //TODO implement DELETE
        log.info("Deleting material {}", name);
    }

}
