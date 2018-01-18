package smartgurlz.com.smartgurlz;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

//import com.SmartGurlz.app.UnityPlayerActivity;



public class WelcomeActivity extends FragmentActivity {


    public Button btnNext12;
    private Button btnPlay;
    private PrefManager prefManager;
    private int clickcount=0;
    public TextView textBubble;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstanceState);

        // Checking for first time launch - before calling setContentView()
        prefManager = new PrefManager(this);
        if (!prefManager.isFirstTimeLaunch()) {
            launchHomeScreen();
            finish();
        }

        // Making notification bar transparent
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        setContentView(R.layout.activity_welcome);

        btnNext12 = (Button) findViewById(R.id.btnNext12);
        btnPlay = (Button) findViewById(R.id.btnPlay);
        textBubble = (TextView) findViewById(R.id.textBubble);


        if (clickcount == 0) {
            textBubble.setText("Hi, I’m Emma.\n I love to paint!");

        }



        btnNext12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // checking for last page
                // if last page home screen will be launched
                if (v == btnNext12) {
                    clickcount = clickcount + 1;
                    showMessages();
                }
            }
        });


        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == btnPlay) {

                    Toast.makeText(WelcomeActivity.this, "Hello Test", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(WelcomeActivity.this, TutorialActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        });

    }

    private void showMessages() {
        if (clickcount == 1){
            textBubble.setText("But I’m all out of art supplies...");
        }else if(clickcount == 2){
            textBubble.setText("Will you help me get to the store?");
        }else if (clickcount >= 3) {
                textBubble.setText("Great! Let’s get started");
            btnNext12.setVisibility(View.INVISIBLE);
            btnPlay.setVisibility(View.VISIBLE);
        }
    }


    private void launchHomeScreen() {
        prefManager.setFirstTimeLaunch(true); //Setting to the true just for test (it should be false)
        startActivity(new Intent(WelcomeActivity.this, HovedActivity.class));
        finish();
    }

}