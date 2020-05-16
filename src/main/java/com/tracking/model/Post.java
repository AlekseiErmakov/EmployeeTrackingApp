package com.tracking.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "post")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Post extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    @EqualsAndHashCode.Exclude private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "post",fetch = FetchType.LAZY)
    private Set<Employee> employees = new HashSet<>();
}
