package smartgurlz.com.smartgurlz;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import com.SmartGurlz.app.UnityPlayerActivity;
/*@Author abdi ... 16-01-18
*
* */
/*@Author Mads ... 16-01-18
*
* */
public class TutorialActivity extends AppCompatActivity {

    Button btnskip;
    VideoView videov;
    MediaController mediaController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_tutorial );

//                    // Video for tutorial
        VideoView videov = ( VideoView ) findViewById( R.id.videoView );
        Button btnskip = ( Button ) findViewById( R.id.btnskip );
        btnskip.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(TutorialActivity.this, UnityPlayerActivity.class));
            }
        } );

        mediaController = new MediaController(this  );

        String videoPath = "android.resource://smartgurlz.com.smartgurlz/"+R.raw.tutorialvideofinished;

        getWindow().setFormat( PixelFormat.UNKNOWN);

        Uri uri = Uri.parse(videoPath);

        videov.setVideoURI(uri);
        videov.setMediaController( mediaController );
        mediaController.setAnchorView( videov );
        videov.start();
        videov.setOnCompletionListener( new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                startActivity(new Intent(TutorialActivity.this, UnityPlayerActivity.class));
            }
        } );
    }


    }
