package com.example.demo.controller;

import com.example.demo.dao.PersonDAO;
import com.example.demo.entity.Person;
import com.example.demo.model.PersonModel;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
public class PersonController {

    @Autowired
    PersonDAO personDAO;
    @Autowired
    PersonService personService;

    @GetMapping("/findByEmail/{email}")
    public Person findPersonByEmail(@PathVariable("email") String email) {
        return personService.findByEmail(email);
    }

    @PostMapping("/add")
    public Person addPerson(@RequestBody PersonModel personModel) {
        Person person = personService.createPersonEntity(personModel);
        return personDAO.save(person);
    }

    @PostMapping("/delete")
    public void deleteByEmail(@RequestParam(name = "email", required = true) String email) {
        personDAO.deleteByEmail(email);
    }
}
