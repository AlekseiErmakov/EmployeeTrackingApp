package com.tracking.model.employee;


import com.tracking.model.tabel.AbstractEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "department")
@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
public class Department extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    @EqualsAndHashCode.Exclude private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "department",fetch = FetchType.LAZY)
    private Set<Employee> employees = new HashSet<>();
}
