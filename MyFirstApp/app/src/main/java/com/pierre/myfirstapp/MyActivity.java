package com.pierre.myfirstapp;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.VideoView;
import android.view.Window;
import android.view.WindowManager;

public class MyActivity extends AppCompatActivity {

    MediaPlayer myMovie;
    VideoView vv;

    private MediaPlayer mediaPlayer;
    private String videoPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.video_layout);

        vv = (VideoView)findViewById(R.id.videoView);
        vv.setKeepScreenOn(true);

        try {
            vv.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.movietl480360));
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

//        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
//        PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK, "My Tag");
//        wl.acquire();

        vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            @Override
            public void onPrepared(MediaPlayer mp) {
//                Log.i("info", "STARTING");
                mp.setLooping(true);
                vv.start();
            }
        });

//            vv.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
//                @Override
//                public void onCompletion(MediaPlayer mp){
//                    Log.i("info", "RESTARTING");
//
//                    vv.seekTo(0);
//                    vv.start();
//                }
//            });
    }

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
