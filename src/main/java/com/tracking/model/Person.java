package com.tracking.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "person")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Person extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long id;

    private String num;

    private String firstName;

    private String lastName;

    private LocalDate birthday;

    private Boolean isRemote;

    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

}
