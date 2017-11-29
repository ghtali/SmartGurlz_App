package smartgurlz.com.smartgurlz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class SelectLevel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_level);

        setContentView(R.layout.activity_select_level);

        GridView gridview = (GridView) findViewById(R.id.gridView);
        gridview.setAdapter(new LevelAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(SelectLevel.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}

