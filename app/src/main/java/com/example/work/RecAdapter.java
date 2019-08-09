package com.example.work;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.recyclerview.widget.RecyclerView;

public class RecAdapter extends RecyclerView.Adapter<RecAdapter.MyViewHolder> {
RecyclerView rec;
Food ac;
int images[];

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
      public ImageView img;

        public MyViewHolder(View view) {
            super(view);
            img =  view.findViewById(R.id.imageview);
view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
int pos=rec.getChildAdapterPosition(view);
ac.setIm(pos);

        }
    }


    public RecAdapter(RecyclerView rec, Food ac,int images[]) {
this.rec=rec;
this.ac=ac;
this.images=images;
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
holder.img.setClipToOutline(true);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }
}
