package trn.logistics.knapsack.algorithm;

import lombok.extern.slf4j.Slf4j;
import trn.logistics.knapsack.dto.Material;
import trn.logistics.knapsack.dto.Vehicle;

import java.util.ArrayList;

@Slf4j
public class TheAlgorithm {

	public static void knapsackDistribution(ArrayList<Material> kEs, Vehicle... k) {
		//TODO Due to the type of the Element it could be possible that an element is not allowed to put on the Knapsack
		for(Material material : kEs ){
			for (Vehicle vehicle : k){
				//TODO: add Volume limit to the condition
				if(vehicle.getActualWeight() + material.getWeight() <= vehicle.getMaxWeight()){
					vehicle.getContainedElements().add(material);
				}
			}
			
		}
	}
	
}

