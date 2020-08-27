package trn.logistics.knapsack.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import trn.logistics.knapsack.database.MaterialRepository;
import trn.logistics.knapsack.dto.Material;

import java.util.Optional;

@Service
public class MaterialService {

    private MaterialRepository materialRepository;

    public Material getMaterial(String name) {
        if (StringUtils.isEmpty(name)) {
            return null;
        }

        return materialRepository.findByName(name);
    }

    public Material getMaterial(Long id) {
        if(id != null) {
            return materialRepository.findById(id).orElse(null);
        }
        return null;
    }

    public void putMaterial(Material material) {
        materialRepository.save(material);
    }
}
