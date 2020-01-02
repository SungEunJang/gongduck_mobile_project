package com.example.gongduck;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ReportActivity extends AppCompatActivity {

    Button disasterButton, mapoButton, gonduckButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        disasterButton = findViewById(R.id.disasterBtn);
        mapoButton = findViewById(R.id.mapoBtn);
        gonduckButton = findViewById(R.id.gongduckBtn);

        disasterButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:119"));
                startActivity(dIntent);
                //finish();
            }
        });

        mapoButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0231538100"));
                startActivity(mIntent);
                //finish();
            }
        });

        gonduckButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0232740976"));
                startActivity(dIntent);
                //finish();
            }
        });
    }


}