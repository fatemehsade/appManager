package com.example.newapptask.DataBase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.newapptask.Model.Task;

import java.util.List;
import java.util.UUID;

@Dao
public interface TaskTableDao {
    @Query(value = "SELECT * FROM Task")
    List<Task> getList();
    @Query(value = "SELECT * FROM TASK WHERE userId=:userId")
    List<Task> getListWithUserId(UUID userId);
    @Query(value = "SELECT * FROM TASK WHERE state=:taskSate AND userId=:userId")
    List<Task> getListWithState(String taskSate,UUID userId);
    @Query(value = "SELECT * FROM TASK  WHERE tas=:taskId")
    Task get(UUID taskId);
    @Delete
    void delete(Task element);
    @Insert
    void insert(Task element);
    @Update
    void update(Task element);

}
