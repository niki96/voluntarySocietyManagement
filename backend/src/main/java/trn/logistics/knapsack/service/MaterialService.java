package trn.logistics.knapsack.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import trn.logistics.knapsack.database.MaterialRepository;
import trn.logistics.knapsack.dto.Material;

import java.util.List;

@Service
public class MaterialService {

    private MaterialRepository materialRepository;

    public Material getMaterials(String name) {
        if (StringUtils.isEmpty(name)) {
            return null;
        }

        return materialRepository.findByName(name);
    }

    public Material getMaterials(Long id) {
        if (id != null) {
            return materialRepository.findById(id).orElse(null);
        }
        return null;
    }

    public void putMaterials(Material material) {
        materialRepository.save(material);
    }

    public List<Material> getAllMaterials() {

        return materialRepository.findAll();


    }
}
