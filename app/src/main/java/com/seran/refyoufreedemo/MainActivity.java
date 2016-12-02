package com.seran.refyoufreedemo;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MediaPlayer sound2, sound3, sound1;
    boolean callEnabled = false;
    boolean[] levels;
    int i = 0;
    int n=1,m=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//Music part





        final StringBuilder s = new StringBuilder(16);
        levels = new boolean[4];
        for (int j = 0; j < levels.length; j++) {
            levels[j] = false;
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
                            play(v);
                            levels[i] = true;
                        }
                        if (s.length() == 12 && callEnabled == true && q.charAt(q.length() - 1) == '2' && levels[i] == true)
                        {
                            i++;
                            Toast.makeText(MainActivity.this, "level 2", Toast.LENGTH_SHORT).show();
                            play(v);
                            cups(v);
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
    public void play(View v)
    {
        switch (n) {
            case(1):
                sound1 = MediaPlayer.create(this, R.raw.one);
                sound1.start();
                n=2;
                m=2;
                break;


            case (2):
                if (sound1!=null)
                    sound1.pause();
                if(sound2!=null)
                    sound2.pause();
                n=1;
                m=1;
                break;

            default: break;
        }
    }
    public void cups(View v)
    {

        switch(m) {
            case 1:
                sound2 = MediaPlayer.create(this, R.raw.two);
                sound2.start();
                m=2;
                n=2;
                break;


            case 2:
                if(sound1!=null)
                    sound1.pause();
                if (sound2!=null)
                    sound2.pause();
                n=1;
                m=1;
                break;

        }
    }

}

//1. language 2. News, Info about countries, Application process 3. Info about Canada
