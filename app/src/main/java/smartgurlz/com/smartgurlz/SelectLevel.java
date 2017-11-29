package smartgurlz.com.smartgurlz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.SmartGurlz.app.UnityPlayerActivity;
public class SelectLevel extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_level);

        setContentView(R.layout.activity_select_level);

        GridView gridview = (GridView) findViewById(R.id.gridview1);
        gridview.setAdapter(new LevelAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Intent intent = new Intent(getApplicationContext(), UnityPlayerActivity.class);
                startActivity(intent);
                Toast.makeText(SelectLevel.this, "" + position,
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}

