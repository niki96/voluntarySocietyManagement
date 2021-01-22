package trn.logistics.knapsack.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;

@Getter
@Slf4j
@AllArgsConstructor
public class SolutionRequest {


    @NotNull
    private Collection<Long> materialIds;
    @NotNull
    private Collection<Long> vehicleIds;
    @NonNull
    private String name;

}
