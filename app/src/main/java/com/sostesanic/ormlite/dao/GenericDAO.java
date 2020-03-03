package com.sostesanic.ormlite.dao;

import com.sostesanic.ormlite.comunes.Logit;
import com.sostesanic.ormlite.comunes.SystemUtils;
import com.sostesanic.ormlite.database.Database;
import java.util.List;

public class GenericDAO<E> {
    private Class<E> type;
    private Database helper;

    public GenericDAO(Database helper, Class<E> type) {
        this.helper = helper;
        this.type = type;
        Logit log = Logit.getInstance();
        log.setFileName(SystemUtils.LOG_DEFAULT_NAME);
        log.setProgramName(this.getClass().getCanonicalName());
    }

    public List<E> getAll() {
        return helper.getRuntimeExceptionDao(type).queryForAll();
    }
}
