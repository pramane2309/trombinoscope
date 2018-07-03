package com.example.test_1.testappli1.dao;

import com.example.test_1.testappli1.dto.Person;

import java.util.List;

public interface IPersonDAO {

    public List<Person> getPersons();

    public void addPerson(Person person);

    public void removePerson(Person person);
}
