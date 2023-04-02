package net.returngis.tourofheroes;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface HeroRepository extends CrudRepository<Hero, Long> {

    // List<Hero> getAll();

    // Hero findById(long id);

}
