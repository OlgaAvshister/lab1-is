package org.lab1.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.lab1.data.entity.enums.EventType;
import org.lab1.web.bean.data.Identable;

import java.time.ZonedDateTime;

@Entity
@Table(name = "event")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event implements Identable, Ownerable {

    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; // Primary key, auto-generated

    @Column(nullable = false)
    @NotEmpty(message = "Name cannot be empty")
    private String name; // Cannot be null, string cannot be empty

    @Column
    private ZonedDateTime date;

    @Column
    private long minAge;

    @Column
    private int ticketsCount = 1;

    @Column
    private EventType eventType;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User owner; // Cannot be null

    public void setName(String name) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Name cannot be null or empty");
        this.name = name;
    }

}