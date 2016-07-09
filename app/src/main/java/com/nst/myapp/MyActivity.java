package com.nst.myapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.VideoView;

public class MyActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.nst.myapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

//        VideoView video_view = (VideoView) findViewById(R.id.video_view);
//
////        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.splash);
//        Uri uri = Uri.parse("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4");
//
//        video_view.setVideoURI(uri);
//        video_view.start();

        String videoUrl = "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";
        VideoView videoView = (VideoView) findViewById(R.id.video_view);
        //Use a media controller so that you can scroll the video contents
        //and also to pause, start the video.
        MediaController mediaController = new MediaController(this);
//        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(Uri.parse(videoUrl));
        videoView.start();
    }

    public void sendMessage(View view) {
        //Yeah
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
