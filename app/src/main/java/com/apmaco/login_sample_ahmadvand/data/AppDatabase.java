package com.apmaco.login_sample_ahmadvand.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.apmaco.login_sample_ahmadvand.data.dao.LoginResultEntity;
import com.apmaco.login_sample_ahmadvand.data.entity.LoginResultDao;

@Database(entities = {LoginResultEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract LoginResultDao loginResultDao();

    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "soap_login_db")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }
}