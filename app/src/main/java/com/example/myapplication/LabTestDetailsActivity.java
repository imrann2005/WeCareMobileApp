package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;

public class LabTestDetailsActivity extends AppCompatActivity {

    TextView tvPackageName, tvTotalCost;
    EditText edDetails;
    Button btnLDAddToCart, btnLDBack;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_details);

        tvPackageName = findViewById(R.id.textViewLDPackageName);
        tvTotalCost = findViewById(R.id.textViewLDTotalCost);
        edDetails = findViewById(R.id.editTextLDTextMultiline);
        btnLDAddToCart = findViewById(R.id.buttonLDAddToCart);
        btnLDBack = findViewById(R.id.buttonLDBack);

        edDetails.setKeyListener(null);

        Intent intent = getIntent();
        tvPackageName.setText(intent.getStringExtra("text1"));
        edDetails.setText(intent.getStringExtra("text2"));
     //   edDetails.setText(formatedDetails.toString().trim());
        tvTotalCost.setText("Total Cost : " + intent.getStringExtra("text3") + "/-");
        // Set the details text with newline characters
        String detailsText = intent.getStringExtra("text2");
        if (detailsText != null) {
            String[] detailsLines = detailsText.split("\\\\\n");
            StringBuilder formattedDetails = new StringBuilder();
            for (String line : detailsLines) {
                formattedDetails.append(line).append("\n");
            }
            edDetails.setText(formattedDetails.toString().trim());
        }

        tvTotalCost.setText("Total Cost : " + intent.getStringExtra("text3") + "/-");

        btnLDBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestDetailsActivity.this, LabTestActivity.class));
            }
        });

        btnLDAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username", "").toString();
                XmlPullParser tv1 = null;
                String product = tv1.getText().toString();
                float price = Float.parseFloat(intent.getStringExtra("text3").toString());
            }
        });
    }
}



