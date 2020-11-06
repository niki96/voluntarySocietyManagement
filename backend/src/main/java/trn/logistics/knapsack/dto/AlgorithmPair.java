package trn.logistics.knapsack.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class AlgorithmPair {
    private List<Vehicle> vehiclelist;
    private List<Material> materiallist;

}
