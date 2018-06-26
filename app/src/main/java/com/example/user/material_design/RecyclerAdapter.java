package com.example.user.material_design;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Viewholder> {
    ArrayList<set> book;
    private Context context;

    public RecyclerAdapter(ArrayList<set> book,Context context) {
       this.book = book;
        this.context = context;
    }


    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.card_list,parent,false);
        return new Viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
          holder.descp.setText(book.get(position).getName());
        Glide.with(context)
                .asBitmap()
                .load(book.get(position).getUrl())
                .into(holder.book);

    }

    @Override
    public int getItemCount() {
        return book.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{
          ImageView book;
          TextView descp;
        public Viewholder(View itemView) {
            super(itemView);
            book= itemView.findViewById(R.id.book);
            descp = itemView.findViewById(R.id.descp);

        }
    }
}
