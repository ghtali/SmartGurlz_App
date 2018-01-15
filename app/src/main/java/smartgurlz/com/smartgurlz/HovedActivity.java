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
    //public final List<Score> scores = new ArrayList<>();


/*    public static final String ARTIST_NAME = "net.simplifiedcoding.firebasedatabaseexample.artistname";
    public static final String ARTIST_ID = "net.simplifiedcoding.firebasedatabaseexample.artistid";*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        super.onCreate(savedInstanceState);


        //Lunching MainMenu class

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(HovedActivity.this, MainMenu.class);
                startActivity(i);
                finish();
            }
        }, TIME_OUT);


        /*
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Levels").child("Score");
        Log.d("Data øøøøøøøøøøø", mDatabase + " og "); //retrieve all data


        ValueEventListener scoreListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("Data øøøøøøøøøøø", mDatabase + " og " + dataSnapshot.toString()); //retrieve all data
                // Get Score object and use the values to update the UI
                Score score = dataSnapshot.getValue(Score.class);
                //Score score = dataSnapshot.getValue(Score.class);

                //Log.d("Data", scores.getBronze() + " " + scores.getGold());
                // Log.d("Data", dataSnapshot.child("Bronze").toString()); //retrieve specific value of a child

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Score failed, log a message
                Log.w(TAG, "levels:onCancelled", databaseError.toException());
                // ...
            }
        };
        mDatabase.addValueEventListener(scoreListener);

        */
    }
}