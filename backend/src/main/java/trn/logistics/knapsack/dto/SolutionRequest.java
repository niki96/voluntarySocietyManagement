package trn.logistics.knapsack.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;

@Getter
@Slf4j
@AllArgsConstructor
public class SolutionRequest {

    private Long id;

    private Collection<Long> materialIdCollection;
    private Collection<Long> vehicleIdCollection;

}
