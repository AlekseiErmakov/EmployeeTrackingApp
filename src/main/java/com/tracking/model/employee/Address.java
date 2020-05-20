package com.tracking.model.employee;

import com.tracking.model.tabel.AbstractEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Address extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    @EqualsAndHashCode.Exclude private Long id;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "house")
    private String house;

    @Column(name = "flat")
    private String flat;

    @OneToOne(orphanRemoval = true, mappedBy = "address")
    private Employee employee;

    public String getFullAddress(){
        return "г. " + city + " ул. " + street +
                " д. " + house + " кв. " + flat;

    }
    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", flat=" + flat +
                '}';
    }
}
