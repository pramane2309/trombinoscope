package com.example.test_1.testappli1.data;

import android.graphics.Color;

import com.example.test_1.testappli1.dto.Person;

import java.util.ArrayList;
import java.util.List;

public class DataPerson {
    public static List<Person> persons = new ArrayList<Person>() {{
        add(new Person("Salahddine", "ABERKAN", Color.BLACK));
        add(new Person("Salahddine1", "ABERKAN1", Color.BLUE));
    }};

}
