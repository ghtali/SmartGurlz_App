package smartgurlz.com.smartgurlz.control;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import smartgurlz.com.smartgurlz.R;

public class FirebaseHandler extends AppCompatActivity {

    private static final String TAG = FirebaseHandler.class.getSimpleName();
    private TextView goldPlayerPoints;
    private TextView silverPlayerPoints;
    private TextView bronzePlayerPoints;
    private DatabaseReference mDatabase;
    private FirebaseDatabase mFirebaseInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

/*        // Displaying toolbar icon
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);*/

        goldPlayerPoints = findViewById(R.id.goldPlayerPoints);
        silverPlayerPoints = findViewById(R.id.silverPlayerPoints);
        bronzePlayerPoints = findViewById(R.id.bronzePlayerPoints);


        // get reference to 'Levels' node
        mDatabase = FirebaseDatabase.getInstance().getReference();
        //mDatabase.child("Levels");

 /*       // store app title to 'app_title' node
        mFirebaseInstance.getReference("app_title").setValue("Realtime Database");*/

        ValueEventListener scoreListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get ScoreControl object and use the values to update the UI
                ScoreControl scores = dataSnapshot.getValue(ScoreControl.class);

                Log.d(String.valueOf(scores), "Levels are " + scores.gold);

                // ...
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting ScoreControl failed, log a message
                Log.w(TAG, "levels:onCancelled", databaseError.toException());
                // ...
            }
        };
        mDatabase.addValueEventListener(scoreListener);
    }

}