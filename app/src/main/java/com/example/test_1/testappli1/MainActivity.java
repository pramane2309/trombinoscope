package com.example.test_1.testappli1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    Button btn_trombinoscope;
    Button  btn_addPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_trombinoscope = (Button) findViewById(R.id.btn_trombinoscope);

        btn_trombinoscope.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i(TAG, "REDIRECTION VERS PERSONSLIST");
                Toast.makeText(getApplicationContext(), "BIENVENUE AU TROMBINOSCOPE", Toast.LENGTH_LONG).show();
                Intent activityChangeIntent = new Intent(MainActivity.this, PersonsListActivity.class);
                MainActivity.this.startActivity(activityChangeIntent);
            }
        });

        btn_addPerson = (Button) findViewById(R.id.btn_addpersonredirect);
        btn_addPerson.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i(TAG, "REDIRECTION VERS ADD PERSON");
                Intent activityChangeIntent = new Intent(MainActivity.this, AddPersonActivity.class);
                MainActivity.this.startActivity(activityChangeIntent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        mDbHelper.close();
        super.onDestroy();
    }
}


