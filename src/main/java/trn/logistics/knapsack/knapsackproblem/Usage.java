package trn.logistics.knapsack.knapsackproblem;

import java.util.ArrayList;

import trn.logistics.knapsack.Interfaces.KnapsackElement;

public class Usage {
	public static void main (String[] args){
		ArrayList<KnapsackElement> materialList= new ArrayList<KnapsackElement>();
		materialList.add(new Material(20,5,"Zargeskiste","Kiste"));
		DrivingVehicle lkw = new DrivingVehicle(1000, 3600, 0, 0);
		
		TheAlgorithm alg = new TheAlgorithm(materialList, lkw);
		alg.knapsackDistribution(materialList, lkw);
		lkw.printLoadingList();
	}
}
