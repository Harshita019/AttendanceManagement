package com.example.database;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AttendanceRvAdapter extends RecyclerView.Adapter<AttendanceRvAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<AttendanceModal> attendanceModalArrayList;
    private Context context;

    // constructor
    public AttendanceRvAdapter(ArrayList<AttendanceModal> attendanceModalArrayList, Context context) {
        this.attendanceModalArrayList = attendanceModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.attendance_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        AttendanceModal modal = attendanceModalArrayList.get(position);
        holder.date.setText(modal.getLoginDate());
        holder.time.setText(modal.getLoginTime());
        holder.remark.setText(modal.getLoginRemark());

    }


    @Override
    public int getItemCount() {
        return attendanceModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name, date, time, remark;

        ImageButton delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.rv_empDate);
            time = itemView.findViewById(R.id.rv_empTime);
            remark = itemView.findViewById(R.id.rv_empRemark);


        }
    }
}
