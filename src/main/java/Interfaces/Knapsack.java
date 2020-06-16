package Interfaces;

import java.util.ArrayList;


public interface Knapsack {

	public int getMaxVolume();
	public int getMaxWeight();
	public int getAcutalVoume();
	public int getActualWeight();
	//TODO add a list or Map of Supported KnapsackElement Types. It is a subset of the enum
	public ArrayList<KnapsackElement> getContainedKnapsackElemnts();
	public void addElementToKnapsack(KnapsackElement kE);
	/**
	 * Print support a posible way to output to console
	 */
	public void printLoadingList();
	//TODO: Add different Methods like ToString for Knapsacks
	//TODO: add method to put Elements into PDF and safe it on the Storage
}
