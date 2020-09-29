package com.example.imagestorage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdepter extends RecyclerView.Adapter<MyAdepter.MyViewHolder> {

    private Context context;
    private List<Upload> uploadList;

    public MyAdepter(Context context, List<Upload> uploadList) {
        this.context = context;
        this.uploadList = uploadList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(context);
       View view= layoutInflater.inflate(R.layout.sample_layout,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Upload upload=uploadList.get(position);
        holder.namev.setText(upload.getName());
        holder.agev.setText("Age: "+upload.getAge());
        Picasso.with(context).load(upload.getUri()).placeholder(R.mipmap.ic_launcher_round).fit().centerCrop().into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return uploadList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView namev,agev;
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            namev=itemView.findViewById(R.id.setnameid);
            agev=itemView.findViewById(R.id.setageid);
            imageView=itemView.findViewById(R.id.setimageid);
        }
    }
}
