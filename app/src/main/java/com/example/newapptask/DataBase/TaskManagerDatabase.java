package com.example.newapptask.DataBase;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.example.newapptask.Model.Task;
import com.example.newapptask.Model.User;

@Database(entities = {Task.class, User.class},version = TaskManagerSchema.VERSION)
public abstract class TaskManagerDatabase extends RoomDatabase {
    public abstract TaskTableDao getTaskTableDao();
    public abstract UserTableDao getUserTableDao();


}
