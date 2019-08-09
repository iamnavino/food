package com.example.work;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;

public class Food extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener,sete{
    private RecyclerView rec;
    private AppBarLayout mAppBarLayout;
    private Button fab;
    private Toolbar mToolbar;
    private  ImageView im;
    public int images[]={R.drawable.food1,R.drawable.food2,R.drawable.food3,R.drawable.food4,R.drawable.food5,R.drawable.food6,R.drawable.food7,R.drawable.food8};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        mToolbar        = findViewById(R.id.main_toolbar);
        mAppBarLayout   = findViewById(R.id.main_appbar);
        fab=findViewById(R.id.fab);
        im=findViewById(R.id.im);
        setSupportActionBar(mToolbar);
        mAppBarLayout.addOnOffsetChangedListener(this);
rec=findViewById(R.id.recycler_view);
rec.setAdapter(new RecAdapter(rec,this,images));
rec.setHasFixedSize(true);
rec.setLayoutManager(new GridLayoutManager(this,2));
       getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility()|View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int offset) {
        int maxScroll = appBarLayout.getTotalScrollRange();
        float percentage = (float) Math.abs(offset) / (float) maxScroll;
        if(percentage>0.68){
            getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility()|View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            if(percentage>0.75){
                int a=(int)(percentage*100);
                int b=a-75;
                float c=b/0.20f;
                mToolbar.setY(-c);
                getWindow().setStatusBarColor(Color.WHITE);
            }
            else {
                fab.setVisibility(View.INVISIBLE);
                TextView title = mToolbar.findViewById(R.id.text_middle);
                title.setText("Taste On Way");
                title.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
                title.setTextColor(Color.BLACK);
                title.setVisibility(View.VISIBLE);
                ImageView left = findViewById(R.id.ic_left);
                left.setImageResource(R.drawable.ic_arrow_back_black);
                ImageView right = findViewById(R.id.ic_right);
                right.setImageResource(R.drawable.ic_share_black);
                mToolbar.setBackgroundColor(Color.WHITE);
                getWindow().setStatusBarColor(Color.WHITE);
                appBarLayout.setVisibility(View.INVISIBLE);
            }
        }
        else {
            fab.setVisibility(View.VISIBLE);
            mToolbar.setVisibility(View.VISIBLE);
            TextView title=mToolbar.findViewById(R.id.text_middle);
                title.setVisibility(View.INVISIBLE);
                ImageView left=findViewById(R.id.ic_left);
                left.setImageResource(R.drawable.ic_arrow_back_white);
                ImageView right=findViewById(R.id.ic_right);
                right.setImageResource(R.drawable.ic_share_white);
            mToolbar.setBackgroundColor(Color.TRANSPARENT);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
            appBarLayout.setVisibility(View.VISIBLE);
         if(getWindow().getDecorView().getSystemUiVisibility()!=1024)
            getWindow().getDecorView().setSystemUiVisibility(1024);
        }

    }

    @Override
    public void setIm(int i) {
       im.setImageResource(images[i]);
    }

}
