package smartgurlz.com.smartgurlz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

/* @author Ana-Maria Fischer Zokalj
*/
public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText username_input;
    private EditText password_input;
    private Button login_btn;
    private Button signup_btn;
    private ImageButton back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username_input = (EditText) findViewById(R.id.username_etx);
        password_input = (EditText) findViewById(R.id.password_etx);

        login_btn = (Button) findViewById(R.id.login_bt);
        signup_btn = (Button) findViewById(R.id.signup_bt);
        back_btn = (ImageButton) findViewById(R.id.back_btn);

        login_btn.setOnClickListener(this);
        signup_btn.setOnClickListener(this);
        back_btn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

     // save the users login info
        if(v == signup_btn) {
            SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);

            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("username", username_input.getText().toString());
            editor.putString("password", password_input.getText().toString());
            editor.apply();

            Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show();

            //so the password and username clears from the screen.
            username_input.getText().clear();
            password_input.getText().clear();
        }

    // Login button
      if(v == login_btn) {
      SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
       String name = sharedPref.getString("username", "");
       String pw = sharedPref.getString("password", "");

       //Checks if the password and username is correct. Redirects to the menu if correct.
       if(username_input.getText().toString().equals(name) &&
               password_input.getText().toString().equals(pw)) {
                  Toast.makeText(getApplicationContext(), "Redirecting...",Toast.LENGTH_SHORT).show();
                 //   Intent i = new Intent(this, Menu.class);
                 //   startActivity(i);

           //Or a toast will tell the user that it is wrong
               }else{
                  Toast.makeText(getApplicationContext(), "Wrong username or password",Toast.LENGTH_LONG).show();


      }
      }

   if(v == back_btn){
      // Intent i = new Intent(this, Menu.class);
      // startActivity(i);
        }
    }



}
