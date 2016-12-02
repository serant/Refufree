package com.seran.refyoufreedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean callEnabled = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final StringBuilder s = new StringBuilder(16);


        GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new ImageAdapter(this));

        final TextView textView = (TextView) findViewById(R.id.textview);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                String[] text = {
                        "1",
                        "2",
                        "3",
                        "4",
                        "5",
                        "6",
                        "7",
                        "8",
                        "9",
                        "*",
                        "0",
                        "#"

                };
                switch (position) {
                    case 12:
                        callEnabled = true;
                        Toast.makeText(MainActivity.this, "call started", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        if (s.length() < 16) {
                            s.append(text[position]);
                            textView.setText(s);
                        }
                        break;
                }
            }
        });
    }
}