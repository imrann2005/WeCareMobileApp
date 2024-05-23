package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class FindDoctorActivity extends AppCompatActivity {
    TextView tv;
    ImageView iv1,iv2,iv3,iv4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_find_doctor );

//        CardView exit = findViewById( R.id.cardFDBack );
//        exit.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity( new Intent( FindDoctorActivity.this, HomeActivity.class ) );
//            }
//        } );
        tv = findViewById(R.id.titleFindDoctorTop);


        tv.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent( FindDoctorActivity.this, DoctorDetailsActivity.class );
              it.putExtra( "title", "Family Physicians" );
                startActivity( it );
            }
        } );
        iv1 = findViewById(R.id.surgeon);
        iv2 = findViewById(R.id.familyPhysician);
        iv3 = findViewById(R.id.cardiologist);
        iv4 = findViewById(R.id.dentist);
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
                it.putExtra("title","Dentist");
                startActivity(it);;

            }
        });

        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
                it.putExtra("title","Surgeon");
                startActivity(it);;

            }
        });

        iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
                it.putExtra("title","Family Physicians");
                startActivity(it);;

            }
        });

        iv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
                it.putExtra("title","Cardiologist");
                startActivity(it);;

            }
        });







    }
}