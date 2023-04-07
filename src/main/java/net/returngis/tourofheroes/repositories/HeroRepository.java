package net.returngis.tourofheroes.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.returngis.tourofheroes.models.Hero;

@Repository
public interface HeroRepository extends CrudRepository<Hero, Long> {

}
