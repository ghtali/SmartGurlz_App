package smartgurlz.com.smartgurlz;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Size;

/**@author Flemming & Ali
 *
 */

public class HighscoreFragment extends Fragment {



    public HighscoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_fragment_three, container, false);


        Toast.makeText(getContext(), "Tap to start", Toast.LENGTH_SHORT).show();


        KonfettiView konfettiView = view.findViewById(R.id.confetti);



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

        return view;
    }
}


