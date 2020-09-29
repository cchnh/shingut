package com.example.shingut;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import com.example.shingut.R;

public class MainActivity extends AppCompatActivity {
    private String TAG = "VideoActivity";
    private VideoView mVideoview;
    Button b1, b2,b3,b4;
    View.OnClickListener cl;
    Intent i,i1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch ( v.getId() ) {
                    case R.id.button1 :
                        i = new Intent(getApplicationContext(), tool_bar.class);
                        startActivity(i);
                        break;
                    case R.id.button2 :
                        i = new Intent(getApplicationContext(), guide.class);
                        startActivity(i);
                        break;
                    case R.id.button3 :
                        i = new Intent(getApplicationContext(), event.class);
                        startActivity(i);
                        break;
                    case R.id.button4 :
                        i = new Intent(getApplicationContext(), map.class);
                        startActivity(i);
                        break;
                }
            }
        };
        b1.setOnClickListener(cl);
        b2.setOnClickListener(cl);
        b3.setOnClickListener(cl);
        b4.setOnClickListener(cl);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mVideoview = (VideoView) findViewById(R.id.videoview);
        //play video
        mVideoview.setVideoURI( Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video));
        mVideoview.start();
        //loop
        mVideoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

    }
}