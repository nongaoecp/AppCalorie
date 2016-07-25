package com.example.ao.calorie;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main3Activity extends AppCompatActivity implements
        View.OnClickListener {
    String BMI ;
    String BMR ;
    String sum ;
    String date_time;
    String name ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main3);
        BMI = getIntent().getExtras().getString("BMI");
        BMR = getIntent().getExtras().getString("BMR");
        sum = getIntent().getExtras().getString("sum");
        name = getIntent().getExtras().getString("NAME");

        TextView _name = (TextView) findViewById(R.id.text_name); //แสดงชื่อ
        _name.setText("ชื่อ "+ name);

        TextView _bmi = (TextView) findViewById(R.id.text_bmi); //แสดงbmi
        _bmi.setText("BMI คือ "+ BMI);

        TextView calfood = (TextView) findViewById(R.id.text_sum);
        calfood.setText("รวม "+sum +" กิโลแคลอรี");   //แสดงค่าผลรวมที่กินครั้งนั้น

        TextView _BMR = (TextView) findViewById(R.id.text_bmr);
        _BMR.setText("BMR คือ "+ BMR+" กิโลแคลอรี");      //แสดง BMR

        Button btnSave = (Button)  findViewById(R.id.button_save); //เมื่อกดปุ่มบันทึก
        btnSave.setOnClickListener(this);

    }

    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.button_save:  //เมื่อกดปุ่มบันทึก

                Intent intent = new Intent(Main3Activity.this, Database.class); //ไปหน้าdatabase
                intent.putExtra("sum", sum);
                intent.putExtra("BMR", BMR);
                intent.putExtra("NAME", name);
                intent.putExtra("BMI", BMI); //ส่งทั้ง 3 ค่าไป
                intent.putExtra("check", 1); //ส่ง 1 ไปเผื่อให้หน้านั้นรู้ว่าจะมีการเก็บข้อมูล
                date_time(); //เรียกใช้ฟังก์ชั่นเวลา
                intent.putExtra("date_time", date_time);    //ส่งเวลาไป
                startActivity(intent);
                break;
        }
    }
    public void date_time(){
        // Current Date
        Calendar c = Calendar.getInstance();
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy"); // date d-m-y
        SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss"); //  time H,m,s
        date_time = "วันที่:"+date.format(c.getTime())+"   เวลา:"+time.format(c.getTime());
    }

}
