package net.returngis.tourofheroes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "heroes")
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String alterEgo;
    @Column(length = 1000)
    private String description;

    protected Hero() {

    }

    public Hero(String name, String alterEgo, String description) {
        this.name = name;
        this.alterEgo = alterEgo;
        this.description = description;
    }

    public String toString() {
        return String.format(
                "Hero[id=%d, name='%s', alterEgo='%s']",
                id, name, alterEgo);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAlterEgo() {
        return alterEgo;
    }

    public String getDescription() {
        return description;
    }

}