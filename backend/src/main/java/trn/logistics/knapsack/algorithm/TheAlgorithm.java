package trn.logistics.knapsack.algorithm;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import trn.logistics.knapsack.dto.AlgorithmResult;
import trn.logistics.knapsack.dto.Material;
import trn.logistics.knapsack.dto.Vehicle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Slf4j
@NoArgsConstructor
@Component
public class TheAlgorithm {

    public AlgorithmResult knapsackDistribution(Collection<Material> materialCollection, Collection<Vehicle> vehicleCollection) {
        List<Material> knapsackElements = new ArrayList<>(materialCollection);
        List<Vehicle> knapsack = new ArrayList<>(vehicleCollection);
        List<Material> notLoadedMaterials = new ArrayList<>();
        Collections.sort(knapsackElements);
        //TODO Due to the type of the Element it could be possible that an element is not allowed to put on the Knapsack

        for (Material material : knapsackElements) {
            boolean isAdded = false;
            for (Vehicle vehicle : knapsack) {
                if (vehicle.allowedMaterialType(material.getType()) && doesMaterialFitByVolume(vehicle, material) && doesMaterialFitByWeight(vehicle, material)) {
                    vehicle.getContainedElements().add(material);
                    log.info("material {} is added to vehicle: {}", material, vehicle);
                    isAdded = true;
                    break;
                } else {
                    isAdded = false;
                }
                break;
            }
            if (!isAdded) {
                // mark on list for material thats not possible to load
                notLoadedMaterials.add(material);
                log.info("material is not loaded on any vehicle: {}", material);
            }

        }
        return new AlgorithmResult(knapsack, notLoadedMaterials);
    }

    private boolean doesMaterialFitByWeight(Vehicle vehicle, Material material) {
        return vehicle.getActualWeight() + material.getWeight() <= vehicle.getMaxWeight();
    }

    private boolean doesMaterialFitByVolume(Vehicle vehicle, Material material) {
        return vehicle.getActualVolume() + material.getVolume() <= vehicle.getMaxVolume();
    }

}
