package com.example.ao.calorie;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {

    TextView txtView1;
    String[] arr = {"ก๋วยเตี๋ยวเส้นเล็กหมู", "ก๋วยเตี๋ยวผัดไทยใส่ไข่", "ก๋วยเตี๋ยวราดหน้าหมู", "ก๋วยเตี๋ยวผัดซีอิ๋วใส่ไข่", "เส้นใหญ่เย็นตาโฟ", "เส้นหมี่ลูกชิ้นเนื้อ"
            , "เส้นหมี่เนื้อเปื่อยน้ำ", "ก๋วยเตี๋ยวหลอด", "บะหมี่ต้มยำ", "ก๋วยจั๊บน้ำข้น", "ก๋วยจั๊บน้ำใส", "ผัดมักกะโรนี", "ข้าวยำปักษ์ใต้", "โจ๊กหมู", "ข้าวต้มกุ้ง"
            , "ข้าวขาหมู", "ข้าวราดหน้ากระเพราไก่", "ข้าวหมกไก่", "ข้าวไข่เจียวหมูสับ", "ข้าวหมูแดง", "ข้าวผัดหมูใส่ไข่", "ข้าวมันไก่", "ข้าวคะน้าหมูกรอบ", "ข้าวคลุกกะปิ", "หอยแมลงภู่ทอดใส่ไข่"
            , "ขนมผักกาดใส่ไข่"}; //รายการอาหาร
    int[] arr2 = {421, 578, 397, 679, 352, 258, 298, 266, 310, 279, 259, 514, 248, 253, 350, 438, 478, 535, 500, 537, 557, 596, 620, 614, 428, 582}; //แคลอรี่ของอาหาร
    int sum = 0, sum2 = 0, testa;
    String _name ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.content_main2);


        Spinner spin = (Spinner) findViewById(R.id.spinner1);
        spin.setOnItemSelectedListener(this);

        ArrayAdapter<String> arrAd = new ArrayAdapter<String>(Main2Activity.this,
                android.R.layout.simple_spinner_item,
                arr);

        arrAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spin.setAdapter(arrAd); //ทำการสร้างรายการอาหารขึ้นมา



    }

    public void onItemSelected(AdapterView<?> parent, View v, int position,
                               long id) {
        sum2 = arr2[position]; //เมื่อเลือกอาหารแล้ว ให้เก็บค่า แคลอรีของอาหาร ไว้ที่ sum2
        final EditText testder = (EditText) findViewById(R.id.editText); //กรอกจำนวนหน่วยของอาหาร
        Button testadd = (Button) findViewById(R.id.addfood);//สร้างปุ่ม ยืนยัน
        View.OnClickListener testda = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    testa = Integer.parseInt(testder.getText().toString());
                } catch (NumberFormatException e) {
                    testa = 1;
                }
                Toast toast = Toast.makeText ( Main2Activity.this, "เพิ่มรายการอาหารแล้ว", Toast.LENGTH_LONG );
                toast.show ( );
                sum=(sum2*testa)+sum; //เมื่อทำการกดปุ่ม "เพิ่มอาหารที่รับประทาน" ให้นำค่า sum2 มาคูณด้วย จำนวนหน่วยของอาหาร แล้วนำมารวมกัน
                testder.setText("0");
            }
        };
        testadd.setOnClickListener(testda);
        Button submit = (Button) findViewById(R.id.button2); //สร้างปุ่มยืนยันเพื่อไปยังหน้าต่อไป
        View.OnClickListener _submit = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _name = getIntent().getExtras().getString("NAME");
                int BMR = getIntent().getExtras().getInt("BMR");    //รับค่าจากหน้าแรกที่ส่งมา
                String BMI = getIntent().getExtras().getString("BMI"); //รับค่าจากหน้าแรกที่ส่งมา
                String BMR2=String.format("%d", BMR);   //แปลงค่าเป็นข้อความ
                String sum2=String.format("%d",sum); //แปลงค่าผลรวมที่กินเป็นข้อความ
                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                intent.putExtra("sum", sum2);
                intent.putExtra("BMR", BMR2);
                intent.putExtra("BMI", BMI); //ส่งค่าทั้ง 3 ไปหน้าต่อไป
                intent.putExtra("NAME", _name);
                startActivity(intent);
            }
        };
        submit.setOnClickListener(_submit);


    }

    public void onNothingSelected(AdapterView<?> parent) {
        txtView1.setText("");
    }
}
