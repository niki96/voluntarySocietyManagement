package trn.logistics.knapsack.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Getter
@Slf4j
@Entity
public class Vehicle implements Comparable<Vehicle>{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private final int maxVolume;
	private final int maxWeight;

	@OneToMany(targetEntity = Material.class, mappedBy = "vehicle", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private final List<Material> containedElements;


	public Vehicle(int maxVolume, int maxWeight) {
		this.maxVolume = maxVolume;
		this.maxWeight = maxWeight;
		this.containedElements = new ArrayList<>();
	}

	public int getActualVolume()
	{
		return this.containedElements.stream().mapToInt(Material::getVolume).sum();
	}

	public int getActualWeight()
	{
		return this.containedElements.stream().mapToInt(Material::getWeight).sum();
	}

	public void addElementToKnapsack(Material kE) {
		this.containedElements.add(kE);
		
	}

	public void printLoadingList() {
		for(Material k : this.containedElements){
			log.info("Position 1: " + k.toString());
		}
	}
	public boolean allowedMaterialType(MaterialType mType){
		//TODO implement decision pattern for all different Material Types
		return true;
	}
	@Override
	public int compareTo(Vehicle v ){
		int res= 0;
		if(v.getMaxWeight() > this.getMaxWeight()){
			res = -1;
		}else if(v.getMaxWeight() < this.getMaxWeight()) {
			res = 1;
		}
		return res;
	}

}
