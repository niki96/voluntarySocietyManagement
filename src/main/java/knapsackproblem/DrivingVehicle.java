package knapsackproblem;

import java.util.ArrayList;

import Interfaces.Knapsack;
import Interfaces.KnapsackElement;

public class DrivingVehicle implements Knapsack {
	private int maxVolume;
	private int maxWeight;
	private int actualVolume;
	private int actualWeight;
	private ArrayList<KnapsackElement> containedElements;
	
	public DrivingVehicle(int maxVolume, int maxWeight, int actualVolume, int actualWeight) {
		super();
		this.maxVolume = maxVolume;
		this.maxWeight = maxWeight;
		this.actualVolume = 0;
		this.actualWeight = 0;
		this.containedElements = new ArrayList();
	}

	@Override
	public int getMaxVolume() {
		return this.maxVolume;
	}

	@Override
	public int getMaxWeight() {
		return this.maxVolume;
	}

	@Override
	public int getAcutalVoume() {
		return this.actualVolume;
	}

	@Override
	public int getActualWeight() {
		return this.actualWeight;
	}

	@Override
	public ArrayList<KnapsackElement> getContainedKnapsackElemnts() {
		return this.containedElements;
	}

	@Override
	public void addElementToKnapsack(KnapsackElement kE) {
		this.containedElements.add(kE);
		
	}

	@Override
	public void printLoadingList() {
		for(KnapsackElement k : this.containedElements){
			System.out.println("Position 1: " + k.toString());
		}
		
	}

}
