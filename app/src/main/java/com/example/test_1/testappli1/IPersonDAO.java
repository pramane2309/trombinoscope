package com.example.test_1.testappli1;

import java.util.List;

public interface IPersonDAO {

    public List<Person> getPersons();

    public void addPerson(Person person);

    public void removePerson(Person person);
}
