package com.tracking.model.employee;

import com.tracking.model.AbstractEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "contact")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Contact extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    @EqualsAndHashCode.Exclude private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @OneToOne(orphanRemoval = true, mappedBy = "contact")
    @EqualsAndHashCode.Exclude private Employee employee;

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
