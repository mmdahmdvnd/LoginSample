package com.apmaco.login_sample_ahmadvand.data.entity;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.apmaco.login_sample_ahmadvand.data.dao.LoginResultEntity;

@Dao
public interface LoginResultDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(LoginResultEntity result);

    @Query("SELECT * FROM login_results WHERE username = :username ORDER BY timestamp DESC LIMIT 1")
    LoginResultEntity getLatestResult(String username);

    @Query("DELETE FROM login_results WHERE timestamp < :expiry")
    void deleteExpired(long expiry);
}
