package trn.logistics.knapsack.service;

import org.springframework.stereotype.Service;
import trn.logistics.knapsack.algorithm.TheAlgorithm;
import trn.logistics.knapsack.database.KnapsackSolutionRepository;
import trn.logistics.knapsack.dto.KnapsackSolution;
import trn.logistics.knapsack.dto.Material;
import trn.logistics.knapsack.dto.Vehicle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class KnapsackSolutionService {
    private KnapsackSolutionRepository knapsackSolutionRepository;

    public KnapsackSolution createKnapsackSolution(List<Vehicle> vehicles , List<Material> materials){
        KnapsackSolution ks ;
        List<Vehicle> loadedVehicles;
        loadedVehicles = TheAlgorithm.knapsackDistribution(materials, vehicles);

        ks = new KnapsackSolution(loadedVehicles);
        knapsackSolutionRepository.save(ks);

        return ks;
    }

    public KnapsackSolution loadKnapsacksolution(Long id) {
        if(id != null){
            return knapsackSolutionRepository.findById(id).orElse(null);
        }
        return null;
    }
}
