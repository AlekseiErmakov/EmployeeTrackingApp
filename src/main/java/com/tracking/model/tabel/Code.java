package com.tracking.model.tabel;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "code")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Code extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_id")
    @EqualsAndHashCode.Exclude private Long id;

    @Column(name = "char_code")
    private String charCode;

    @Column(name = "description")
    private String description;
}