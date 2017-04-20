package com.example.anuhachera.myapplication;

/**
 * Created by anuhachera on 12/03/2016.
 */

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
    TextView text1;
    EditText edit1,edit2;
    Button button1,button2;

    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1=(Button)findViewById(R.id.button);
        edit1=(EditText)findViewById(R.id.editText);
        edit2=(EditText)findViewById(R.id.editText2);

        button2=(Button)findViewById(R.id.button2);
        text1.setVisibility(View.GONE);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edit1.getText().toString().equals("UserName") &&

                        edit2.getText().toString().equals("UserPassword")) {
                    Toast.makeText(getApplicationContext(), "Loading...", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Error! Try Again",Toast.LENGTH_SHORT).show();

                    text1.setVisibility(View.VISIBLE);
                    text1.setBackgroundColor(Color.RED);
                    counter--;
                    text1.setText(Integer.toString(counter));

                    if (counter == 0) {
                        button1.setEnabled(false);
                    }
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}
