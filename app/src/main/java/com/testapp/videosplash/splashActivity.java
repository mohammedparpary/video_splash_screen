package com.testapp.videosplash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.VideoView;

public class splashActivity extends AppCompatActivity {
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        videoView = (VideoView) findViewById(R.id.splash_video);
        String videoPath = new StringBuilder("android.resource://")
                .append(getPackageName())
                .append("/raw/jumira_splash")
                .toString();
        videoView.setVideoPath(videoPath);
        //event
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(splashActivity.this,MainActivity.class));
                        finish();
                    }
                },5000); // Wait 5000 milliseconds before start new activity
            }
        });
        videoView.start();
    }
}