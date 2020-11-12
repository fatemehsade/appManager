package com.example.newapptask.Repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.newapptask.DataBase.TaskManagerHelper;
import com.example.newapptask.Model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDBRepository implements IRepository<User> {
    private static UserDBRepository sInstance;
    private SQLiteDatabase mDatabase;
    private Context mContext;
    private List<User> mUsers=new ArrayList<>();

    private UserDBRepository(Context context) {
        mContext = context.getApplicationContext();
        TaskManagerHelper taskManagerHelper=new TaskManagerHelper(context);
        mDatabase=taskManagerHelper.getWritableDatabase();
    }

    public static UserDBRepository getInstance(Context context){
        if (sInstance==null)
            sInstance=new UserDBRepository(context);
        return sInstance;
    }

    @Override
    public List<User> getList() {
        return null;
    }

    @Override
    public User get(String user)
    {
        for (int i = 0; i <mUsers.size() ; i++) {
            if (mUsers.get(i).getUserName().equals(user.toString())){
                return mUsers.get(i);
            }
        }
        return null;
    }

    @Override
    public void delete(User element) {

    }

    @Override
    public void update(User element) {

    }

    @Override
    public void insert(User element) {
        mUsers.add(element);

    }
    public boolean userExist(String UserName){
        for (int i = 0; i <mUsers.size() ; i++) {
            if (mUsers.get(i).getUserName().equals(UserName))
                return true;

        }
        return false;

    }
}
