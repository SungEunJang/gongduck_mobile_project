package com.example.gongduck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class EmergencyInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_info);

        ImageView hot=findViewById(R.id.e_hot);
        hot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDialog customDialog = new CustomDialog(EmergencyInfo.this);
                customDialog.callFunction("폭염");
            }
        });

        ImageView cold=findViewById(R.id.e_cold);
        cold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDialog customDialog = new CustomDialog(EmergencyInfo.this);
                customDialog.callFunction("한파");
            }
        });

        ImageView fire=findViewById(R.id.e_fire);
        fire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDialog customDialog = new CustomDialog(EmergencyInfo.this);
                customDialog.callFunction("화재");
            }
        });

        ImageView earth=findViewById(R.id.e_earthq);
        earth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDialog customDialog = new CustomDialog(EmergencyInfo.this);
                customDialog.callFunction("지진");
            }
        });


    }
}
