package com.seran.refyoufreedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean callEnabled = false;
    boolean[] levels;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final StringBuilder s = new StringBuilder(16);
        levels = new boolean[3];
        for (int i = 0; i < levels.length; i++) {
            levels[i] = false;
        }


        GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new ImageAdapter(this));

        final EditText editText = (EditText) findViewById(R.id.editText);

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
                            editText.setText(s);
                        }
                        String q = s.toString();
                        if (s.length() == 10 && callEnabled == true) {
                            Toast.makeText(MainActivity.this, "Call answered!" , Toast.LENGTH_SHORT).show();
                            levels[i] = true;
                        }
                        if (s.length() == 11 && callEnabled == true && q.charAt(q.length() - 1) == '1' && levels[i] == true)
                        {
                            i++;
                            Toast.makeText(MainActivity.this, "level 1", Toast.LENGTH_SHORT).show();
                            levels[i] = true;
                        }
                        if (s.length() == 12 && callEnabled == true && q.charAt(q.length() - 1) == '2' && levels[i] == true)
                        {
                            i++;
                            Toast.makeText(MainActivity.this, "level 2", Toast.LENGTH_SHORT).show();
                            levels[i] = true;
                        }
                        if (s.length() == 13 && callEnabled == true && q.charAt(q.length() - 1) == '3' && levels[i] == true)
                        {
                            i++;
                            Toast.makeText(MainActivity.this, "level 3", Toast.LENGTH_SHORT).show();
                            levels[i] = true;
                        }

                        break;
                }
            }
        });
    }
}

//1. language 2. News, Info about countries, Application process 3. Info about Canada
