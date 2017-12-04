package smartgurlz.com.smartgurlz;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends FragmentActivity {

    private Button btnplay1,btnlogin,btnhighscore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu);

        btnplay1 = (Button) findViewById(R.id.btnplay1);


        btnlogin=(Button) findViewById(R.id.btnlogin);


        btnhighscore = (Button) findViewById(R.id.btnhighscore);

        btnplay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == btnplay1) {
                    Intent intent = new Intent(getApplicationContext(), SelectLevel.class);
                    startActivity(intent);
                    finish();

                }
            }
        });
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v==btnlogin){
                    Intent intent1=new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(intent1);
                    finish();

                }
            }
        });
        btnhighscore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent2= new Intent(getApplicationContext(),HighscoreActivity.class);
                startActivity(intent2);
                finish();
            }
        });

    }

}
