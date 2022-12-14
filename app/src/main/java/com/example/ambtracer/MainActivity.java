package com.example.ambtracer;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Handler handler;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        img = findViewById(R.id.img);
        img.animate().setDuration(0);

        handler = new Handler();

        handler.postDelayed(() -> {
            Intent dsp = new Intent(MainActivity.this,LoginActivity.class);
            startActivity(dsp);
            finish();
        },4000);
    }

}