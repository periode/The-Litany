package com.pierre.myfirstapp;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.VideoView;

public class MyActivity extends AppCompatActivity {

    MediaPlayer myMovie;
    VideoView vv;

    private MediaPlayer mediaPlayer;
    private String videoPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        vv = (VideoView)findViewById(R.id.videoView);

        try {
            vv.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.movie));
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

        vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            @Override
            public void onPrepared(MediaPlayer mp) {
                Log.i("info", "STARTING");
//                mp.setLooping(true);
                vv.start();
            }
        });

        vv.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
            @Override
            public void onCompletion(MediaPlayer mp){
                Log.i("info", "RESTARTING");

                vv.seekTo(0);
                vv.start();
            }
        });
//        super.onCreate(savedInstanceState);
//
//        mediaPlayer = new MediaPlayer();
//        startMovie();

    }

//    private void startMovie(){
//        mediaPlayer = MediaPlayer.create(this, Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.movie));
////        mediaPlayer.stop();
////        mediaPlayer.reset();
////        mediaPlayer.setDataSource();
//
//        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mp) {
////                mp.setWakeMode(getApplicationContext(), PowerManager.PARTIAL_WAKE_LOCK);
//                mp.start();
//                mp.seekTo(0);
//            }
//        });
//
//        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            @Override
//            public void onCompletion(MediaPlayer mp) {
//                startMovie();
//            }
//        });
//
////        mediaPlayer.prepareAsync();
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
