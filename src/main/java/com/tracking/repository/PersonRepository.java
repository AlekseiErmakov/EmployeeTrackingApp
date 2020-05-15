package com.tracking.repository;

import com.tracking.model.Person;

import java.util.List;

public interface PersonRepository {
    void save(Person person);
    Person findById(Long id);
    List<Person> findAll();
    void deleteById(Long id);
}
