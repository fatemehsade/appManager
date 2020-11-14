package com.example.newapptask.Repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.newapptask.DataBase.TaskManagerHelper;
import com.example.newapptask.Model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskDBRepository implements IRepository<Task> {
    private static TaskDBRepository sInstance;
    private SQLiteDatabase mDataBase;
    private Context mContext;
    private List<Task> mTasks=new ArrayList<>();

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

    public List<Task> getListWithUserId(UUID userId){
        List<Task> tasks=new ArrayList<>();
        for (Task task:getList()){
            if (task.getUserId().equals(userId)){
                tasks.add(task);
            }
        }
        return tasks;

    }

    @Override
    public List<Task> getList() {
        return mTasks;
    }

    @Override
    public Task get(String user) {
        return null;
    }


    public Task get(UUID taskId){
        for (int i = 0; i <mTasks.size() ; i++) {
            if (mTasks.get(i).getId().equals(taskId)){
                return mTasks.get(i);
            }

        }
        return null;
    }

    @Override
    public void delete(Task element) {
        for (int i = 0; i <mTasks.size() ; i++) {
            if (getList().get(i).equals(element)){
                getList().remove(i);
            }

        }

    }

    @Override
    public void update(Task element) {
        for (int i = 0; i <mTasks.size() ; i++) {
            if (getList().get(i).getId().equals(element.getId())){
                getList().remove(i);
                getList().add(i,element);
            }

        }

    }

    @Override
    public void insert(Task element) {
        mTasks.add(element);

    }
}
