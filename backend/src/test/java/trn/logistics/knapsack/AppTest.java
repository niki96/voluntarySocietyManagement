package trn.logistics.knapsack;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import trn.logistics.knapsack.algorithm.TheAlgorithm;
import trn.logistics.knapsack.dto.AlgorithmPair;
import trn.logistics.knapsack.dto.Material;
import trn.logistics.knapsack.dto.MaterialType;
import trn.logistics.knapsack.dto.Vehicle;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AppTest {

    @Test
    void contextLoads() {
    }

    @Test
    void testSimple() {
        List<Material> materialList = new ArrayList<>();
        materialList.add(new Material(1L, 20, 5, "Zargeskiste", MaterialType.BOX, null));
        Vehicle lkw = new Vehicle(1000, 3600);
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(lkw);
        TheAlgorithm algorithm = new TheAlgorithm();
        AlgorithmPair pair = algorithm.knapsackDistribution(materialList, vehicleList);
        lkw.printLoadingList();
        assertEquals(0, pair.getMateriallist().size());
        assertEquals(1, pair.getVehiclelist().get(1).getContainedElements().size());
    }
}
