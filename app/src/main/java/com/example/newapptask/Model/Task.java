package com.example.newapptask.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class Task implements Serializable {
    private String mTitle;
    private String mDescription;
    private Date mDate;
    private Date mTime;
    private TaskState mState;
    private boolean mSolved;
    private UUID mId;
    private UUID mUserId;

    public Task() {
        mId = UUID.randomUUID();
    }

    public Task(UUID id) {
        mId = id;
        mDate = new Date();
        mTime = new Date();
    }

    public Task(String title, String description, Date date, Date time, TaskState state,
                boolean solved, UUID id, UUID userId) {
        mTitle = title;
        mDescription = description;
        mDate = date;
        mTime = time;
        mState = state;
        mSolved = solved;
        mId = id;
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

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public UUID getId() {
        return mId;
    }

    public void setId(UUID id) {
        mId = id;
    }

    public UUID getUserId() {
        return mUserId;
    }

    public void setUserId(UUID userId) {
        mUserId = userId;
    }
}
