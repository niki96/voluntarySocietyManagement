package trn.logistics.knapsack.algorithm;

import lombok.extern.slf4j.Slf4j;
import trn.logistics.knapsack.dto.Material;
import trn.logistics.knapsack.dto.Vehicle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Slf4j
public class TheAlgorithm {

    public static List<Vehicle> knapsackDistribution(Collection<Material> materialCollection, Collection<Vehicle> vehicleCollection) {
        ArrayList<Material> kEs = new ArrayList<>(materialCollection);
        ArrayList<Vehicle> k = new ArrayList<>(vehicleCollection);
        //kEs.addAll(materialCollection);
        Collections.sort(kEs);
        //TODO Due to the type of the Element it could be possible that an element is not allowed to put on the Knapsack

        for (Material material : kEs) {
            boolean isAdded = false;
            for (Vehicle vehicle : k) {
                if (vehicle.allowedMaterialType(material.getType())) {
                    if (vehicle.getActualWeight() + material.getWeight() <= vehicle.getMaxWeight() && vehicle.getActualVolume() + material.getVolume() <= vehicle.getMaxVolume()) {
                        vehicle.getContainedElements().add(material);
                        log.info("material is added to: " + vehicle.toString() + " | material: " + material.toString());
                        isAdded = true;
                    } else {
                        isAdded = false;
                    }
                }
            }
            if (!isAdded) {
                // mark on list for material thats not possible to load
                log.info("material is not loaded on any vehicle " + material.toString());
            }

        }
        return k;
    }

}

