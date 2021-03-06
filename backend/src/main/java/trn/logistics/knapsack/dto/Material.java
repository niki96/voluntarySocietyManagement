package trn.logistics.knapsack.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

/**
 * A specific implementation for scouting material of the KnapsackElement
 * @author Niklas
 *
 */
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Material implements Comparable<Material> {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private int weight;
	private int volume;

	private String name;
	private MaterialType type;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "vehicle_id")
	private Vehicle vehicle;


	@Override
	public int compareTo(Material m) {

		int res = 0;
		//TODO implement better comparison mechanism
		if (m.getWeight() > this.getWeight()) {
			res = -1;
		} else if (m.getWeight() < this.getWeight()) {
			res = 1;
		}
		return res;
	}

	/**
	 * method to get Material Attributes as list for creating PDF table
	 *
	 * @return List of Attributes
	 */
	public List<String> getMaterialAsList() {
		return Arrays.asList(name, type.toString(), Integer.toString(volume), Integer.toString(weight));

	}
}
