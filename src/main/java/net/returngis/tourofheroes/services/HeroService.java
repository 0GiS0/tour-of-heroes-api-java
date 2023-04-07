package net.returngis.tourofheroes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import net.returngis.tourofheroes.models.Hero;
import net.returngis.tourofheroes.repositories.HeroRepository;

@Service
public class HeroService {

    @Autowired
    private HeroRepository repository;

    @Cacheable(value = "heroes", key = "#root.method.name")
    public Iterable<Hero> getHeroes() {
        System.out.println("Invoked getHeroes ..");
        return repository.findAll();
    }

    @Cacheable(value = "heroes", key = "#id")
    public Hero findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Hero save(Hero hero) {
        return repository.save(hero);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
