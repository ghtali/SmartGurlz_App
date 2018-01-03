package smartgurlz.com.smartgurlz;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_highscore, container, false);
        return inflater.inflate(R.layout.fragment_highscore, container, false);
    }

}
