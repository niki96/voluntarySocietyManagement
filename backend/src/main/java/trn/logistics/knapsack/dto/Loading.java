package trn.logistics.knapsack.dto;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Entity
public class Loading {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Long vehicleId;
    @OneToMany
    @JoinColumn(name = "material_id")
    private List<Long> materialIds;
}
