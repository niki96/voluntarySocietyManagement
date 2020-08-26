package trn.logistics.knapsack.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * A specific implementation for scouting material of the KnapsackElement
 * @author Niklas
 *
 */
@Getter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Material implements Comparable<Material>{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private final int weight;
	private final int volume;

	private String name;
	private MaterialType type;

	@Override
	public int compareTo(Material m ){

		int res= 0;
		if(m.getWeight() > this.getWeight()){
			res = -1;
		}else if(m.getWeight() < this.getWeight()) {
			res = 1;
		}
		return res;
	}
}
