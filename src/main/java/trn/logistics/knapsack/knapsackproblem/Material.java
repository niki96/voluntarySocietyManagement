package trn.logistics.knapsack.knapsackproblem;

import trn.logistics.knapsack.Interfaces.KnapsackElement;
/**
 * A specific implementation for scouting material of the KnapsackElement
 * @author Niklas
 *
 */
public class Material implements KnapsackElement{
	private int weight;
	private int volume;
	private String name;
	//TODO: Type must change to an Enum
	private String type;
	
	public Material(int weight, int volume, String name, String type) {
		super();
		this.weight = weight;
		this.volume = volume;
		this.name = name;
		this.type = type;
	}

	public Material(int volume, int weight){
		this.weight = weight;
		this.volume = volume;
		this.name="";
		this.type="";
	}
	
	@Override
	public String toString() {
		return "Material [weight=" + weight + ", volume=" + volume + ", name=" + name + ", type=" + type + "]";
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getElementTyp() {
		return this.type;
	}
	
	@Override
	public int getElementVolume() {
		return this.volume;
	}

	@Override
	public int getElementWeight() {
		return this.weight;
	}

}
