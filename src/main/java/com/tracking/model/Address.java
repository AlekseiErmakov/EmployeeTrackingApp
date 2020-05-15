package com.tracking.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Address extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;

    private String city;

    private String street;

    private String house;

    private Integer flat;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "person_id")
    private Person person;
}
