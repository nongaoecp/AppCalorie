package com.example.ao.calorie;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Database extends AppCompatActivity {

    private SQLiteDatabase db;
    private Cursor c;
    int id;
    private ArrayAdapter adapter;
    String sql;

    // data
    String calbmi,sum,BMR;
    String date_time;
    String _name ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_list);

        // Database
        db = this.openOrCreateDatabase("mydatabase",MODE_PRIVATE,null);
        sql = ""
                + " CREATE TABLE IF NOT EXISTS db_Test1("
                + "   id INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + "   date_time VARCHAR," + " calbmi VARCHAR," + " sum VARCHAR,"+ " _name VARCHAR,"
                + "   BMR VARCHAR" +" )";
        db.execSQL(sql);

        //เรียกมาจาก MainActivity
        int check  = getIntent().getExtras().getInt("check");   //รับค่าตรวจสอบจากหน้าก่อนหน้านี้
        if(check==1) {          //ถ้าส่ง 1 มาแสดงว่ามีการรับข้อมูล ถ้าไม่ใช่ 1 คือเรียกดูเฉยๆ
            calbmi = getIntent().getExtras().getString("BMI");
            _name = getIntent().getExtras().getString("NAME");
            sum = getIntent().getExtras().getString("sum");
            BMR = getIntent().getExtras().getString("BMR");
            date_time = getIntent().getExtras().getString("date_time");


            // เพิ่มข้อมูลลง database
            sql = "";
            sql = "INSERT INTO db_Test1 VALUES(null, ':date_time', ':calbmi',':_name', ':sum', ':BMR')";
            sql = sql.replace(":date_time", date_time);
            sql = sql.replace(":calbmi", calbmi);
            sql = sql.replace(":_name", _name);
            sql = sql.replace(":sum", sum);
            sql = sql.replace(":BMR", BMR);
            db.execSQL(sql);
        }
        //refresh listView
        bindData();

    }

    //-------------------------------------------------------------------------

    //refresh listView
    private void bindData(){
        sql = "";
        sql = "SELECT * FROM db_Test1";
        c = db.rawQuery(sql, null);

        int item = android.R.layout.simple_list_item_1;
        ArrayList data = new ArrayList();

        while(c.moveToNext()){
            int index = c.getColumnIndex("date_time"); //ต้องการส่วน date_time ใน dababase
            data.add(c.getString(index));
        }

        adapter = new ArrayAdapter(this, item, data);

        ListView myList = (ListView) findViewById(R.id.myList); //เรียก listView
        myList.setAdapter(adapter);
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> av, View v, int i, long l) {
                //เมื่อมีการคลิกรายชื่อใน listView
                itemClick(i);
            }
        });
    }
    //-------------------------------------------------------------------------

    //เมื่อมีการคลิกรายชื่อใน listView
    public void itemClick(int index){
        c.moveToPosition(index);
        id = c.getInt(c.getColumnIndex("id"));
        setContentView(R.layout.edit_list);   //ไปที่หน้า edit_list

        TextView date_time = (TextView)findViewById(R.id.date_time);
        TextView calbmi = (TextView)findViewById(R.id.calbmi);
        TextView sum = (TextView)findViewById(R.id._name);
        TextView bmr = (TextView)findViewById(R.id.bmr);
        TextView name = (TextView)findViewById(R.id.sum);
        date_time.setText(c.getString(c.getColumnIndex("date_time")));
        name.setText(c.getString(c.getColumnIndex("_name")));
        calbmi.setText(c.getString(c.getColumnIndex("calbmi")));
        sum.setText(c.getString(c.getColumnIndex("sum")));
        bmr.setText(c.getString(c.getColumnIndex("BMR")));
    }
    //-------------------------------------------------------------------------

    // edit_list
    //กดปุ่ม delete
    public void doDelete(View v){
        db.delete("db_Test1", "id = " + id, null);
        setContentView(R.layout.show_list);
        bindData();
    }
    //กดปุ่ม back
    public void doBack(View v){
        setContentView(R.layout.show_list);
        bindData();
    }
    //-------------------------------------------------------------------------

    //เมื่อกดปุ่ม home
    public void doHome(View v){
        Intent intent = new Intent(Database.this, MainActivity.class); //ไปหน้าแรก
        startActivity(intent);
    }

}

