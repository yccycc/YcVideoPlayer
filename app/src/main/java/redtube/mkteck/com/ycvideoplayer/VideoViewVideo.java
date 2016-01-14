package redtube.mkteck.com.ycvideoplayer;
import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;
public class VideoViewVideo extends Activity{
    private final static String TAG="TestVideoPlayer";
    private VideoView mVideoView;
    private MediaController mediaController;
    private long startTimeMills;
    private String oriVideoUrl ="http://192.168.35.85:8080/Dss/sexy_love.3gp";

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.main);
        setTitle("hello yc");
        Toast.makeText(VideoViewVideo.this,"it is me!!!",Toast.LENGTH_SHORT).show();

        //初始化VideoView
        mediaController=new MediaController(this);
        mVideoView = (VideoView) findViewById(R.id.surface_view);

        long setctrl = System.currentTimeMillis();
        mVideoView.setMediaController(mediaController);
        Log.e("duration_setctrl:", System.currentTimeMillis()-setctrl + "");

        long setpre = System.currentTimeMillis();
        mVideoView.setOnPreparedListener(mOnPreparedListener);
        Log.e("duration_setpre:", System.currentTimeMillis() - setpre + "");

        long setpath = System.currentTimeMillis();
        mVideoView.setVideoPath(oriVideoUrl);
        Log.e("duration_setpath:", System.currentTimeMillis() - setpath + "");

        startTimeMills = System.currentTimeMillis();
    }

    @Override
    public void onStop(){
        super.onStop();
        finish();
        System.exit(0);
    }

    private OnPreparedListener mOnPreparedListener=new OnPreparedListener(){

        @Override
        public void onPrepared(MediaPlayer mp) {
            long duration1=System.currentTimeMillis() - startTimeMills;
            Log.e("duration1:", duration1+"");
            mVideoView.start();
            long duration=System.currentTimeMillis() - startTimeMills;
            Log.e("duration:", duration+"");
        }
    };
}