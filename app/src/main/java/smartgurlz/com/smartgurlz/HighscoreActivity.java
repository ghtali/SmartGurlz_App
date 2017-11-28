package smartgurlz.com.smartgurlz;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

/**
 * Created by flemm on 28-11-2017.
 */

public class HighscoreActivity extends AppCompatActivity {

    public Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);

        GridView gridview = (GridView) findViewById(R.id.gridView);
        gridview.setAdapter(new HighScoreAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(HighscoreActivity.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });

        backButton = (Button) findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == backButton) {
                    //Hop tilbage til menu
                }
            }
        });

    }


}
