package com.example.newapptask.Adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.newapptask.R.id;
import com.example.newapptask.Model.Task;
import com.example.newapptask.R;
import com.example.newapptask.TimeDateFormat;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;
import java.util.UUID;

import static android.os.Build.VERSION_CODES.R;

public class stateAdaptor extends RecyclerView.Adapter<stateAdaptor.Holder> {
    private List<Task> mTasks;
    private Context mContext;
    private onIconSelectListener mCallbacks;

    public List<Task> getTasks() {
        return mTasks;
    }

    public void setTasks(List<Task> tasks) {
        mTasks = tasks;
    }

    public stateAdaptor(List<Task> tasks, Context context ,onIconSelectListener iconSelectListener) {
        mTasks = tasks;
        mContext = context;
        mCallbacks=iconSelectListener;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(mContext);
        View view=inflater.inflate(com.example.newapptask.R.layout.item_view,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.bind(mTasks.get(position));

    }

    @Override
    public int getItemCount() {
        return mTasks.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        private MaterialTextView mTitle,mDate,mTime,mImage;
        private MaterialButton mBtn_show;
        private Task mTask;

        public Holder(@NonNull View itemView) {
            super(itemView);
            findViews(itemView);
            setListener();
        }

        private void findViews(@NonNull View itemView) {
            mTitle=itemView.findViewById(id.txt_view_title);
            mDate=itemView.findViewById(id.txt_view_date);
            mTime=itemView.findViewById(id.txt_view_time);
            mBtn_show=itemView.findViewById(id.btn_show);
            mImage=itemView.findViewById(id.txt_view_image);
        }
        public void bind(Task task){
            mTask=task;
            mTitle.setText(task.getTitle());
            mDate.setText(TimeDateFormat.getDateFormat(task.getDate()));
            mTime.setText(TimeDateFormat.getTimeFormat(task.getTime()));
            mImage.setText(mTask.getTitle().substring(0,1));

        }
        public void setListener(){
            mBtn_show.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCallbacks.OnaSelectShowBtn(mTask.getId());

                }
            });
        }
    }
    public interface onIconSelectListener{
        void OnaSelectShowBtn(UUID taskId);
    }
}
