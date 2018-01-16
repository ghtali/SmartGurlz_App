package smartgurlz.com.smartgurlz;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HovedActivity extends FragmentActivity {

    private static int TIME_OUT = 4000; //Time to launch the another activity
    private DatabaseReference mDatabase;
    private FirebaseDatabase mFirebaseInstance;
    private static final String TAG = HovedActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Lunching MainMenu class

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(HovedActivity.this, MainMenu.class);
                startActivity(i);
                finish();
            }
        }, TIME_OUT);

    }
}