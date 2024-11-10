package org.lab1.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import lombok.*;
import org.lab1.data.entity.enums.VenueType;
import org.lab1.web.bean.data.Identable;

@Entity
@Table(name = "venue")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Venue implements Identable, Ownerable {

    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; // Primary key, auto-generated

    @Column(nullable = false)
    @NotEmpty(message = "Name cannot be empty")
    private String name; // Cannot be null, string cannot be empty

    @Column
    private long capacity = 1;

    @Column(nullable = false)
    private VenueType type;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User owner; // Cannot be null

    public void setName(String name) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Name cannot be null or empty");
        this.name = name;
    }

}