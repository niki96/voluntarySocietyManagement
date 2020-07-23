package trn.logistics.knapsack.dto;

import java.util.ArrayList;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Slf4j
@Entity
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private final int maxVolume;
	private final int maxWeight;
	private final int actualVolume;
	private final int actualWeight;
	private final ArrayList<Material> containedElements;
	
	public Vehicle(int maxVolume, int maxWeight, int actualVolume, int actualWeight) {
		this.maxVolume = maxVolume;
		this.maxWeight = maxWeight;
		this.actualVolume = actualVolume;
		this.actualWeight = actualWeight;
		this.containedElements = new ArrayList<>();
	}

	public void addElementToKnapsack(Material kE) {
		this.containedElements.add(kE);
		
	}

	public void printLoadingList() {
		for(Material k : this.containedElements){
			log.info("Position 1: " + k.toString());
		}
	}

}
