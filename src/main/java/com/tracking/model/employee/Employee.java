package com.tracking.model.employee;

import com.tracking.model.AbstractEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employee")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false,onlyExplicitlyIncluded = true)
public class Employee extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;

    @Column(name = "num")
    @EqualsAndHashCode.Include private String num;

    @Column(name = "first_name")
    @EqualsAndHashCode.Include private String firstName;

    @Column(name = "last_name")
    @EqualsAndHashCode.Include private String lastName;

    @Column(name = "birthday")
    @EqualsAndHashCode.Include private LocalDate birthday;

    @Column(name = "gender")
    @EqualsAndHashCode.Include private Character gender;

    @Column(name = "is_remote")
    private Boolean isRemote;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "contact_id", referencedColumnName = "contact_id")
    private Contact contact;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "post_id")
    private Post post;


    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getIsRemoteDescription() {
        return isRemote ? "Удаленная работа" : "Работа в офисе";
    }

    public int getAge() {
        LocalDate now = LocalDate.now();
        int yearDif = now.getYear() - birthday.getYear();
        return now.getDayOfYear() - birthday.getDayOfYear() >= 0 ? --yearDif : yearDif;
    }

}
