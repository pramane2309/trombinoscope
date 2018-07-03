package com.example.test_1.testappli1.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.test_1.testappli1.R;
import com.example.test_1.testappli1.dao.IPersonDAO;
import com.example.test_1.testappli1.dao.PersonSQLLiteDAO;
import com.example.test_1.testappli1.dto.Person;
import com.example.test_1.testappli1.sqlite.PersonDBHelper;

public class AddPersonActivity extends AppCompatActivity {
    private static final String TAG = "AddPersonActivity";

    EditText prenom;
    EditText nom;
    Button btnAddPerson;

    IPersonDAO personDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        //personDAO   =new PersonDataDAO();
        personDAO = new PersonSQLLiteDAO(PersonDBHelper.getInstance(this));

        Log.i(TAG, "ici");
        setContentView(R.layout.activity_add_person);
        Log.i(TAG, "ici");
        prenom = (EditText) findViewById(R.id.input_lastnameadd);
        Log.i(TAG, "ici");
        nom = (EditText) findViewById(R.id.input_firstnameadd);
        Log.i(TAG, "ici");

        btnAddPerson = (Button) findViewById(R.id.btn_addperson);
        btnAddPerson.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i(TAG, "btnAddPerson.setOnClickListener");
                Person person = new Person(prenom.getText().toString(), nom.getText().toString(), Color.BLACK);
                personDAO.addPerson(person);
                Toast.makeText(getApplicationContext(), "PERSONNE AJOUTEE : " + person, Toast.LENGTH_LONG).show();

                prenom.setText("");
                nom.setText("");
            }
        });
    }

}

