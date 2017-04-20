package com.example.anuhachera.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by anuhachera on 04/01/2016.
 */

public class Hide_Seek extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hide__seek);

        Button hide = (Button) (findViewById(R.id.hide));
        hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Go2HideAct = new Intent(Hide_Seek.this, HideActivity.class);
                startActivity(Go2HideAct);

            }
        });

        Button seek = (Button) (findViewById(R.id.seek));
        seek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Go2seekAct = new Intent(Hide_Seek.this, SeekActivity.class);
                startActivity(Go2seekAct);

            }

        });

    }
}
