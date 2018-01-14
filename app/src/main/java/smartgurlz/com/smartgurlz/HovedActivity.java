package smartgurlz.com.smartgurlz;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import smartgurlz.com.smartgurlz.control.FirebaseHandler;
import smartgurlz.com.smartgurlz.control.Score;

public class HovedActivity extends FragmentActivity {
    private static int TIME_OUT = 4000; //Time to launch the another activity
    private DatabaseReference mDatabase;
    private static final String TAG = FirebaseHandler.class.getSimpleName();
    public final List<Score> scores = new ArrayList<>();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(HovedActivity.this, MainMenu.class);
                startActivity(i);
                finish();
            }
        }, TIME_OUT);


        mDatabase = FirebaseDatabase.getInstance().getReference().child("Levels").child("Score");


        ValueEventListener scoreListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Score object and use the values to update the UI
                //Score score = dataSnapshot.getValue(Score.class);
                //Score score = dataSnapshot.getValue(Score.class);

                Log.d("Data øøøøøøøøøøø", dataSnapshot.toString()); //retrieve all data
                //Log.d("Data", scores.getBronze() + " " + scores.getGold());
                // Log.d("Data", dataSnapshot.child("Bronze").toString()); //retrieve specific value of a child
/*
                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) { // az inja
                    //getting
                    Score score = postSnapshot.getValue(Score.class);
                    //adding
                    scores.add(score);*/

                Log.d("Hello", "Hello");

                for (DataSnapshot ds : dataSnapshot.getChildren()){
                        Score bronze = ds.child("Bronze").getValue(Score.class);
                        Score gold = ds.child("Gold").getValue(Score.class);
                        Score silver = ds.child("Silver").getValue(Score.class);
                        Score highScore = ds.child("HighScore").getValue(Score.class);
                        Log.d("Bye", "Bye");

                    }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Score failed, log a message
                Log.w(TAG, "levels:onCancelled", databaseError.toException());
                // ...
            }
        };
        mDatabase.addValueEventListener(scoreListener);




        }
    }