package net.returngis.tourofheroes;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeroesController {
    
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    //http://localhost:8080/heroes
    @RequestMapping("/heroes")
    public Hero hero(@RequestParam(value="name", defaultValue="World") String name) {
        return new Hero(counter.incrementAndGet(),
                            String.format(template, name));
    }

}
