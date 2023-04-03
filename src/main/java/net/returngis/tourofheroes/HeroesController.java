package net.returngis.tourofheroes;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hero")
public class HeroesController {

    private HeroRepository repository;

    public HeroesController(HeroRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    public Iterable<Hero> getHeroes(@RequestParam(value = "name", defaultValue = "World") String name) {

        return repository.findAll();
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

}
