package smartgurlz.com.smartgurlz.menufragments;



import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Size;
import smartgurlz.com.smartgurlz.R;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class FragmentThree extends Fragment {


    public FragmentThree() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_fragment_three, container, false);

        //Toast.makeText(getContext(), "Tap to start", Toast.LENGTH_SHORT).show();


        KonfettiView konfettiView = (KonfettiView) view.findViewById(R.id.confetti);
        konfettiView.bringToFront();



        konfettiView.build()
                .addColors(Color.YELLOW, Color.GREEN, Color.RED)
                .setDirection(0.0, 359.0)
                .setSpeed(1f, 5f)
                .setFadeOutEnabled(true)
                .setTimeToLive(2000L)
                .addShapes(nl.dionsegijn.konfetti.models.Shape.CIRCLE, nl.dionsegijn.konfetti.models.Shape.RECT)
                .addSizes(new Size(12, 5f))
                .setPosition(1000f, konfettiView.getWidth() + 300f, -50f, -50f)
                .stream(150, 1500L);



        return view;
    }

}
