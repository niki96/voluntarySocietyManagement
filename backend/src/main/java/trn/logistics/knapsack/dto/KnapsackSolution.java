package trn.logistics.knapsack.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.List;

@Getter
@Slf4j
@Entity
@NoArgsConstructor
@Setter
public class KnapsackSolution {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;

    @OneToMany(targetEntity = Vehicle.class, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Vehicle> selectedVehicles;

    private List<Material> notLoadedMaterials;

}
