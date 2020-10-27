package trn.logistics.knapsack.service;

import org.springframework.stereotype.Service;
import trn.logistics.knapsack.algorithm.TheAlgorithm;
import trn.logistics.knapsack.database.KnapsackSolutionRepository;
import trn.logistics.knapsack.dto.KnapsackSolution;
import trn.logistics.knapsack.dto.Material;
import trn.logistics.knapsack.dto.Vehicle;

import java.util.List;

@Service
public class KnapsackSolutionService {
    private KnapsackSolutionRepository knapsackSolutionRepository;
    private TheAlgorithm algorithm;

    public KnapsackSolution createKnapsackSolutions(List<Vehicle> vehicles, List<Material> materials) {
        List<Vehicle> loadedVehicles;
        loadedVehicles = algorithm.knapsackDistribution(materials, vehicles);

        KnapsackSolution ks = new KnapsackSolution(loadedVehicles);
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
