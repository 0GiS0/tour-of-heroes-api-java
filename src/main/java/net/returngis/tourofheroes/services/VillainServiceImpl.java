package net.returngis.tourofheroes.services;

import net.returngis.tourofheroes.interfaces.VillainService;
import net.returngis.tourofheroes.models.Villain;
import net.returngis.tourofheroes.repositories.VillainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VillainServiceImpl implements VillainService {

    @Autowired
    private VillainRepository villainRepository;

    @Override
    public List<Villain> getAllVillains() {
        return villainRepository.findAll();
    }

    @Override
    public Villain getVillainById(Long id) {
        return villainRepository.findById(id).orElse(null);
    }

    @Override
    public Villain createVillain(Villain villain) {
        return villainRepository.save(villain);
    }

    @Override
    public Villain updateVillain(Long id, Villain villain) {
        // Aquí deberías implementar la lógica para actualizar un villano
        return null;
    }

    @Override
    public void deleteVillain(Long id) {
        villainRepository.deleteById(id);
    }
}