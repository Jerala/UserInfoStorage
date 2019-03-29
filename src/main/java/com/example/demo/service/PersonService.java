package com.example.demo.service;

import com.example.demo.dao.PersonDAO;
import com.example.demo.entity.Person;
import com.example.demo.model.PersonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class PersonService {

    @Autowired
    PersonDAO personDAO;
    @Autowired
    PasswordEncoder passwordEncoder;

    public Person createPersonEntity(PersonModel personModel) {
        Person person = new Person();
        person.setFirstName(personModel.getFirstName());
        person.setLastName(personModel.getLastName());
        person.setBirthDay(personModel.getBirthDay());
        person.setEmail(personModel.getEmail());
        person.setPassword(passwordEncoder.encode(personModel.getPassword()));
        return person;
    }

    public Person findByEmail(String email) {
        Iterable<Person> personIterable = personDAO.findAll();
        for (Person p: personIterable) {
            if (p.getEmail().equals(email)) {
                return p;
            }
        }
        return null;
    }

}
