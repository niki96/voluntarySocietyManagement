package trn.logistics.knapsack.service;

import trn.logistics.knapsack.algorithm.TheAlgorithm;
import trn.logistics.knapsack.dto.KnapsackSolution;
import trn.logistics.knapsack.dto.Material;
import trn.logistics.knapsack.dto.Vehicle;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class KnapsackSolutionService {

    public KnapsackSolution createKnapsackSolution(List<Vehicle> vehicles , List<Material> materials){
        KnapsackSolution ks = null;
        TheAlgorithm.knapsackDistribution(materials, vehicles);



        return ks;
    }
}
