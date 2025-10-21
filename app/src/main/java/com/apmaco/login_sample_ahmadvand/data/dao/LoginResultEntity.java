package com.apmaco.login_sample_ahmadvand.data.dao;

import androidx.room.Entity;
import androidx.room.vo.Entity;

@Entity(tableName = "login_results")
public class LoginResultEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "username")
    public String username;

    @ColumnInfo(name = "result")
    public String result;

    @ColumnInfo(name = "timestamp")
    public long timestamp;
}
