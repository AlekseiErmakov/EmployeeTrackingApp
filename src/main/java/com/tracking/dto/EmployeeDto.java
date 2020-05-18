package com.tracking.dto;

import com.tracking.model.Address;
import com.tracking.model.Contact;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class EmployeeDto extends AbstractDto {

    private Long id;

    private String num;

    private String firstName;

    private String lastName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    private Character gender;

    private Address address;

    private Contact contact;

    private Boolean isRemote;

    private Long departmentId;

    private Long postId;
}
