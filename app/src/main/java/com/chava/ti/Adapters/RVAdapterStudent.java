package com.chava.ti.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.chava.ti.Activities.Details_Claustro;
import com.chava.ti.Activities.Details_Student;
import com.chava.ti.Models.Student;
import com.chava.ti.Models.Teacher;
import com.chava.ti.R;

import java.util.List;

public class RVAdapterStudent extends RecyclerView.Adapter<RVAdapterStudent.MyViewHolder>{

    private Context context;
    private List<Student> data;

    public RVAdapterStudent(Context context, List<Student> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.card_student, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        String name = data.get(position).getName() + " " + data.get(position).getLastName();
        String job = data.get(position).getJob();
        int photo = data.get(position).getPhoto();
        holder.txt_Name.setText(name);
        holder.txt_Job.setText(job);
        holder.photo.setImageResource(photo);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Details_Student.class);

                //Pass info from Student to new Activity
                intent.putExtra("Name",data.get(position).getName());
                intent.putExtra("Lastname", data.get(position).getLastName());
                intent.putExtra("Area", data.get(position).getJob());
                intent.putExtra("Mail", data.get(position).getMail());
                intent.putExtra("Photo", data.get(position).getPhoto());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView txt_Name, txt_Job;
        ImageView photo;
        CardView cardView;

        public MyViewHolder(View itemView){
            super(itemView);
            txt_Name = (TextView) itemView.findViewById(R.id.StudentName);
            txt_Job = (TextView) itemView.findViewById(R.id.Job);
            photo = (ImageView)itemView.findViewById(R.id.imageStudent);
            cardView = (CardView) itemView.findViewById(R.id.card_student);
        }
    }
}
