package com.example.newapptask;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.DialogFragment;

import com.example.newapptask.Cotroller.Fragment.StateFragment;
import com.example.newapptask.Model.Task;
import com.example.newapptask.Model.TaskState;
import com.example.newapptask.Repository.TaskDBRepository;

import java.io.Serializable;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import java.util.zip.Inflater;

public class AddDialog extends DialogFragment {
    public static final String EXTRA_NEW_TASK = "com.example.newapptask.New Task";
    public static final String EXTRA_TAB_NAME = "TabName";
    public static final String EXTRA_USER_ID = "USER_id";
    private EditText mEditText_title,mEditText_description;
    private Button mButton_save,mButton_cancle;
    private DatePicker mDatePicker;
    private TimePicker mTimePicker;
    private TaskDBRepository mRepository;
    private Task mTask=new Task();
    private String mTabName;
    private UUID mUserId;


    public static AddDialog newInstance(String tabName,UUID userId) {

        Bundle args = new Bundle();
        args.putString(EXTRA_TAB_NAME,tabName);
        args.putSerializable(EXTRA_USER_ID,userId);
        AddDialog fragment = new AddDialog();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserId= (UUID) getArguments().get(EXTRA_USER_ID);
        mTabName=getArguments().getString(EXTRA_TAB_NAME);
        mRepository=TaskDBRepository.getInstance(getContext());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.add_dialog_fragment,container,false);
        findViews(view);
        setListener();
        return view;
    }

    private void findViews(View view) {
        mEditText_title=view.findViewById(R.id.edit_dialog_title);
        mButton_cancle=view.findViewById(R.id.dialog_btn_cancle);
        mButton_save=view.findViewById(R.id.dialog_btn_save);
        mDatePicker=view.findViewById(R.id.date_picker_dialog);
        mTimePicker=view.findViewById(R.id.time_picker_dialog);
        mEditText_description=view.findViewById(R.id.edit_dialog_description);
    }

    private void setListener(){
        mButton_save.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                returnTask();
                mRepository.insert(mTask);
                sendData();
                dismiss();
            }
        });
        mButton_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void returnTask(){
        if(!mEditText_title.equals(""))
            mTask.setTitle(mEditText_title.getText().toString());
        else
            mTask.setTitle("");

        if (!mEditText_description.equals(""))
            mTask.setDescription(mEditText_description.getText().toString());
        else
            mTask.setDescription("");

        if (mDatePicker!=null)
            mTask.setDate(getDate(mDatePicker));
        else
            mTask.setDate(new Date());

        if (mTimePicker!=null)
            mTask.setTime(getTime(mTimePicker));
        else
            mTask.setTime(new Date());

        mTask.setUserId(mUserId);
        mTask.setState(TaskState.valueOf(mTabName));
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private Date getTime(TimePicker timePicker){
        Calendar calendar=Calendar.getInstance();
        int hour=timePicker.getHour();
        calendar.set(Calendar.HOUR,hour);
        int minute=timePicker.getMinute();
        calendar.set(Calendar.MONTH,minute);
        return calendar.getTime();
    }

    private Date getDate(DatePicker datePicker){
        Calendar calendar=Calendar.getInstance();
        int year=datePicker.getYear();
        calendar.set(Calendar.YEAR,year);
        int month=datePicker.getMonth();
        calendar.set(Calendar.MONTH,month);
        int dayOfMonth=datePicker.getDayOfMonth();
        calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        return calendar.getTime();
    }
    private void sendData(){
        Intent intent=new Intent();
        intent.putExtra("new task", mTask);
        getTargetFragment().onActivityResult(
                StateFragment.REQUEST_CODE_ADD_TASK, Activity.RESULT_OK,intent);
    }
}
