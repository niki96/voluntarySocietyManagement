package trn.logistics.knapsack.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
/**
* This is a helper class to return the result of the knapsack algorithm
*/
public class AlgorithmPair {
    private List<Vehicle> vehiclelist;
    private List<Material> materiallist;

}
