package trn.logistics.knapsack;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import trn.logistics.knapsack.dto.KnapsackSolution;
import trn.logistics.knapsack.dto.Material;
import trn.logistics.knapsack.dto.MaterialType;
import trn.logistics.knapsack.dto.Vehicle;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootTest
class KnapsackSolutionServiceTest {
    @Test
    void knapsackSolutionToPDF() {
        KnapsackSolution kns = new KnapsackSolution();
        Vehicle v1 = new Vehicle(400, 3500);
        for (int i = 0; i < 5; i++) {
            v1.addElementToKnapsack(new Material(Integer.toUnsignedLong(i), 15, 12, "Test" + i, MaterialType.UNKNOWN, null));
        }
        kns.setSelectedVehicles(new ArrayList<Vehicle>(Arrays.asList(v1)));


    }
}
