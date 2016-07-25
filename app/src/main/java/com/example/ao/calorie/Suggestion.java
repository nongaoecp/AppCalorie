package com.example.ao.calorie;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Suggestion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_suggestion);

        String suggestion = getIntent().getExtras().getString("suggestion");
        TextView sug = (TextView) findViewById(R.id.text_sug);
        sug.setText(suggestion);


    }

}
