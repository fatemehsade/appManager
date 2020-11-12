package com.example.newapptask.Repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.newapptask.DataBase.TaskManagerHelper;
import com.example.newapptask.Model.Task;

import java.util.List;

public class TaskDBRepository implements IRepository<Task> {
    private static TaskDBRepository sInstance;
    private SQLiteDatabase mDataBase;
    private Context mContext;

    private TaskDBRepository(Context context) {
        mContext = context.getApplicationContext();
        TaskManagerHelper taskManagerHelper=new TaskManagerHelper(mContext);
        mDataBase=taskManagerHelper.getWritableDatabase();
    }

    public static TaskDBRepository getInstance(Context context){
        if (sInstance==null)
            sInstance=new TaskDBRepository(context);
        return sInstance;
    }

    @Override
    public List<Task> getList() {
        return null;
    }

    @Override
    public Task get(String user) {
        return null;
    }

    @Override
    public void delete(Task element) {

    }

    @Override
    public void update(Task element) {

    }

    @Override
    public void insert(Task element) {



    }
}
