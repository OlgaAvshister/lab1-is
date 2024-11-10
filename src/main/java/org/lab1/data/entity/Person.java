package org.lab1.data.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.lab1.data.entity.enums.Color;
import org.lab1.web.bean.data.Identable;

@Entity
@Table(name = "person")
@Data
@NoArgsConstructor
public class Person implements Identable, Ownerable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; // Primary key, auto-generated

    @Column
    private Color eyeColor;

    @Column(nullable = false)
    private Color hairColor;

    @OneToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @Column(nullable = false)
    private int height = 1;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User owner; // Cannot be null

}
