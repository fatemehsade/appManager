package com.example.newapptask.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.example.newapptask.DataBase.TaskManagerSchema.TASK.taskColumns;

import com.example.newapptask.DataBase.TaskManagerSchema;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import static com.example.newapptask.DataBase.TaskManagerSchema.TASK.taskColumns;

@Entity
public class Task implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private Long mId ;
    @ColumnInfo(name = taskColumns.TIME)
    private String mTitle;
    @ColumnInfo(name = taskColumns.DESCRIPTION)
    private String mDescription;
    @ColumnInfo(name = taskColumns.DATE)
    private Date mDate;
    @ColumnInfo(name = taskColumns.TIME)
    private Date mTime;
    @ColumnInfo(name = taskColumns.STATE)
    private TaskState mState;
    @ColumnInfo(name = taskColumns.ID)
    private UUID mUUID;
    @ColumnInfo(name = taskColumns.USERID)
    private UUID mUserId;
    @ColumnInfo(name = taskColumns.IMG_ADDRESS)
    private String mImgAddress;

    public Task() {
        mUUID = UUID.randomUUID();
        mImgAddress="";
    }

    public String getImgAddress() {
        return mImgAddress;
    }

    public void setImgAddress(String imgAddress) {
        mImgAddress = imgAddress;
    }

    public Task(UUID id) {
        mUUID = id;
        mDate = new Date();
        mTime = new Date();
    }

    public Task(String title, String description, Date date, Date time, TaskState state,
                 UUID id, UUID userId) {
        mTitle = title;
        mDescription = description;
        mDate = date;
        mTime = time;
        mState = state;
        mUUID = id;
        mUserId = userId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public Date getTime() {
        return mTime;
    }

    public void setTime(Date time) {
        mTime = time;
    }

    public TaskState getState() {
        return mState;
    }

    public void setState(TaskState state) {
        mState = state;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public UUID getUUID() {
        return mUUID;
    }

    public void setUUID(UUID UUID) {
        mUUID = UUID;
    }

    public UUID getUserId() {
        return mUserId;
    }

    public void setUserId(UUID userId) {
        mUserId = userId;
    }
}
