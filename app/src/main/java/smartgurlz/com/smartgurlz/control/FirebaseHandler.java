package smartgurlz.com.smartgurlz.control;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class FirebaseHandler extends AppCompatActivity {

    private static final String TAG = FirebaseHandler.class.getSimpleName();
    private DatabaseReference mDatabase;
    private FirebaseDatabase mFirebaseInstance;

    //   public final List<Score> scores = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/*

        // get reference to 'Levels' node
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Levels").child("Score");


        Log.d("Hello", "Bye");

       ValueEventListener scoreListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Score object and use the values to update the UI
                //Score score = dataSnapshot.getValue(Score.class);
                //Score score = dataSnapshot.getValue(Score.class);

                Log.d("Data øøøøøøøøøøø", dataSnapshot.toString()); //retrieve all data
                //Log.d("Data", scores.getBronze() + " " + scores.getGold());
                // Log.d("Data", dataSnapshot.child("Bronze").toString()); //retrieve specific value of a child

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) { // az inja
                    //getting
                    Score score = postSnapshot.getValue(Score.class);
                    //adding
                    scores.add(score);

                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Score failed, log a message
                Log.w(TAG, "levels:onCancelled", databaseError.toException());
                // ...
            }
        };
        mDatabase.addValueEventListener(scoreListener);*/



    }

}