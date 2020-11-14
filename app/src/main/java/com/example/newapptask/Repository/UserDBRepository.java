package com.example.newapptask.Repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.room.Room;

import com.example.newapptask.DataBase.TaskManagerDatabase;
import com.example.newapptask.DataBase.TaskManagerHelper;
import com.example.newapptask.DataBase.TaskManagerSchema;
import com.example.newapptask.DataBase.TaskTableDao;
import com.example.newapptask.DataBase.UserTableDao;
import com.example.newapptask.Model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserDBRepository implements IRepository<User> {
    private static UserDBRepository sInstance;
    private Context mContext;
    private List<User> mUsers=new ArrayList<>();
    private UserTableDao mDAO;

    private UserDBRepository(Context context) {
        mContext = context.getApplicationContext();
        TaskManagerDatabase dataBase=
                Room.databaseBuilder
                        (mContext,TaskManagerDatabase.class,
                                TaskManagerSchema.NAME).
                        allowMainThreadQueries().build();

        mDAO=dataBase.getUserTableDao();
        //TaskManagerHelper taskManagerHelper=new TaskManagerHelper(context);
       // mDatabase=taskManagerHelper.getWritableDatabase();
    }

    public static UserDBRepository getInstance(Context context){
        if (sInstance==null)
            sInstance=new UserDBRepository(context);
        return sInstance;
    }

    @Override
    public List<User> getList() {

        return mDAO.getList();
    }

    @Override
    public User get(UUID id){
        return mDAO.get(id);
    }
    public User get(String user)
    {
        /*for (int i = 0; i <mUsers.size() ; i++) {
            if (mUsers.get(i).getUserName().equals(user.toString())){
                return mUsers.get(i);
            }
        }

         */
        return mDAO.get(user);
    }

    @Override
    public void delete(User element) {
        mDAO.delete(element);

    }

    @Override
    public void update(User element) {
        mDAO.update(element);

    }

    @Override
    public void insert(User element) {
        //mUsers.add(element);
        mDAO.insert(element);

    }
    public boolean userExist(String userName){
          if (get(userName) != null)
            return true;
        return false;
    }


}
