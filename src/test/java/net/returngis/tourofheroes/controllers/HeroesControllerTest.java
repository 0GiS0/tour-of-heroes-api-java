package net.returngis.tourofheroes.controllers;

import net.returngis.tourofheroes.models.Hero;
import net.returngis.tourofheroes.services.HeroService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class HeroesControllerTest {

    @InjectMocks
    HeroesController heroesController;

    @Mock
    HeroService heroService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getHeroesReturnsAllHeroes() {
        Hero hero1 = new Hero();
        Hero hero2 = new Hero();
        List<Hero> heroes = Arrays.asList(hero1, hero2);

        when(heroService.getHeroes()).thenReturn(heroes);

        ResponseEntity<Iterable<Hero>> response = heroesController.getHeroes();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(heroes, response.getBody());
    }

    @Test
    void getHeroByIdReturnsCorrectHero() {
        Hero hero = new Hero();
        Long id = 1L;
        when(heroService.findById(id)).thenReturn(hero);

        ResponseEntity<Hero> response = heroesController.getHeroById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(hero, response.getBody());
    }

    @Test
    void getHeroByIdReturnsNotFoundForInvalidId() {
        Long id = 1L;
        when(heroService.findById(id)).thenReturn(null);

        ResponseEntity<Hero> response = heroesController.getHeroById(id);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void createHeroReturnsCreatedHero() {
        Hero hero = new Hero();
        when(heroService.save(any(Hero.class))).thenReturn(hero);

        ResponseEntity<Hero> response = heroesController.createHero(hero);

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(hero, response.getBody());
    }

    @Test
    void updateHeroReturnsUpdatedHero() {
        Hero hero = new Hero();
        Long id = 1L;
        when(heroService.save(any(Hero.class))).thenReturn(hero);

        ResponseEntity<Hero> response = heroesController.updateHero(id, hero);

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(hero, response.getBody());
    }

    @Test
    void deleteHeroReturnsAcceptedStatus() {
        Long id = 1L;
        doNothing().when(heroService).deleteById(id);

        ResponseEntity<Hero> response = heroesController.deleteHero(id);

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
    }
}