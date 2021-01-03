package trn.logistics.knapsack.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trn.logistics.knapsack.algorithm.TheAlgorithm;
import trn.logistics.knapsack.database.KnapsackSolutionRepository;
import trn.logistics.knapsack.database.MaterialRepository;
import trn.logistics.knapsack.database.VehicleRepository;
import trn.logistics.knapsack.dto.AlgorithmResult;
import trn.logistics.knapsack.dto.KnapsackSolution;
import trn.logistics.knapsack.dto.Material;
import trn.logistics.knapsack.dto.Vehicle;
import trn.logistics.knapsack.exporter.PdfExporter;

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
    @Autowired
    private PdfExporter exporter;

    public KnapsackSolution createKnapsackSolutions(List<Long> vehicleIds, List<Long> materialIds, String name) {

        List<Vehicle> vehicles = vehicleRepository.findAllById(vehicleIds);
        List<Material> materials = materialRepository.findAllById(materialIds);

        AlgorithmResult pair = algorithm.knapsackDistribution(materials, vehicles);

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

    public byte[] createAndLoadKnapsackSolutionPdf(Long id) throws IOException {

        KnapsackSolution kns = knapsackSolutionRepository.getOne(id);
        PDDocument document = exporter.createPdfFromKnapsack(kns);
        PDStream pdStream = new PDStream(document);

        return pdStream.toByteArray();
    }


}
