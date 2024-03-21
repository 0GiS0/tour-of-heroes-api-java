package net.returngis.tourofheroes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import net.returngis.tourofheroes.models.Villain;
import net.returngis.tourofheroes.interfaces.VillainService;

import java.util.List;

@RestController
@RequestMapping("/api/villain")
public class VillainsController {

    @Autowired
    private VillainService villainService;

    @GetMapping
    public List<Villain> getAllVillains() {
        return villainService.getAllVillains();
    }

    @GetMapping("/{id}")
    public Villain getVillainById(@PathVariable Long id) {
        return villainService.getVillainById(id);
    }

    @PostMapping
    public Villain createVillain(@RequestBody Villain villain) {
        return villainService.createVillain(villain);
    }

    @PutMapping("/{id}")
    public Villain updateVillain(@PathVariable Long id, @RequestBody Villain villain) {
        return villainService.updateVillain(id, villain);
    }

    @DeleteMapping("/{id}")
    public void deleteVillain(@PathVariable Long id) {
        villainService.deleteVillain(id);
    }
}