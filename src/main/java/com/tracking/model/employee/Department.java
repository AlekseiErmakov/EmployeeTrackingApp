package com.tracking.model.employee;


import com.tracking.model.AbstractEntity;
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
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class Department extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Long id;

    @Column(name = "name")
    @EqualsAndHashCode.Include
    private String name;

    @Column(name = "label")
    private String label;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private Set<Employee> employees = new HashSet<>();

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'';
    }


}
