package com.tracking.model.tabel;


import com.tracking.model.AbstractEntity;
import com.tracking.model.employee.Employee;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employee_day")
@Getter
@Setter
@NoArgsConstructor
public class EmployeeDay extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_day_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "date")
    private LocalDate localDate;

    @JoinColumn(name = "code_id")
    @ManyToOne
    private Code code;

    public EmployeeDay(Employee employee, LocalDate localDate){
        this.employee = employee;
        this.localDate = localDate;
    }
}
