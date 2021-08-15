package com.example.recyclerview;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.Recy.Adapter;
import com.example.recyclerview.Recy.ItemData;
import com.example.recyclerview.Recy.ViewType;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView product_name;
    private ImageButton open_bu;
    private Dialog dialog;
    private ImageView iv_image;
    private ItemData item;
    public ArrayList<ItemData>list_s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Text
        product_name=(TextView)findViewById(R.id.name);
        product_name.setSingleLine(true);    // 한줄로 표시하기
        product_name.setEllipsize(TextUtils.TruncateAt.MARQUEE); // 흐르게 만들기
        product_name.setSelected(true);      // 선택하기


        BtnOnClickListener onClickListener = new BtnOnClickListener();
        //inflation layout
        open_bu = (ImageButton) findViewById(R.id.open);
        open_bu.setOnClickListener(onClickListener);

        //all review
        Button all_review = (Button) findViewById(R.id.all_review);
        all_review.setOnClickListener(onClickListener);

        RecyclerView recyclerView = findViewById(R.id.recyclerView_s);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        list_s = new ArrayList<>();
        for(int i=0; i<100 ;i++){
            item= new ItemData("a","b","c","d","f");
            list_s.add(item);
        }
        Adapter adapter = new Adapter(ViewType.small,list_s);
        recyclerView.setAdapter(adapter);

    }

    class BtnOnClickListener implements Button.OnClickListener{
        @Override
        public void onClick(View view){
            switch (view.getId()) {
                case R.id.all_review:
                    Intent intent = new Intent(getApplicationContext(), Total_Review.class);
                    intent.putExtra("Item", list_s);
                    startActivity(intent);
                    break;
            }
        }
    }

    //hide
    public void hideNavigationBar() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                // Set the content to appear under the system bars so that the
                // content doesn't resize when the system bars hide and show.
                // Hide the nav bar and status bar
                 View.SYSTEM_UI_FLAG_HIDE_NAVIGATION| View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideNavigationBar();
        }
    }

}