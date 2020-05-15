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

    @Column(name = "num")
    private String num;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "sex")
    private Sex sex;

    @Column(name = "is_remote")
    private Boolean isRemote;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToOne(mappedBy = "person",fetch = FetchType.LAZY)
    private Address address;

    @OneToOne(mappedBy = "person",fetch = FetchType.LAZY)
    private Contact contact;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private Post post;

}
