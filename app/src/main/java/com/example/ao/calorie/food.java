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

public class food extends AppCompatActivity {

    String[] arr = {"กระเพาะปลา","กระเพาะปลาตุ๋นน้ำแดง","กล้วยไข่","กล้วยคลุกมะพร้าว","กล้วยฉาบ","กล้วยตาก","กล้วยทอด (กล้วยแขก)","กล้วยน้ำว้า","กล้วยบวชชี","กล้วยหอม","ก๊วยจั๊บ",
            "แกงกะหรี่ไก่","แกงกะหรี่หมู","แกงขี้เหล็ก","แกงเขียวหวาน","แกงจืด","ข้าวปุ้น(ส้มตำ-ขนมจีน)","ข้าวผัดกระเพราหมูกรอบ",
            "ข้าวผัดกะเพรากุ้ง","ข้าวผัดกะเพราไก่ไข่ดาว","ข้าวผัดกะเพราหมู","ข้าวผัดกุ้งใส่ไข่","ข้าวผัดคะน้าหมูกรอบ","ข้าวผัดรวมมิตร","ข้าวผัดหมูใส่ไข่",
            "ข้าวผัดอเมริกัน","ข้าวพะแนงเนื้อ","ข้าวโพดต้ม","ข้าวมันไก่","ข้าวยำปักษ์ใต้","ข้าวราดแกงเขียวหวานไก่","ข้าวราดผัดผักใส่หมู","ข้าวหน้าเป็ด","ก๋วยเตี๋ยวเส้นเล็กหมู", "ก๋วยเตี๋ยวผัดไทยใส่ไข่", "ก๋วยเตี๋ยวราดหน้าหมู", "ก๋วยเตี๋ยวผัดซีอิ๋วใส่ไข่", "เส้นใหญ่เย็นตาโฟ", "เส้นหมี่ลูกชิ้นเนื้อ"
            , "เส้นหมี่เนื้อเปื่อยน้ำ", "ก๋วยเตี๋ยวหลอด", "บะหมี่ต้มยำ", "ก๋วยจั๊บน้ำข้น", "ก๋วยจั๊บน้ำใส", "ผัดมักกะโรนี", "ข้าวยำปักษ์ใต้", "โจ๊กหมู", "ข้าวต้มกุ้ง"
            , "ข้าวขาหมู", "ข้าวราดหน้ากระเพราไก่", "ข้าวหมกไก่", "ข้าวไข่เจียวหมูสับ", "ข้าวหมูแดง", "ข้าวผัดหมูใส่ไข่", "ข้าวมันไก่", "ข้าวคะน้าหมูกรอบ", "ข้าวคลุกกะปิ", "หอยแมลงภู่ทอดใส่ไข่"
            , "ขนมผักกาดใส่ไข่"};


    int[] arr2 = {150,225,40,100,29,30,50,36,152,77,240,450,325,195,240,120,180,650,540,630,580,595,670,210,557,790,457,200,596,248,483,370,495,421, 578, 397, 679, 352, 258, 298, 266, 310, 279, 259, 514, 248, 253, 350, 438, 478, 535, 500, 537, 557, 596, 620, 614, 428, 582};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_food);
        TableLayout tlb = (TableLayout)findViewById(R.id.tlb);
        for (int i = 0; i < arr.length; i++) {
            TableRow tRow = new TableRow(this);
            TextView txt = new TextView(this);
            txt.setText(arr[i] + "   " + arr2[i] + " กิโลแคลอรี่");
            txt.setTextSize(15);
            tRow.addView(txt);
            tlb.addView(tRow);
        }
    }
}

