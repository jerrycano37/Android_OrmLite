package com.sostesanic.ormlite.entidades;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.util.Date;

@DatabaseTable(tableName = "Usuarios")
public class Usuarios {

    @DatabaseField(useGetSet = true, columnName = "COD_USUARIOS", dataType = DataType.STRING, canBeNull = true, width = 30, uniqueIndexName = "PK_USUARIOS", id = true)
    private String codUsuarios;

    @DatabaseField(useGetSet = true, columnName = "CLAVE", dataType = DataType.STRING, canBeNull = true)
    private String clave;

    @DatabaseField(useGetSet = true, columnName = "NOMBRE", dataType = DataType.STRING, canBeNull = true, width = 100)
    private String nombre;

    @DatabaseField(useGetSet = true, columnName = "F_ALTA", dataType = DataType.DATE, canBeNull = false)
    private Date falta;

    @DatabaseField(useGetSet = true, columnName = "F_BAJA", dataType = DataType.DATE, canBeNull = true)
    private Date fbaja;

    @DatabaseField(useGetSet = true, columnName = "COD_EMPLEADO", dataType = DataType.LONG, canBeNull = true)
    private long codEmp;

    public Usuarios() { }

    public String getCodUsuarios() {
        return codUsuarios;
    }

    public void setCodUsuarios(String codUsuarios) {
        this.codUsuarios = codUsuarios;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFalta() {
        return falta;
    }

    public void setFalta(Date falta) {
        this.falta = falta;
    }

    public Date getFbaja() {
        return fbaja;
    }

    public void setFbaja(Date fbaja) {
        this.fbaja = fbaja;
    }

    public long getCodEmp() {
        return codEmp;
    }

    public void setCodEmp(long codEmp) {
        this.codEmp = codEmp;
    }
}
