package com.example.work;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

public class RecAdapter extends RecyclerView.Adapter<RecAdapter.MyViewHolder> {

public int images[]={R.drawable.food1,R.drawable.food2,R.drawable.food3,R.drawable.food4};

    public class MyViewHolder extends RecyclerView.ViewHolder {
      public ImageView img;

        public MyViewHolder(View view) {
            super(view);
            img =  view.findViewById(R.id.imageview);

        }
    }


    public RecAdapter() {

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rec_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
holder.img.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
