package trn.logistics.knapsack.algorithm;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import trn.logistics.knapsack.dto.AlgorithmPair;
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

    public AlgorithmPair knapsackDistribution(Collection<Material> materialCollection, Collection<Vehicle> vehicleCollection) {
        List<Material> kEs = new ArrayList<>(materialCollection);
        List<Vehicle> k = new ArrayList<>(vehicleCollection);
        List<Material> notLoadedMaterials = new ArrayList<>();
        Collections.sort(kEs);
        //TODO Due to the type of the Element it could be possible that an element is not allowed to put on the Knapsack

        for (Material material : kEs) {
            boolean isAdded = false;
            for (Vehicle vehicle : k) {
                if (vehicle.allowedMaterialType(material.getType()) && checkVolumeLimitForMaterial(vehicle, material) && checkWeightLimitForMaterial(vehicle, material)) {
                    vehicle.getContainedElements().add(material);
                    log.info("material is added to: {} | material: {}", vehicle.toString(), material.toString());
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
                log.info("material is not loaded on any vehicle: {}", material.toString());
            }

        }
        return new AlgorithmPair(k, notLoadedMaterials);
    }

    private boolean checkWeightLimitForMaterial(Vehicle vehicle, Material material) {
        return vehicle.getActualWeight() + material.getWeight() <= vehicle.getMaxWeight();
    }

    private boolean checkVolumeLimitForMaterial(Vehicle vehicle, Material material) {
        return vehicle.getActualVolume() + material.getVolume() <= vehicle.getMaxVolume();
    }

}
