package com.tracking.dto;

import com.tracking.model.employee.Address;
import com.tracking.model.employee.Contact;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = false)
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

    private String postName;

    public String getFullName(){
        return firstName + " " + lastName;
    }

    public String getIsRemoteDescription() {
        return isRemote ? "Удаленная работа" : "Работа в офисе";
    }

    public int getAge() {
        LocalDate now = LocalDate.now();
        int yearDif = now.getYear() - birthday.getYear();
        return now.getDayOfYear() - birthday.getDayOfYear() >= 0 ? yearDif : --yearDif;
    }
}
