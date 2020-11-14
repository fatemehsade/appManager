package com.example.newapptask.Model;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.example.newapptask.DataBase.TaskManagerSchema.User.*;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;
@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    private Long mId;
    @ColumnInfo(name =userColumns.USERNAME )
    private String userName;
    @ColumnInfo(name = userColumns.PASSWORD)
    private String password;
    @ColumnInfo(name = userColumns.MEMBERSHIP)
    private Date mMembership;
    @ColumnInfo(name = userColumns.UUID)
    private UUID userId;
    @ColumnInfo(name = userColumns.ISADMINE)
    private boolean isAdmin;

    public User() {
        userId=UUID.randomUUID();
    }

    public User(Long id, String userName, String password, Date membership, UUID userId, boolean isAdmin) {
        mId = id;
        this.userName = userName;
        this.password = password;
        mMembership = membership;
        this.userId = userId;
        this.isAdmin = isAdmin;
    }

    public User(String userName, String password) {
        this();
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UUID getUserId() {
        return userId;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public Date getMembership() {
        return mMembership;
    }

    public void setMembership(Date membership) {
        mMembership = membership;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName) &&
                Objects.equals(password, user.password) &&
                Objects.equals(userId, user.userId);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(userName, password, userId);
    }
}


