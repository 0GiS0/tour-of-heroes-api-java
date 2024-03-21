package net.returngis.tourofheroes.interfaces;

import net.returngis.tourofheroes.models.Villain;

import java.util.List;

public interface VillainService {
    List<Villain> getAllVillains();
    Villain getVillainById(Long id);
    Villain createVillain(Villain villain);
    Villain updateVillain(Long id, Villain villain);
    void deleteVillain(Long id);
}