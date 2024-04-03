package net.returngis.tourofheroes.controllers;

import net.returngis.tourofheroes.models.Hero;
import net.returngis.tourofheroes.services.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/hero")
public class HeroesController {

    @Autowired
    private HeroService heroService;

    @GetMapping()
    public ResponseEntity<Iterable<Hero>> getHeroes() {

        Iterable<Hero> heroes = heroService.getHeroes();
        return new ResponseEntity<Iterable<Hero>>(heroes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hero> getHeroById(@PathVariable("id") Long id) {
        Hero hero = heroService.findById(id);
        return new ResponseEntity<Hero>(hero, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Hero> createHero(@RequestBody Hero hero) {
        Hero newHero = heroService.save(hero);
        return new ResponseEntity<Hero>(newHero, HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hero> updateHero(@PathVariable("id") Long id, @RequestBody Hero hero) {
        Hero updatedHero = heroService.save(hero);
        return new ResponseEntity<Hero>(updatedHero, HttpStatus.ACCEPTED);
    }
}
