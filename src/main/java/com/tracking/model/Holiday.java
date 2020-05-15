package com.tracking.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "holiday_weekend")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Holiday extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "holiday_weekend_id")
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne
    private Code code;
}
