package trn.logistics.knapsack;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import trn.logistics.knapsack.algorithm.TheAlgorithm;
import trn.logistics.knapsack.dto.Material;
import trn.logistics.knapsack.dto.MaterialType;
import trn.logistics.knapsack.dto.Vehicle;

import java.util.ArrayList;

@SpringBootTest
class AppTest {

    @Test
    void contextLoads() {
    }

    @Test
    void testSimple() {
        ArrayList<Material> materialList = new ArrayList<>();
        materialList.add(new Material(20, 5, "Zargeskiste", MaterialType.BOX));
        Vehicle lkw = new Vehicle(1000, 3600, 0, 0);

        TheAlgorithm.knapsackDistribution(materialList, lkw);
        lkw.printLoadingList();
    }
}
