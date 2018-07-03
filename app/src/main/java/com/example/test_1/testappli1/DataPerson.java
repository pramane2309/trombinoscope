package com.example.test_1.testappli1;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

public class DataPerson {
    public static List<Person> persons =new ArrayList<Person>() {{
        add(new Person("Salahddine", "ABERKAN", Color.BLACK));
        add(new Person("Salahddine1", "ABERKAN1", Color.BLUE));
    }};

}
