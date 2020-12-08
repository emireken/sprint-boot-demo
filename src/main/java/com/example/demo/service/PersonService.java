package com.example.demo.service;

import com.example.demo.dao.PersonDataAccessService;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDataAccessService personDataAccessService;

    @Autowired
    public PersonService(PersonDataAccessService personDataAccessService) {
        this.personDataAccessService = personDataAccessService;
    }

    public List<Person> getAllPeople(){
        return personDataAccessService.selectAllPeople();
    }


    public int addPerson(Person person) {
        return personDataAccessService.insertPerson(person);
    }


    public Optional<Person> getPersonById (UUID id) {
        return personDataAccessService.selectPersonById(id);
    }

    public int deletePerson(UUID id) {
        return personDataAccessService.deletePersonById(id);
    }

    public int updatePerson(UUID id, Person newPerson) {
        return personDataAccessService.updatePersonById(id, newPerson);
    }
}
