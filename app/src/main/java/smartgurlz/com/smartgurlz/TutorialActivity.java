package smartgurlz.com.smartgurlz;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

/**@author Mads & Abdi 17-01-18
 * A simple {@link AppCompatActivity} subclass.
 *
 */
public class TutorialActivity extends AppCompatActivity {

    Button btnskip;
    VideoView videov;
    MediaController mediaController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_tutorial );

//                    // Video for tutorial
        videov = findViewById( R.id.videoView );
        btnskip = findViewById( R.id.btnskip );
        btnskip.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(TutorialActivity.this, UnityPlayerActivity.class);
                startActivity(i);
            }
        } );

        mediaController = new MediaController(this  );

        String videoPath = "android.resource://smartgurlz.com.smartgurlz/"+R.raw.movietutorial;

        getWindow().setFormat( PixelFormat.UNKNOWN);

        Uri uri = Uri.parse(videoPath);

        videov.setVideoURI(uri);
        videov.setMediaController( mediaController );
        mediaController.setAnchorView( videov );
        videov.start();
        videov.setOnCompletionListener( new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Intent i = new Intent(TutorialActivity.this, UnityPlayerActivity.class);
                startActivity(i);

            }
        } );
    }


    }

