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
import com.chava.ti.Models.Teacher;
import com.chava.ti.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{

    private Context context;
    private List<Teacher> data;

    public RecyclerViewAdapter(Context context, List<Teacher> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.cardview_item, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        String name = data.get(position).getName() + " " + data.get(position).getLastName();
        holder.txt_Name.setText(name);
        holder.photo.setImageResource(data.get(position).getPhoto());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Details_Claustro.class);

                //Pass info from Teacher to new Activity
                intent.putExtra("Name",data.get(position).getName());
                intent.putExtra("Lastname", data.get(position).getLastName());
                intent.putExtra("Area", data.get(position).getArea());
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
        TextView txt_Name;
        ImageView photo;
        CardView cardView;

        public MyViewHolder(View itemView){
            super(itemView);
            txt_Name = (TextView) itemView.findViewById(R.id.Teacher_Name);
            photo = (ImageView)itemView.findViewById(R.id.image);
            cardView = (CardView) itemView.findViewById(R.id.carditem);
        }
    }

}
