package smartgurlz.com.smartgurlz;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends FragmentActivity {

    private Button btnPlay1,btnLogin,btnHighScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu);

        btnPlay1 = (Button) findViewById(R.id.btnplay1);


        btnLogin=(Button) findViewById(R.id.btnlogin);


        btnHighScore = (Button) findViewById(R.id.btnhighscore);

        btnPlay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == btnPlay1) {
                    Intent intent = new Intent(MenuActivity.this, SelectLevel.class);
                    startActivity(intent);
                }
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v==btnLogin){
                    Intent intent1=new Intent(MenuActivity.this,LoginActivity.class);
                    startActivity(intent1);

                }
            }
        });
        btnHighScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2= new Intent(MenuActivity.this,HighscoreActivity.class);
                startActivity(intent2);
            }
        });

    }

}
