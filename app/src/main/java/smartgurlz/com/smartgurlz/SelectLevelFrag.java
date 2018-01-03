package smartgurlz.com.smartgurlz;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.SmartGurlz.app.UnityPlayerActivity;

import static android.content.IntentSender.*;


public class SelectLevelFrag extends Fragment {

    public SelectLevelFrag(){

    }
@Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment_select_level, container, false);


    //  String [] MenuItem = new String[]{"1", "2 ", "3"};

    GridView gridView = (GridView) v.findViewById(R.id.view1);

    gridView.setAdapter(new LevelAdapter(this));

    gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent, View v,
                                int position, long id) {
            switch (position) {
                case 0:
                    Intent intent = new Intent(getActivity(), UnityPlayerActivity.class);
                    startActivity(intent);


                    break;


            }


        }

    });
    return v;

}
}




