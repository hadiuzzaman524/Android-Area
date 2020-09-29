package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton play,pause;
    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play=findViewById(R.id.playbuttonid);
        pause=findViewById(R.id.pausebuttonid);

        mediaPlayer=MediaPlayer.create(this,R.raw.xxx);

         play.setOnClickListener(this);
         pause.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {


        if (v.getId()==R.id.playbuttonid)
        {
            mediaPlayer.start();
        }
        else if(v.getId()==R.id.pausebuttonid)
        {
            mediaPlayer.pause();
        }
    }

    @Override
    protected void onDestroy() {

        if (mediaPlayer!=null&&mediaPlayer.isPlaying())
        {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer=null;
        }
        super.onDestroy();
    }
}

