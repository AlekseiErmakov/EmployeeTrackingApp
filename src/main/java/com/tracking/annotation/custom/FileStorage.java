package com.tracking.annotation.custom;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
public @interface FileStorage {
    Class<?> key();
    String location();
}
