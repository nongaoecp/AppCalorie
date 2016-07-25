package com.example.ao.calorie;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Exercise extends AppCompatActivity {

    String[] arr = {"วิ่ง","เดิน","ปั่นจักรยาน","เต้นแอโรบิก","เต้น Samba","ทำงานบ้าน","ทำสวน","มวยไทย","เดินขึ้นบันได","แบตมินตัน","ฮูลาฮุป","บาสเกตบอล"};


    int[] arr2 = {435,167,508,399,500,250,450,800,650,400,380,660};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_exercise);
        TableLayout tlb = (TableLayout)findViewById(R.id.tlb2);
        for (int i = 0; i < arr.length; i++) {
            TableRow tRow = new TableRow(this);
            TextView txt = new TextView(this);
            txt.setText(arr[i] + "   " + arr2[i] + " กิโลแคลอรี่/ชั่วโมง");
            txt.setTextSize(15);
            tRow.addView(txt);
            tlb.addView(tRow);
        }
    }
}