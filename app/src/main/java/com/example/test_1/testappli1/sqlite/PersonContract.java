package com.example.test_1.testappli1.sqlite;

import android.provider.BaseColumns;

public class PersonContract {
    private PersonContract() {}
    /* Inner class that defines the table contents */
    public static class PersonEntry implements BaseColumns {
        public static final String TABLE_NAME = "person";
        public static final String COLUMN_NAME_FIRSTNAME = "firstname";
        public static final String COLUMN_NAME_LASTNAME = "lastname";
        public static final String COLUMN_NAME_AVATAR = "avatar";
    }
}
