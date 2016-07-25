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

public class bmi extends AppCompatActivity implements
        View.OnClickListener {
    String ms ;
    String suggestion ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi1);              //แสดงหน้านี้
        float calbmi = getIntent().getExtras().getFloat("BMI");  //รับค่าNMI ที่ส่งมา
        String BMI =String.format("%.2f", calbmi); //แปลงค่าBMIเป็นข้อความ

        TextView _bmi = (TextView) findViewById(R.id.textbmi1); //กำหนด textview ที่จะให้แสดง bmi ดูจาก id
        TextView _ms = (TextView) findViewById(R.id.textView9); //กำหนด textview ที่จะให้แสดง ข้อความ ดูจาก id
        if(calbmi<18.5) {
            ms = "น้อยกว่า 18.5 = น้ำหนักน้อยกว่ามาตรฐาน";
            suggestion = "โดยการรับประทานอาหารใน 1 วันควร มีค่าพลังงาน 1,500 กิโลแคลอรี่ขึ้น" +
                    "ไปรับประทานอาหารให้ครบ 5 หมู่ และออกกำลังกาย โดยจะเน้นของว่างที่มีไขมันและโปรตีนเพิ่มขึ้นเพื่อให้เหมาะสมกับสภาวะร่างกาย  " +
                    "เช่น  ขนมชั้น  273 กิโลแคลอรี่ เค้กผลไม้ 328 กิโลแคลอรี่ กล้วยแขก 326 กิโลแคลอรี่ ทุเรียนกวน  328 กิโลแคลอรี่ ขนมโดนัท 381 " +
                    "กิโลแคลอรี่ เม็ดขนุน 360 กิโลแคลอรี่ ช็อกโกแลตนม 520 กิโลแคลอรี่ ขนมปังแครกเกอร์ 423 กิโลแคลอรี่ ขนมโก๋ 425 กิโลแคลอรี่ เป็นต้น";
        }
        else if(calbmi>=18.5 && calbmi<= 22.9) {
            ms = "อยู่ระหว่าง 18.5-22.9 = น้ำหนักอยู่ในเกณฑ์ปกติ";
            suggestion = "การรับประทานอาหารใน 1 วัน ร่างกายควรได้รับพลังงาน 800 -1,200 กิโลแคลอรี่ รับประทานอาหารให้ครบ 5 หมู่ เน้นผัก ผลไม้ เช่น แกงจืด 150 กิโลแคลอรี่ ข้าวกระเพราไก่ 250 กิโลแคลอรี่  ส้ม 3ผล 75กิโลแคลรอรี่ กระเพาะปลา 150 กิโลแคลอรี่ ก๊วยจั๊บญวน 325 กิดลแคลอรี่ กล้วยบวชชี 150 กิโลแคลอรี่ แก้วมังกร 60กิโลแคลอรี่ เป็นต้น";
        }
        else if(calbmi>=22.9 && calbmi<= 24.9) {
            ms = "อยู่ระหว่าง 23-24.9 = เริ่มอ้วน";
            suggestion = "ใน 1 วันร่างกายควรได้รับพลังงาน  ต่ำกว่า 1,000 กิโลแคลอรี่  รับประทานผักและผลไม้ เน้นโปรตีน และออกกำลังการยอย่างสม่ำเสมอ เช่น สลัดผักอกไก่ 110 กิโลแคลอรี่  ผักจิ้มน้ำพริก 50 กิโลแคลอรี่ ผัดผักน้ำมันหอย 90 กิโลแคลอรี่ ขนมจีนน้ำยาปักษ์ใต้ 126 กิโลแคลอรี่ ขนมจีบหมู 30 กิโลแคลอรี่  ใน 1 วันร่างกายควรได้รับพลังงาน  ต่ำกว่า 1,000 กิโลแคลอรี่  รับประทานผักและผลไม้ เน้นโปรตีน และออกกำลังการยอย่างสม่ำเสมอ เช่น สลัดผักอกไก่ 110 กิโลแคลอรี่  ผักจิ้มน้ำพริก 50 กิโลแคลอรี่ ผัดผักน้ำมันหอย 90 กิโลแคลอรี่ ขนมจีนน้ำยาปักษ์ใต้ 126 กิโลแคลอรี่ ขนมจีบหมู 30 กิโลแคลอรี่";
        }
        else if(calbmi>=24.9 && calbmi<= 29.9) {
            ms = "อยู่ระหว่าง 25 -29.9 = อ้วน";
            suggestion = "ใน 1 วันร่างกายควรได้รับพลังงาน ต่ำกว่า 800 กิโลแคลอรี่ อาหารที่ควรรับประทาน คือ หลีกเลี่ยงแป้งและน้ำตาล เน้นผักผลไม้และเนื้อสัตว์ไม่ติดมัน เช่น ปลานึ่งมะนาว 80 กิโลแคลอรี่  อกไก่อบซอส 75 กิโลแคลอรี่ ขนมถั่วแปป 1ชิ้น 32กิโลแคลอรี่  ซุปหน่อไม้ 40 กิโลแคลอรี่ เป็นต้น ";
        }
        else if(calbmi>=29.9) {
            ms = "มากกว่า 30 = อ้วนมาก";
            suggestion = "ใน 1 วัน ร่างกาย ควรได้รับพลังงาน ต่ำกว่า 750 กิโลแคลอรี่ อาหารที่ควรรับประทาน คือ คือ หลีกเลี่ยงแป้งและน้ำตาล เน้นผักผลไม้และเนื้อสัตว์ไม่ติดมัน เช่น ผักจิ้มน้ำพริก 50 กิโลแคลอรี่ ผัดผักน้ำมันหอย 90 กิโลแคลอรี่  ซุปผัก(ใส) 50 กิโลแคลอรี่ แก้วมังกร 60 กิโลแคลอรี่ แตงโม 75 กิโลแคลอรี่ เป็นต้น";
        }
        else {
            ms = "ไม่มีข้อมูล" ;
        }
        _bmi.setText(BMI);   //เอาตัวแปร BMI ที่มีข้อความอยู่ไปแสดง
        _ms.setText(ms);    //เอาข้อความ ที่ดูจากการคำนวณไปแสดง
        Button btnSug = (Button)  findViewById(R.id.button_sug); //ปุ่มเรียกดูคำแนะนำ
        btnSug.setOnClickListener(this);
        Button btnFood = (Button)  findViewById(R.id.button_food); //ปุ่มเรียกดูอาหาร
        btnFood.setOnClickListener(this);
        Button btnEx = (Button)  findViewById(R.id.button_ex); //ปุ่มเรียกดูออกกำลัง
        btnEx.setOnClickListener(this);
    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_sug: //เมื่อกดปุ่ม submit
                Intent intent = new Intent(bmi.this, Suggestion.class); //ไปคลาสต่อไป
                intent.putExtra("suggestion", suggestion); //ส่งค่า bmi ที่คำนวณได้ไปด้วย
                startActivity(intent);
                break;
            case R.id.button_food: //เมื่อกดปุ่ม submit
                Intent intent2 = new Intent(bmi.this, food.class); //ไปคลาสต่อไป
                startActivity(intent2);
                break;
            case R.id.button_ex: //เมื่อกดปุ่ม submit
                Intent intent3 = new Intent(bmi.this, Exercise.class); //ไปคลาสต่อไป
                startActivity(intent3);
                break;
        }
    }

}
