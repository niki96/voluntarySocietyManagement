package trn.logistics.knapsack;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import trn.logistics.knapsack.dto.KnapsackSolution;
import trn.logistics.knapsack.dto.Material;
import trn.logistics.knapsack.dto.MaterialType;
import trn.logistics.knapsack.dto.Vehicle;
import trn.logistics.knapsack.exporter.PdfExporter;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class PdfExporterTest {
    @Test
    void createPdfFromKnapsackTest() {
        KnapsackSolution kns = new KnapsackSolution();
        Vehicle v1 = new Vehicle(400, 3500);
        for (int i = 0; i < 5; i++) {
            v1.addElementToKnapsack(new Material(Integer.toUnsignedLong(i), 15, 12, "Test" + i, MaterialType.UNKNOWN, null));
        }
        kns.setSelectedVehicles(new ArrayList<>(Arrays.asList(v1)));
        PdfExporter p1 = new PdfExporter();
        PDDocument pdf = p1.createPdfFromKnapsack(kns);
        assertNotEquals(0, pdf.getNumberOfPages());
    }

    @Test
    void createPdfFromKnapsackMultiplePagesForOneVehicleTest() {
        KnapsackSolution kns = new KnapsackSolution();
        Vehicle v1 = new Vehicle(400, 3500);
        for (int i = 0; i < 100; i++) {
            v1.addElementToKnapsack(new Material(Integer.toUnsignedLong(i), 15, 12, "Test" + i, MaterialType.UNKNOWN, null));
        }
        kns.setSelectedVehicles(new ArrayList<>(Arrays.asList(v1)));
        PdfExporter p1 = new PdfExporter();
        PDDocument pdf = p1.createPdfFromKnapsack(kns);
        assertNotEquals(0, pdf.getNumberOfPages());
        assertTrue(1 < pdf.getNumberOfPages());
    }
}

