package com.example.demo.dao;

import com.example.demo.entity.Person;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PersonDAO extends CrudRepository<Person, Long> {

    public Iterable<Person> findAll();

    public Person save(Person person);

    @Modifying
    @Transactional
    public void deleteByEmail(String email);

}
