package org.lab1.data.entity;

import javax.persistence.*;

import lombok.*;
import org.lab1.web.bean.data.Identable;

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Identable, Ownerable {

    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary key, auto-generated

    @Column(nullable = false)
    private String street;


    @Column(nullable = false, length = 29)
    private String zipCode;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User owner; // Cannot be null

    public long getId() {
        return id;
    }
}