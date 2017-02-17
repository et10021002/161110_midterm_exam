package tw.com.a4040e009.a161110_midterm_exam;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.io.IOException;

public class LoadingActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        findBackgroundMusic();
        setDelayTime();
    }

    private void setDelayTime(){
        text = (TextView) findViewById(R.id.loadingtext);
        new CountDownTimer(5000,1000){
            @Override
            public void onTick(long millisUntilFinished) {
                text.setText("載入中...請等待" + millisUntilFinished/1000 + "秒");
            }
            @Override
            public void onFinish() {
                startActivity(new Intent().setClass(LoadingActivity.this,MainActivity.class));
            }
        }.start();
    }

    private void findBackgroundMusic(){
        try {
            mediaPlayer = MediaPlayer.create(this,R.raw.media01);
            if(mediaPlayer!=null){
                mediaPlayer.stop();
            }
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setLooping(true);
            mediaPlayer.prepare();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (IllegalStateException e){
            e.printStackTrace();
        }
    }
    @Override
    protected void onResume(){
        super.onResume();
        mediaPlayer.start();
    }
    @Override
    protected void onPause(){
        super.onPause();
        mediaPlayer.pause();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        mediaPlayer.release();
    }

}