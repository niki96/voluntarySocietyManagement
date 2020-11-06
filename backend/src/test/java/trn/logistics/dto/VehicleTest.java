package trn.logistics.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import trn.logistics.knapsack.App;
import trn.logistics.knapsack.dto.Material;
import trn.logistics.knapsack.dto.MaterialType;
import trn.logistics.knapsack.dto.Vehicle;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(classes = App.class)
public class VehicleTest {

    private Vehicle vehicle;

    @BeforeEach
    void before() {
        this.vehicle = new Vehicle(0, 0);
    }

    @Test
    void actualVolumeInit() {
        assertEquals(0, this.vehicle.getActualVolume());
    }

    @Test
    void actualWightInit() {
        assertEquals(0, this.vehicle.getActualWeight());
    }


    @Test
    void actualVolumeAfterMaterialAdded() {

        this.vehicle.addElementToKnapsack(new Material(1L, 5, 5, "Stangen", MaterialType.UNKNOWN, new Vehicle()));
        assertEquals(5, this.vehicle.getActualVolume());
    }

    @Test
    void actualWeightAfterMaterialAdded() {
        this.vehicle.addElementToKnapsack(new Material(1L, 5, 5, "Stangen", MaterialType.UNKNOWN, new Vehicle()));
        assertEquals(5, this.vehicle.getActualWeight());
    }
}
