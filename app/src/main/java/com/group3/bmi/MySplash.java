package com.group3.bmi;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

public class MySplash extends AppCompatActivity {
    private Thread mSplashThread;
    private MediaPlayer mp;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);


        mp = MediaPlayer.create(MySplash.this, R.raw.a);
        AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 100, 0);


        new Handler().postDelayed(new Runnable() {

				@Override
				public void run() {

					Intent i = new Intent(MySplash.this, MainActivity.class);
					startActivity(i);
					finish();
                    mp.start();
				}
			}, 3000);

    }
}