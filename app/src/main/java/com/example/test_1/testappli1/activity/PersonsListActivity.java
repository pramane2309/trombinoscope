package com.example.test_1.testappli1.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.test_1.testappli1.dao.PersonSQLLiteDAO;
import com.example.test_1.testappli1.dto.Person;
import com.example.test_1.testappli1.adapter.PersonAdapter;
import com.example.test_1.testappli1.R;
import com.example.test_1.testappli1.dao.IPersonDAO;
import com.example.test_1.testappli1.dao.PersonDAO;
import com.example.test_1.testappli1.sqlite.PersonDBHelper;

import java.util.ArrayList;
import java.util.List;

public class PersonsListActivity extends AppCompatActivity {
    private static final String TAG = "PersonsListActivity";


    ListView mListView;
    PersonAdapter adapter;

    public static List<Person> selectedPersons = new ArrayList<Person>();
    public static List<View> selectedChilds = new ArrayList<View>();


    IPersonDAO personDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //personDAO   =new PersonDataDAO();
        personDAO = new PersonSQLLiteDAO(PersonDBHelper.getInstance(this));

        setContentView(R.layout.activity_persons_list);

        mListView = (ListView) findViewById(R.id.personsList);

        adapter = new PersonAdapter(PersonsListActivity.this, personDAO.getPersons());
        mListView.setAdapter(adapter);

        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int pos, long id) {
                Person person = (Person) arg0.getItemAtPosition(pos);
                Toast.makeText(getApplicationContext(), "POS : " + pos + ", ID : " + id + ", PERSON :" + person, Toast.LENGTH_LONG).show();


                View child = arg0.getChildAt(pos);
                if (!selectedChilds.contains(child)) {
                    Log.i(TAG, "SELECT");
                    // CHANGE BACKGROUD
                    arg0.getChildAt(pos).setBackgroundColor(Color.GRAY);
                    Log.i(TAG, "SET MARKER");
                    // ADD in SELECTED LIST
                    selectedChilds.add(child);
                    selectedPersons.add(person);
                } else {
                    Log.i(TAG, "UNSELECT");
                    arg0.getChildAt(pos).setBackgroundColor(Color.WHITE);
                    Log.i(TAG, "UNSET MARKER");

                    if (selectedChilds.contains(child))
                        selectedChilds.remove(child);
                    if (selectedPersons.contains(person))
                        selectedPersons.remove(person);
                }

                return true;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /* Use AppCompatActivity's method getMenuInflater to get a handle on the menu inflater */
        MenuInflater inflater = getMenuInflater();
        /* Use the inflater's inflate method to inflate our menu layout to this menu */
        inflater.inflate(R.menu.trombinoscope_menu, menu);
        /* Return true so that the menu is displayed in the Toolbar */
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_delete) {
            Toast.makeText(getApplicationContext(), "SUPPRIMER", Toast.LENGTH_LONG).show();
            // SUPPRIMER
            for (Person person : selectedPersons) {
                Log.i(TAG, "REMOVE :" + person);
                personDAO.removePerson(person);
            }
            reloadAllData();
            selectedChilds.clear();
            selectedPersons.clear();
        }

        return super.onOptionsItemSelected(item);
    }

    private void reloadAllData() {
        Log.i(TAG, "RELOAD NEW DATA :" + personDAO.getPersons());
        // CLEAR AND ADD ALL, NOT TO USE WHEN LISTDATA
        adapter.clear();
        adapter.addAll(personDAO.getPersons());
        // UPDATE
        adapter.notifyDataSetChanged();
        // Set Back White back ground
        for (View child : selectedChilds) {
            child.setBackgroundColor(Color.WHITE);
        }
    }

}

