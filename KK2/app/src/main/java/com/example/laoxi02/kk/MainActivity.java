package com.example.laoxi02.kk;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MediaPlayer sound = MediaPlayer.create(this, R.raw.misery);
        final MediaPlayer sound1 = MediaPlayer.create(this, R.raw.cups);
     Button play = (Button) this.findViewById(R.id.playCatMeow);


            play.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v)

                {
sound.start();
//                    if (sound.isPlaying()==false);
//                    {
//                         sound.start();
//                    }
//                    if((sound.isPlaying()==true) || (sound1.isPlaying()==true))
//                    {
//                         sound.stop();
//                        sound1.stop();
//                    }
                }

            });



        Button cups = (Button) this.findViewById(R.id.cups);


        cups.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                sound1.start();
//            if (sound1.isPlaying()==false)
//            {
//                sound1.start();
//            }
//            if((sound1.isPlaying()==true)|| (sound1.isPlaying()==true))
//            {
//                sound1.stop();
//                sound.stop();
//            }

            }

        });



    }
    }
