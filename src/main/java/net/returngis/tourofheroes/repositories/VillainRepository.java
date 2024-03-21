package net.returngis.tourofheroes.repositories;

import net.returngis.tourofheroes.models.Villain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VillainRepository extends JpaRepository<Villain, Long> {
}