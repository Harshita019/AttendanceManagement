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

public class EmployeeRVAdapter extends RecyclerView.Adapter<EmployeeRVAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<EmployeeModal> courseModalArrayList;
    private Context context;

    // constructor
    public EmployeeRVAdapter(ArrayList<EmployeeModal> courseModalArrayList, Context context) {
        this.courseModalArrayList = courseModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        EmployeeModal modal = courseModalArrayList.get(position);
        holder.empNameTV.setText(modal.getEmpName());
        holder.empDepartTV.setText(modal.getEmpDepartment());
        holder.empLoginTV.setText(modal.getEmpLoginId());
        holder.empPassTV.setText(modal.getEmpPassword());


    }


    @Override
    public int getItemCount() {
        return courseModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView empNameTV, empDepartTV, empLoginTV, empPassTV;

        ImageButton delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            empNameTV = itemView.findViewById(R.id.rv_empName);
            empDepartTV = itemView.findViewById(R.id.rv_empDepartment);
            empLoginTV = itemView.findViewById(R.id.rv_empLoginId);
            empPassTV = itemView.findViewById(R.id.rv_empPassword);


        }
    }
}
