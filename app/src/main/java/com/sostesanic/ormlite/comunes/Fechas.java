package com.sostesanic.ormlite.comunes;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;

class Fechas {
    private static final String YYYYMMDDHORAGUION = "yyyy-MM-dd HH:mm:ss";

    static String fechahoy() {
        Date date = new Date();
        StringBuilder fechahoy;
        @SuppressLint("SimpleDateFormat") SimpleDateFormat YYYYMMDD = new SimpleDateFormat(Fechas.YYYYMMDDHORAGUION);
        fechahoy = new StringBuilder(YYYYMMDD.format(date));
        return fechahoy.toString();
    }
}
