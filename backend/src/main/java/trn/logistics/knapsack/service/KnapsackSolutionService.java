package trn.logistics.knapsack.service;

import be.quodlibet.boxable.BaseTable;
import be.quodlibet.boxable.datatable.DataTable;
import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trn.logistics.knapsack.algorithm.TheAlgorithm;
import trn.logistics.knapsack.database.KnapsackSolutionRepository;
import trn.logistics.knapsack.database.MaterialRepository;
import trn.logistics.knapsack.database.VehicleRepository;
import trn.logistics.knapsack.dto.AlgorithmPair;
import trn.logistics.knapsack.dto.KnapsackSolution;
import trn.logistics.knapsack.dto.Material;
import trn.logistics.knapsack.dto.Vehicle;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class KnapsackSolutionService {
    @Autowired
    private KnapsackSolutionRepository knapsackSolutionRepository;
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private MaterialRepository materialRepository;
    @Autowired
    private TheAlgorithm algorithm;

    public KnapsackSolution createKnapsackSolutions(List<Long> vehicleIds, List<Long> materialIds, String name) {

        List<Vehicle> vehicles = vehicleRepository.findAllById(vehicleIds);
        List<Material> materials = materialRepository.findAllById(materialIds);

        AlgorithmPair pair = algorithm.knapsackDistribution(materials, vehicles);

        KnapsackSolution ks = KnapsackSolution.builder()
                                              .selectedVehicles(pair.getVehiclelist())
                                              .notLoadedMaterials(pair.getMateriallist())
                                              .name(name)
                                              .build();
        knapsackSolutionRepository.save(ks);

        return ks;
    }

    public List<KnapsackSolution> loadKnapsackSolutions() {
        //TODO add null handling
        return knapsackSolutionRepository.findAll();
    }

    public byte[] createAndLoadKnapsackSolutionPdf(Long id) {

        KnapsackSolution kns = knapsackSolutionRepository.getOne(id);
        createPdfFromKnapsack(kns);
        return null;
    }

    private PDDocument createPdfFromKnapsack(KnapsackSolution kns) {

        PDDocument mainDocument = new PDDocument();
        for (Vehicle vehicle : kns.getSelectedVehicles()) {
            PDPage myPage = new PDPage(PDRectangle.A4);
            //TODO add VEHICLE details to PDF
            //TODO Change Table to table with header
            try {
                BaseTable dataTable = createBaseTable(myPage, mainDocument);

                DataTable myTable = new DataTable(dataTable, myPage);
                myTable.addListToTable(vehicle.getContainedElementsListForPDF(), DataTable.NOHEADER);
                dataTable.draw();
            } catch (IOException e) {
                log.error(String.valueOf(e));
            }
            mainDocument.addPage(myPage);
            try {
                mainDocument.save(kns.getName() + ".pdf");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return mainDocument;
    }

    private BaseTable createBaseTable(PDPage myPage, PDDocument doc) throws IOException {
        float margin = 50;
        // starting y position is whole page height subtracted by top and bottom margin
        float yStartNewPage = myPage.getMediaBox().getHeight() - (2 * margin);
        // we want table across whole page width (subtracted by left and right margin ofcourse)
        float tableWidth = myPage.getMediaBox().getWidth() - (2 * margin);


        float yStart = yStartNewPage;
        float bottomMargin = 70;

        return new BaseTable(yStart, yStartNewPage, bottomMargin, tableWidth, margin, doc, myPage, true, true);
    }
}
