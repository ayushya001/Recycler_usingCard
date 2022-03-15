package com.example.recycler_usingcard.Adapterclass;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycler_usingcard.MainActivity2;
import com.example.recycler_usingcard.Modelclass.Model;
import com.example.recycler_usingcard.R;
import java.util.ArrayList;
import java.util.zip.Inflater;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.myviewholder> {
    ArrayList<Model> data;
    Context context;

    public MyAdapter(ArrayList<Model> data,Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.singlerow,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        final Model temp = data.get(position);  //--> This is temporary model class to nikaal le data from corresponding model class

        holder.t1.setText(data.get(position).getHeader());
        holder.t2.setText(data.get(position).getDesc());
        holder.img.setImageResource(data.get(position).getImgname());

        holder.c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MainActivity2.class);
                intent.putExtra("imagename",temp.getImgname());
                intent.putExtra("header",temp.getHeader());
                intent.putExtra("desc",temp.getDesc());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public class myviewholder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView t1, t2;
        CardView c1;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img1);
            t1 = (TextView) itemView.findViewById(R.id.t1);
            t2 = (TextView) itemView.findViewById(R.id.t2);
            c1 = (CardView) itemView.findViewById(R.id.cardView);
        }
    }
}
