package com.tracking.model.employee;

import com.tracking.model.AbstractEntity;
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
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class Post extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(name = "name")
    @EqualsAndHashCode.Include
    private String name;

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
    private Set<Employee> employees = new HashSet<>();
}
