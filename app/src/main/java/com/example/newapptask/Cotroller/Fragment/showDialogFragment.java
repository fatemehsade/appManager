package com.example.newapptask.Cotroller.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.newapptask.Model.Task;
import com.example.newapptask.Model.TaskState;
import com.example.newapptask.R;
import com.example.newapptask.Repository.TaskDBRepository;
import com.example.newapptask.TimeDateFormat;
import com.google.android.material.button.MaterialButton;

import java.util.Date;
import java.util.UUID;

public class showDialogFragment extends DialogFragment {
    public static final String EXTRA_USER_ID = "User ID";
    private EditText mEditText_title,mEditText_description,
            mEditText_date,mEditText_time,mEditText_state;
    private MaterialButton mButton_delete,mButton_edit,mButton_cancel;
    private TaskDBRepository mRepository;
    private UUID mTaskId;
    private Task mTask;

    public static showDialogFragment newInstance(UUID userId) {

        Bundle args = new Bundle();
        args.putSerializable(EXTRA_USER_ID,userId);
        showDialogFragment fragment = new showDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRepository=TaskDBRepository.getInstance(getContext());
        mTaskId= (UUID) getArguments().get(EXTRA_USER_ID);
        mTask=mRepository.get(mTaskId);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.show_dialog_fragment,container,false);
        findViews(view);
        bind();
        setListener();
        return view;
    }

    private void findViews(View view) {
        mEditText_title=view.findViewById(R.id.show_dialog_title);
        mEditText_description=view.findViewById(R.id.show_dialog_description);
        mEditText_date=view.findViewById(R.id.show_dialog_date);
        mEditText_time=view.findViewById(R.id.show_dialog_time);
        mEditText_state=view.findViewById(R.id.show_dialog_state);
        mButton_edit=view.findViewById(R.id.show_dialog_edit);
        mButton_delete=view.findViewById(R.id.show_dialog_delete);
        mButton_cancel=view.findViewById(R.id.show_dialog_cancle);

    }
    private void setListener(){
        mButton_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();

            }
        });
        mButton_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRepository.delete(mTask);
                dismiss();

            }
        });
        mButton_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRepository.update(newTask(mTask));

                dismiss();

            }
        });
    }
    private void bind(){
        mEditText_title.setText(mTask.getTitle());
        mEditText_description.setText(mTask.getDescription());
        mEditText_date.setText(TimeDateFormat.getDateFormat(mTask.getDate()));
        mEditText_time.setText(TimeDateFormat.getTimeFormat(mTask.getTime()));
        mEditText_state.setText(mTask.getState().toString());

    }
    private Task newTask(Task task){
        task.setTitle(mEditText_title.getText().toString());
        task.setDescription(mEditText_description.getText().toString());
        task.setDate(new Date());
        task.setTime(new Date());
        task.setState(TaskState.valueOf(mTask.getState().toString()));

        return task;
    }
}
