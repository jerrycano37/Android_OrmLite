package com.sostesanic.ormlite.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.sostesanic.ormlite.R;
import com.sostesanic.ormlite.database.Database;
import com.sostesanic.ormlite.entidades.Usuarios;
import com.sostesanic.ormlite.servicios.UsuariosServicios;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        List<Usuarios> items = new UsuariosServicios(Database.getHelper()).getAll();
    }
}