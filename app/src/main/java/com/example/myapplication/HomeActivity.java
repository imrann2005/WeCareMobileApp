package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    TextView tv;
    ImageView iv;
    ImageView img1,img2,img3;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        tv = findViewById(R.id.logout);
        iv = findViewById(R.id.imageView);
        img1 = findViewById(R.id.img1);
        img3 = findViewById(R.id.img3);
        img2 = findViewById(R.id.img2);
        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", ""). toString();
        Toast.makeText(getApplicationContext(), "Welcome" + username, Toast.LENGTH_SHORT).show();


        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                startActivity(new Intent(HomeActivity.this, LoginActivity.class));
            }
        });

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                startActivity(new Intent(HomeActivity.this, LoginActivity.class));
            }
        });

//        CardView findDoctor = findViewById(R.id.cardFindDoctor);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, LabTestActivity.class));
            }
        });

        //CardView labTest = findViewById(R.id.cardLabTest);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, FindDoctorActivity.class));
            }
        });
        //CardView health = findViewById(R.id.cardHealthDoctor);
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, HealthArticlesActivity.class));
            }
        });

    }
}

