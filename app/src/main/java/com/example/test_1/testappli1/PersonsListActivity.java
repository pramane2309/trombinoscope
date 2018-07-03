package com.example.test_1.testappli1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class PersonsListActivity extends AppCompatActivity {

    ListView mListView;
    PersonAdapter adapter;

    public static List<Person> selectedPersons = new ArrayList<Person>();

    IPersonDAO personDAO

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        personDAO =new PersonDAO();

        setContentView(R.layout.activity_persons_list);

        mListView= (ListView) findViewById(R.id.personsList);

        adapter = new PersonAdapter(PersonsListActivity.this.personDAO.getPersons());
        mListView.setAdapter(adapter);

    }


}
