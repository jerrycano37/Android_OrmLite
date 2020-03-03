package com.sostesanic.ormlite.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.sostesanic.ormlite.entidades.Usuarios;

import java.sql.SQLException;

public class Database extends OrmLiteSqliteOpenHelper {

    private static final String CAN_T_CREATE_DATABASE = "Can't create database";
    private static final String DATABASE_NAME = "sostesanic.db";
    private static final int DATABASE_VERSION = 9;
    private static Database gHelper = new Database(AppSupport.getInstance());

    private Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static Database getHelper() {
        return gHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            onCreateTables(connectionSource);
        } catch (Exception e) {
            Log.e(Database.class.getName(), CAN_T_CREATE_DATABASE, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            onDelete(connectionSource);
            onCreateTables(connectionSource);
        } catch (Exception e) {
            Log.e(Database.class.getName(), CAN_T_CREATE_DATABASE, e);
            throw new RuntimeException(e);
        }
    }

    private void onCreateTables(ConnectionSource connectionSource) {
        try {
            TableUtils.createTableIfNotExists(connectionSource, Usuarios.class);

        } catch (SQLException e) {
            Log.e(Database.class.getName(), CAN_T_CREATE_DATABASE, e);
            throw new RuntimeException(e);
        }
    }

    private void onDelete(ConnectionSource connectionSource) {
        try {
            TableUtils.dropTable(connectionSource, Usuarios.class, true);
        } catch (Exception e) {
            Log.e(Database.class.getName(), CAN_T_CREATE_DATABASE, e);
            throw new RuntimeException(e);
        }
    }
}