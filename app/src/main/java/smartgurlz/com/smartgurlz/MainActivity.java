package smartgurlz.com.smartgurlz;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends FragmentActivity {
    private static int TIME_OUT = 4000; //Time to launch the another activity


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
/*
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, .class);
                startActivity(i);
                finish();
            }
        }, TIME_OUT);*/
    }
}
