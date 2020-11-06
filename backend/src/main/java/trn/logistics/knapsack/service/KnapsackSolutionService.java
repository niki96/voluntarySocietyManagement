package trn.logistics.knapsack.service;

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

import java.util.List;

@Service
public class KnapsackSolutionService {
    @Autowired
    private KnapsackSolutionRepository knapsackSolutionRepository;
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private MaterialRepository materialRepository;

    private TheAlgorithm algorithm;

    public KnapsackSolution createKnapsackSolutions(List<Long> vehicleIds, List<Long> materialIds, String name) {

        List<Vehicle> vehicles = vehicleRepository.findAllById(vehicleIds);
        List<Material> materials = materialRepository.findAllById(materialIds);

        KnapsackSolution ks = new KnapsackSolution();
        AlgorithmPair pair = algorithm.knapsackDistribution(materials, vehicles);
        ks.setSelectedVehicles(pair.getVehiclelist());
        ks.setNotLoadedMaterials(pair.getMateriallist());
        ks.setName(name);
        knapsackSolutionRepository.save(ks);

        return ks;
    }

    public KnapsackSolution loadKnapsackSolutions(Long id) {
        if (id != null) {
            return knapsackSolutionRepository.findById(id).orElse(null);
        }
        return null;
    }
}
