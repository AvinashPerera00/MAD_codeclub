package com.example.madit20246914.database;

import android.provider.BaseColumns;

public final class UsersMaster {
    //Constructor
    private UsersMaster(){}

    /*Inner class that defines table content*/
    public static class family implements BaseColumns{
        public static final String TABLE_NAME = "family";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_NIC = "nic";

    }

}
