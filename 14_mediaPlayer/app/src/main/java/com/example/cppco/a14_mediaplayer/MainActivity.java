package com.example.cppco.a14_mediaplayer;

import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp = null;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String path = Environment.getExternalStorageDirectory() + "/Download";
        File dir = new File(path);
        File[] files = dir.listFiles();

        seekBar = (SeekBar) findViewById(R.id.playSeekBar);

    }

    public void onPlayClick (View v) {
        mp = new MediaPlayer();

        String path = Environment.getExternalStorageDirectory() + "/Samsung/Music/Over the Horizon.mp3";
        try {
            mp.setDataSource(path);
            mp.prepare();
            mp.start();
            seekBar.getMax(mp.getDuration());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (mp != null) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        seekBar.setProgress(mp.getCurrentPosition());
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onStopClick (View v) {
        if (mp != null) {
            mp.stop();
            mp.release();
        }
    }
}


























