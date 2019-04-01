package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;

public class Main2Activity extends AppCompatActivity {

    TableLayout tableLayout1,tableLayout2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tableLayout1=(TableLayout)findViewById(R.id.table1);
        tableLayout2=(TableLayout)findViewById(R.id.table2);
        tableLayout1.setVisibility(View.VISIBLE);
    }
    public void fine_details(View view)
    {
        tableLayout1.setVisibility(View.GONE);
        tableLayout1.setVisibility(View.INVISIBLE);
        tableLayout2.setVisibility(View.VISIBLE);
    }
}
