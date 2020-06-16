package knapsackproblem;

import java.util.ArrayList;

import Interfaces.Knapsack;
import Interfaces.KnapsackElement;
import Interfaces.MyGreedyAlgorithm;

public class TheAlgorithm  implements MyGreedyAlgorithm{
	
	private ArrayList<Knapsack> listOfKnapsacks;
	private ArrayList<KnapsackElement> listOfElements;
	
	public TheAlgorithm(ArrayList<KnapsackElement> kEs, Knapsack... k){
		this.listOfKnapsacks = new ArrayList<>();
		//TODO The list of elements has to be sorted 
		this.listOfElements = kEs;
		for(Knapsack knapsack : k){
			listOfKnapsacks.add(knapsack);
		}
	}
	/**
	 * 
	 */
	@Override
	public void knapsackDistribution(ArrayList<KnapsackElement> kEs, Knapsack... k) {
		//TODO Due to the type of the Element it could be possible that an element is not allowed to put on the Knapsack
		for(KnapsackElement knapsackElement : kEs ){
			for (Knapsack knapsack : k){
				//TODO: add Volume limit to the condition
				if(knapsack.getActualWeight()+knapsackElement.getElementWeight()<=knapsack.getMaxWeight()){
					knapsack.addElementToKnapsack(knapsackElement);
				}
			}
			
		}
	}
	
	private Knapsack getKnapsackWithMinimalWeight(){
		return null;
	}

}

