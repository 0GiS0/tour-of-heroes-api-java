package net.returngis.tourofheroes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hero")
public class HeroesController {

    private HeroRepository repository;

    public HeroesController(HeroRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    public ResponseEntity<Iterable<Hero>> getHeroes() {

        Iterable<Hero> heroes = repository.findAll();
        return new ResponseEntity<Iterable<Hero>>(heroes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hero> getHeroById(@PathVariable("id") Long id) {
        Hero hero = repository.findById(id).orElse(null);
        return new ResponseEntity<Hero>(hero, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Hero> createHero(@RequestBody Hero hero) {
        Hero newHero = repository.save(hero);
        return new ResponseEntity<Hero>(newHero, HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hero> updateHero(@PathVariable("id") Long id, @RequestBody Hero hero) {
        Hero updatedHero = repository.save(hero);
        return new ResponseEntity<Hero>(updatedHero, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Hero> deleteHero(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return new ResponseEntity<Hero>(HttpStatus.ACCEPTED);
    }

}
