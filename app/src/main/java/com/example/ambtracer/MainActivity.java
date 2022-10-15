package com.example.ambtracer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.logging.Handler;

public class MainActivity extends AppCompatActivity {
    Handler handler;
    Runnable runnable;
    ImageView  img;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.img);
                img.animate().alpha(4000).setDuration(0);

                handler = new Handler();
                handler.postDelayed(new Runnable(){
                    @Override
                    public void run(){
                        Intent dep = new Intent(MainActivity.this, LoginActivity.class);
                                startActivity(dep);
                                finish();
                    }
                },)
    }
}
