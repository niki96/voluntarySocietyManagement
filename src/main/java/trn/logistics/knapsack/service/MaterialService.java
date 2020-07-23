package trn.logistics.knapsack.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import trn.logistics.knapsack.database.MaterialRepository;
import trn.logistics.knapsack.dto.Material;

@Service
public class MaterialService {

    private MaterialRepository materialRepository;

    public Material getMaterial(String name) {
        if (StringUtils.isEmpty(name)) {
            return null;
        }

        return materialRepository.findByName(name);
    }
}
