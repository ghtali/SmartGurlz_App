package smartgurlz.com.smartgurlz;

import android.graphics.Color;
import android.graphics.drawable.shapes.Shape;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Size;

public class HighscoreFragment extends Fragment {

    private EditText textViewPlayer1;
    private EditText textViewPlayer2;
    private EditText textViewPlayer3;
    private EditText textViewPlayer4;
    private EditText textViewPlayer5;

    private EditText textViewPlayerPoints1;
    private EditText textViewPlayerPoints2;
    private EditText textViewPlayerPoints3;
    private EditText textViewPlayerPoints4;
    private EditText textViewPlayerPoints5;

    public HighscoreFragment() {
        // Required empty public constructor
    }

    KonfettiView confettiView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_fragment_three, container, false);


        Toast.makeText(getContext(), "Tap to start", Toast.LENGTH_SHORT).show();


        KonfettiView konfettiView = (KonfettiView) view.findViewById(R.id.confetti);



        konfettiView.build()
                .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
                .setDirection(0.0, 359.0)
                .setSpeed(1f, 5f)
                .setFadeOutEnabled(true)
                .setTimeToLive(2000L)
                .addShapes(nl.dionsegijn.konfetti.models.Shape.CIRCLE, nl.dionsegijn.konfetti.models.Shape.RECT)
                .addSizes(new Size(12, 5f))
                .setPosition(-50f, konfettiView.getWidth() + 50f, -50f, -50f)
                .stream(300, 5000L);
/*

        konfettiView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                konfettiView.build()
                        .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
                        .setDirection(0.0, 359.0)
                        .setSpeed(1f, 5f)
                        .setFadeOutEnabled(true)
                        .setTimeToLive(2000L)
                        .addShapes(nl.dionsegijn.konfetti.models.Shape.CIRCLE, nl.dionsegijn.konfetti.models.Shape.RECT)
                        .addSizes(new Size(12, 5f))
                        .setPosition(-50f, konfettiView.getWidth() + 50f, -50f, -50f)
                        .stream(300, 5000L);
            }
        });

        */
        return view;
    }
}


