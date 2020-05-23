package com.tracking.dto;

import com.tracking.annotation.validation.Password;
import com.tracking.annotation.validation.PhoneNumber;
import com.tracking.annotation.validation.Username;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserDto extends AbstractDto {

    @Username(message = "Имя пользователя от 3 до 15 символов латинского алфавита и цифр")
    private String username;

    @Password(message = "Пароль от 3 до 15 символов латинского алфавита, должен содержать одну прописную букву, одну строчную и одну цифру")
    private String password;

    @Email(message = "Недопустимый адрес электронной почты")
    private String email;

    @PhoneNumber(message = "Недопустимый номер телефона")
    private String phoneNumber;

    private String passwordConfirmed;

    private String emailConfirmed;



}
