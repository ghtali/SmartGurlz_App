package smartgurlz.com.smartgurlz.control;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import smartgurlz.com.smartgurlz.R;

public class FirebaseHandler {

    private static final String TAG = FirebaseHandler.class.getSimpleName();
    private FirebaseDatabase mFirebaseInstance;
    public static Score score;

    void onStart() {

    }

    public static void hentScores(Runnable runnable, final View view) {
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("Levels").child("Score");
        final Runnable r = runnable;


        final TextView bronzePlayerPoints;
        final TextView silverPlayerPoints;
        final TextView goldPlayerPoints;

        bronzePlayerPoints = (TextView) view.findViewById(R.id.bronzePlayerPoints);
        silverPlayerPoints = (TextView) view.findViewById(R.id.silverPlayerPoints);
        goldPlayerPoints = (TextView) view.findViewById(R.id.goldPlayerPoints);


        ValueEventListener scoreListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                Log.d("Data øøøøøøøøøøø", dataSnapshot.toString()); //retrieve all data
                // Get Score object and use the values to update the UI
                score = dataSnapshot.getValue(Score.class);
                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {


                    if (childSnapshot.getKey().equalsIgnoreCase("Bronze")) {
                        bronzePlayerPoints.setText(childSnapshot.getValue().toString());
                    }
                    if (childSnapshot.getKey().equalsIgnoreCase("Silver")) {
                        silverPlayerPoints.setText(childSnapshot.getValue().toString());
                    }
                    if (childSnapshot.getKey().equalsIgnoreCase("Gold")) {
                        goldPlayerPoints.setText(childSnapshot.getValue().toString());
                    }


                    System.out.println(childSnapshot.getValue());
                    //System.out.println("long: "+ l);
                }
                r.run();


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