package com.babylon.demo.dao;

import com.babylon.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDAO {

    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    List<Person> selectAllPeople();

    List<Person> searchPerson(Person person);

    Optional<Person> selectPersonById(UUID id);

    Optional<Person> selectPersonByEmail(String university_email);

    int deletePersonById(UUID id);

    int updatePersonById(UUID id, Person person);
}
