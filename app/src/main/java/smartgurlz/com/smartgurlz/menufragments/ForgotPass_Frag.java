package smartgurlz.com.smartgurlz.menufragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import smartgurlz.com.smartgurlz.R;

/**@author Ana-Maria & Mads 11-01-2018
 * A simple {@link Fragment} subclass.
 */
public class ForgotPass_Frag extends Fragment {

    private EditText forgot_edt;
    private TextView forgot_txt;
    private Button back_btn;
    private Button forgot_btn;
    private ConstraintLayout forgotPassword_layout;

    private FirebaseAuth auth;

    public ForgotPass_Frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_forgot_pass_, container, false);


        forgot_edt = (EditText) view.findViewById(R.id.forgotPassword_edt);
        forgot_btn = (Button) view.findViewById(R.id.forgot_btn);
        forgot_txt = (TextView) view.findViewById(R.id.forgotPassword_txt);
        back_btn = (Button) view.findViewById(R.id.back_btn);
        forgotPassword_layout = (ConstraintLayout) view.findViewById(R.id.forgotPassword_layout);

        auth = FirebaseAuth.getInstance();

        forgot_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            resetPassword(forgot_edt.getText().toString());
                forgot_edt.getText().clear();

            }

        });

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // startActivity(new Intent(getActivity(), FragmentTwo.class));
                FragmentTwo back = new FragmentTwo();

                FragmentTransaction fragmentTransaction2 = getFragmentManager().beginTransaction();
                fragmentTransaction2.replace(R.id.container, back , "FragmentName"); // fram is the id of FrameLayout in xml file()
                fragmentTransaction2.commit();
            }
        });

        return view;
        //return inflater.inflate(R.layout.fragment_forgot_pass_, container, false);
    }

private void resetPassword(final String email){
        auth.sendPasswordResetEmail(email)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getActivity(), "We have sent password to email" + email, Toast.LENGTH_LONG).show();
                           // Snackbar snackbar = Snackbar.make(forgotPassword_layout, "We have sent password to email: " + email, Snackbar.LENGTH_SHORT).show();
                             }
                             else {
                            Toast.makeText(getActivity(), "Failed", Toast.LENGTH_LONG).show();

                            //Snackbar snackbar = Snackbar.make(getActivity(), "Failed", Snackbar.LENGTH_SHORT).show();
                        }
                    }
                });
}

}
