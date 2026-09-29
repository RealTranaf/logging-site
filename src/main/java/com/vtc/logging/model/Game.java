package com.vtc.logging.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Lob
    private String description;

    @Column(nullable = false)
    private Platform platform;

    @Column(nullable = false)
    private PubStatus status;

    public Game(String name, String description, Platform platform, PubStatus status) {
        this.name = name;
        this.description = description;
        this.platform = platform;
        this.status = status;
    }
}
