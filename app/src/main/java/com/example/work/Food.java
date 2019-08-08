package com.example.work;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;

public class Food extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener{
    private RecyclerView rec;
    private AppBarLayout mAppBarLayout;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        mToolbar        = findViewById(R.id.main_toolbar);
        mAppBarLayout   = findViewById(R.id.main_appbar);
        setSupportActionBar(mToolbar);
        mAppBarLayout.addOnOffsetChangedListener(this);
getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE|View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
rec=findViewById(R.id.recycler_view);
rec.setAdapter(new RecAdapter());
rec.setHasFixedSize(true);
rec.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int offset) {
        int maxScroll = appBarLayout.getTotalScrollRange();
        float percentage = (float) Math.abs(offset) / (float) maxScroll;
        if(percentage>0.65){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE|View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
           if(mToolbar!=null){
TextView title=mToolbar.findViewById(R.id.text_middle);
title.setVisibility(View.VISIBLE);
title.setTextSize(15);
title.setTextColor(Color.BLACK);
title.setText("Taste On Way");
ImageView left=findViewById(R.id.ic_left);
left.setImageResource(R.drawable.ic_arrow_back_black);
ImageView right=findViewById(R.id.ic_right);
right.setImageResource(R.drawable.ic_share_black);
mToolbar.setBackgroundColor(Color.WHITE);
getWindow().setStatusBarColor(Color.TRANSPARENT);
appBarLayout.setVisibility(View.INVISIBLE);
           }
           if(rec.getY()<140) {
               getWindow().setStatusBarColor(Color.WHITE);
              mToolbar.setY(-(140f-rec.getY()));
           }
        }
        else {
            if(mToolbar!=null) {
                mToolbar.setVisibility(View.VISIBLE);
                TextView title=mToolbar.findViewById(R.id.text_middle);
                title.setVisibility(View.INVISIBLE);
                ImageView left=findViewById(R.id.ic_left);
                left.setImageResource(R.drawable.ic_arrow_back_white);
                ImageView right=findViewById(R.id.ic_right);
                right.setImageResource(R.drawable.ic_share_white);
                mToolbar.setBackgroundColor(Color.TRANSPARENT);
                appBarLayout.setVisibility(View.VISIBLE);
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE|View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            }
        }
    }
}
