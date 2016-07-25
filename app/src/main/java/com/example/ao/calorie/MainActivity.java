package com.example.ao.calorie;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {
    EditText name ;
    RadioButton mySex1 ; //เพศชาย
    RadioButton mySex2 ; //เพศหญิง
    EditText height ; //แทนส่วนสูง
    EditText weight ; //แทนน้ำหนัก
    EditText age; //อายุ
    int BMR ; //ค่า BMR
    float calbmi;// ค่า bmi
    String BMI ; // เก็บค่า BMI ที่เป็นข้อความเพื่อง่ายต่อการนำไปแสดง

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main); //แสดงหน้านี้

        mySex1 = (RadioButton) findViewById(R.id.male); //แทนเพศชาย
        mySex2 = (RadioButton) findViewById(R.id.female);  //แทนเพศหญิง
        Button btnSubmit = (Button) findViewById(R.id.submit_button); //ปุ่มSubmit
        Button btnBmi = (Button)  findViewById(R.id.button_bmi); //ปุ่มคำนวณBMI
        Button btnShow = (Button)  findViewById(R.id.button_his); //ปุ่มเรียกดูประวัติ
        btnSubmit.setOnClickListener(this);
        btnBmi.setOnClickListener(this);
        btnShow.setOnClickListener(this); //เมื่อมีการกด

    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_his:   //ถ้ากดปุ่มดูประวัติ
                Intent intent = new Intent(MainActivity.this, Database.class); //จากclassนี้ไปยังclass database
                intent.putExtra("check", 0); //ส่ง 0 ไปเผื่อไปตรวจเงื่อนไขว่าแค่แสดงข้อมูลไม่มีการรับเพิ่ม
                startActivity(intent);
                break;
            case R.id.button_bmi:   //เมื่อกดปุ่ม bmi
                calBMI();       //เรียกใช้ฟังก์ชั่นคำนวณ bmi
                Intent intent3 = new Intent(MainActivity.this, bmi.class); //ไปคลาสคำนวณ bmi
                intent3.putExtra("BMI", calbmi);    //ส่งค่า bmi ที่คำนวณได้ไปด้วย
                startActivity(intent3);
                break;
            case R.id.submit_button: //เมื่อกดปุ่ม submit
                name = (EditText) findViewById(R.id.edit_name); //ช่องกรอกน้ำหนัก

                String _name = name.getText().toString();

                calBMI();       //เรียกใช้ฟังก์ชั่นคำนวณ bmi
                calBMR();       //เรียกใช้ฟังก์ชั่นคำนวณ bmr
                Intent intent2 = new Intent(MainActivity.this, Main2Activity.class); //ไปคลาสต่อไป
                intent2.putExtra("BMI", BMI); //ส่งค่า bmi ที่คำนวณได้ไปด้วย
                intent2.putExtra("BMR", BMR);//ส่งค่า bmr ที่คำนวณได้ไปด้วย
                intent2.putExtra("NAME", _name);
                startActivity(intent2);
                break;
        }
    }
    public void calBMR(){    //ฟังกชั่น คำนวณ BMR
        height = (EditText) findViewById(R.id.hight_edit); //ช่องกรอกส่วนสูง
        weight = (EditText) findViewById(R.id.weight_edit); //ช่องกรอกน้ำหนัก
        age = (EditText) findViewById(R.id.age_edit); //ช่องกรอกอายุ

        int _height = Integer.parseInt(height.getText().toString()); //นำค่าที่กรอกแปลงเป็นตัวเลข
        int _weight = Integer.parseInt(weight.getText().toString()); //นำค่าที่กรอกแปลงเป็นตัวเลข
        int _age = Integer.parseInt(age.getText().toString()); //นำค่าที่กรอกแปลงเป็นตัวเลข
        if(mySex1.isChecked()==true){ //ถ้าหากตัวแปร mySex1 ถูกเลือกแสดงว่าเป็นเพศ ชาย ใช้สูตรนี้
            BMR =   Integer.valueOf((int) (66+(13.7*_weight)+(5*_height)-(6.8*_age))); //คำนวณ BMI ของเพศชาย
        }
        else { //ถ้าไม่ใช้แสดงว่าเพศหญิง ใช้สูตรนี้
            BMR = Integer.valueOf((int) (665+(9.6*_weight)+(1.8*_height)-(4.7*_age))); //คำนวณ BMI ของเพศหญิง
        }

    }
    public void calBMI(){  //ฟังกชั่น คำนวณ BMI
        height = (EditText) findViewById(R.id.hight_edit); //ช่องกรอกส่วนสูง
        weight = (EditText) findViewById(R.id.weight_edit); //ช่องกรอกน้ำหนัก

        int _height = Integer.parseInt(height.getText().toString()); //นำค่าที่กรอกแปลงเป็นตัวเลข
        int _weight = Integer.parseInt(weight.getText().toString()); //นำค่าที่กรอกแปลงเป็นตัวเลข
        float height_p3 = (float) _height/100;
        float height_p31 = height_p3*height_p3; //หาส่วนสูงกำลังสอง
        calbmi = (float) _weight/height_p31; //จากสูตร น้ำหนักหารส่วนสูงกำลัง2
        BMI =String.format("%.2f", calbmi); //แปลงค่าที่คำนวณได้เป็นข้อความทศนิยม2ตำแหน่ง
    }


}
