package com.mikronexus.dejavoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.mikronexus.dejavoo.databinding.ActivityMainBinding;

import java.text.DateFormat;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.packageName.setText(getApplicationContext().getPackageName());
        binding.proceed.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClassName("com.mikronexus.cfa", "com.mikronexus.cfa.MainActivity");
            startActivity(intent);
        });

        Handler handler = new Handler(Looper.getMainLooper());
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                long currentTime = System.currentTimeMillis();
                binding.dateTime.setText(DateFormat.getTimeInstance().format(currentTime));
                handler.postDelayed(this, 1000); // update text every second
            }
        };
        handler.post(runnable);
    }
}