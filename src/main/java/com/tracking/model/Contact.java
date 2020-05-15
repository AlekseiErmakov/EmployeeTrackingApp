package com.tracking.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "contact")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Contact extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "person_id")
    private Person person;
}
