package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {

    private String[][] packages = {
            {"package 1 : Full Body Checkup", "", "", "", "999"},
            {"package 2 : Blood Glucose Fasting", "", "", "", "299"},
            {"package 3 : COVID-19 Antibody - IgG", "", "", "", "899"},
            {"package 4 : Thyroid Check", "", "", "", "499"},
            {"package 5 : Immunity Check", "", "", "", "699"},
    };

    private String[] pacakages_details = {
            "Blood Glucose Fasting\n\n" +
                    "HbA1c\n\n" +
                    "Iron Studies\n\n" +
                    "Kidney Function\n" +
                    "LDH Lactate Dehyadrogenase, Serum\n" +
                    "Lipid Profile\n" +
                    "Liver Function\n" +
                    "Blood Glucose Fasting",
                 //   "Blood Glucose Fasting",
            "COVID-19 Antibody - IgG",
            "Thyroid Profile-Total(T3,T4 & TSH Ultra-sensitive)",
            "Complete hemogram\n" +
                    "CRP (C Reactive Protein) Quantitative , Serum\n" +
                    "Iron Studies\n" +
                    "Kidney Function Test \n" +
                    "Vitamin D Total- 25 Hydroxy\n" +
                    "Liver Function Test\n" +
                    "Liquid Profile"
    };

    HashMap<String, String> item;
    ArrayList<HashMap<String, String>> list;
    SimpleAdapter sa;
    Button btnLTGoToCart, btnLTBack;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        btnLTGoToCart = findViewById(R.id.buttonLTGoToCart);
        btnLTBack = findViewById(R.id.buttonLTBack);
        listview = findViewById(R.id.listViewLT);

        btnLTBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this, HomeActivity.class));
            }
        });

        list = new ArrayList<>();
        for (int i = 0; i < packages.length; i++) {
            item = new HashMap<>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Total Coast :" + packages[i][4] + "/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});
        listview.setAdapter(sa);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(LabTestActivity.this, LabTestDetailsActivity.class);
                it.putExtra("text1", packages[i][0]);
                it.putExtra("text2", packages[i][1]); // Corrected here
                it.putExtra("text3", packages[i][4]);
                startActivity(it);
            }
        });

//        btnLTGoToCart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(LabTestActivity.this, CartLabActivity.class));
//
//            }
      //  });
    }
}