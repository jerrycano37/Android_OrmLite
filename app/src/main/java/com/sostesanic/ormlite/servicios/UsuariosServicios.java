package com.sostesanic.ormlite.servicios;

import com.sostesanic.ormlite.dao.GenericDAO;
import com.sostesanic.ormlite.database.Database;
import com.sostesanic.ormlite.entidades.Usuarios;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class UsuariosServicios {
    private GenericDAO<Usuarios> usuariosDAO;

    public UsuariosServicios(Database helper) {
        usuariosDAO = new GenericDAO<>(helper, Usuarios.class);
    }

    public List<Usuarios> getAll() {
        return usuariosDAO.getAll();
    }
}
