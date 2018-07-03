package com.example.test_1.testappli1;

import java.util.List;

public class PersonDataDAO implements IPersonDAO {
    @Override
    public List<Person> getPersons() {
        return  DataPerson.persons;
    }

    @Override
    public void addPerson(Person person) {
        DataPerson.persons.add(person);
    }

    @Override
    public void removePerson(Person person) {DataPerson.persons.remove(person);}
}