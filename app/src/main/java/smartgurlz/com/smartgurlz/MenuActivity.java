package smartgurlz.com.smartgurlz;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnPlay1,btnLogin,btnHighscore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstanceState);

        btnPlay1 = (Button) findViewById(R.id.btnPlay1);
        btnPlay1.setOnClickListener(this);

        btnLogin=(Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);


        btnHighscore = (Button) findViewById(R.id.btnHighscore);
        btnHighscore.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v==btnPlay1){
            Intent intent= new Intent(this,SelectLevel.class);
            startActivity(intent);
        }
        if (v==btnLogin){
            Intent intent=new Intent(this,LoginActivity.class);
        }


    }
}
