package com.babylon.demo.service;

import com.babylon.demo.dao.PersonDAO;
import com.babylon.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDAO personDAO;

    @Autowired
    public PersonService(@Qualifier("postgres") PersonDAO personDAO){
        this.personDAO = personDAO;
    }

    public int addPerson(Person person){
        return personDAO.insertPerson(person);
    }

    public List<Person> getAllPeople(){
        return personDAO.selectAllPeople();
    }

    public Optional<Person> getPersonById(UUID id){
        return personDAO.selectPersonById(id);
    }

    public int deletePerson(UUID id){
        return  personDAO.deletePersonById(id);
    }

    public  int updatePerson(UUID id, Person newPerson){
        return personDAO.updatePersonById(id, newPerson);
    }

    public int authenticate(Person person){
        Optional<Person> original = personDAO.selectPersonByEmail(person.getUniversity_email());
        if(original.isEmpty()) return 0;
        Person original_person = original.get();
        if(original_person.getPassword().equals(person.getPassword())) return 1;
        return 0;

    }

    public List<Person> searchPerson(Person person) {
        return personDAO.searchPerson(person);
    }

}
