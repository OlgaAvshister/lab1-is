package org.lab1.data.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.*;
import org.lab1.web.bean.data.Identable;

import java.time.LocalDateTime;

@Entity
@Table(name = "location")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location implements Identable, Ownerable {

    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; // Primary key, auto-generated

    @Column
    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @Column(nullable = false)
    private long x;

    @Column(nullable = false)
    private double y;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User owner; // Cannot be null

    public void setName(String name) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Name cannot be null or empty");
        this.name = name;
    }

}