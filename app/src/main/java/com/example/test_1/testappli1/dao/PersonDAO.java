package com.example.test_1.testappli1.dao;

import com.example.test_1.testappli1.DataPerson;
import com.example.test_1.testappli1.Person;
import com.example.test_1.testappli1.dao.IPersonDAO;

import java.util.List;

public class PersonDAO implements IPersonDAO {
    @Override
    public List<Person> getPersons() {
        return DataPerson.persons;
    }

    @Override
    public void addPerson(Person person) {
        DataPerson.persons.add(person);
    }

    @Override
    public void removePerson(Person person) {
        DataPerson.persons.remove(person);
    }
}