package com.sostesanic.ormlite.database;

import android.app.Application;
import android.content.ComponentCallbacks2;
import android.database.sqlite.SQLiteDatabase;

import com.sostesanic.ormlite.comunes.Logit;
import com.sostesanic.ormlite.comunes.SystemUtils;

import java.util.ArrayList;
import java.util.List;

public class AppSupport extends Application {

    private static AppSupport gInstance = null;
    public static List<IMemoryInfo> memInfoList = new ArrayList<>();

    public static AppSupport getInstance() {
        return gInstance;
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        if (level >= ComponentCallbacks2.TRIM_MEMORY_RUNNING_LOW) {
            try {
                for (int i = memInfoList.size() - 1; i >= 0; i--) {
                    try {
                        memInfoList.get(i).goodTimeToReleaseMemory();
                    } catch (Exception e) {
                        Logit.getInstance(SystemUtils.LOG_DEFAULT_NAME).error(Logit.stringStackTrace(e));
                    }
                }
            } catch (Exception e) {
                Logit.getInstance(SystemUtils.LOG_DEFAULT_NAME).error(Logit.stringStackTrace(e));
            }
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        gInstance = this;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        if (Database.getHelper() != null) {
            SQLiteDatabase.releaseMemory();
            Database.getHelper().close();
        }
    }

    public interface IMemoryInfo {
        void goodTimeToReleaseMemory();
    }
}
