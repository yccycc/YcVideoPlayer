package redtube.mkteck.com.ycvideoplayer;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

public class NetVideo extends AppCompatActivity implements MediaPlayer.OnPreparedListener
{
    private SurfaceView mSurfaceView;
    private SurfaceHolder mSurfaceHolder;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSurfaceView = (SurfaceView) findViewById(R.id.sf);
        mSurfaceHolder = mSurfaceView.getHolder();
        mSurfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                //mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.sexy_love);
                mediaPlayer = new MediaPlayer();
                mediaPlayer.setOnPreparedListener(NetVideo.this);
                try {
                    mediaPlayer.reset();
                    // 设置声音效果
                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    mediaPlayer.setDataSource(NetVideo.this,
                            Uri.parse("http://10.0.3.2:8080/Dss/sexy_love.3gp"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mediaPlayer.setDisplay(mSurfaceHolder);
                mediaPlayer.prepareAsync();
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                mediaPlayer.release();
            }
        });
    }

    @Override
    public void onPrepared(MediaPlayer mp)
    {
        Log.i("bitch", "onPrepared");
        mediaPlayer.start();
    }
}
