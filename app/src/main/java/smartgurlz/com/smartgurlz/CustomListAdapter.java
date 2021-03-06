package smartgurlz.com.smartgurlz;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;


/*@author Abdi & Mads 12-01-18
* */
public class CustomListAdapter extends ArrayAdapter<String> {

    private final Activity context;
   private final String[] itemname;
    private final Integer[] imgid;
    private GridView gridView2;

    public CustomListAdapter(Activity context, String[] itemname, Integer[] imgid) {
        super(context, R.layout.mylist, itemname);


        this.context=context;
      this.itemname=itemname;
        this.imgid=imgid;


    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.mylist, null,true);


        GridView gridView2 = (GridView ) rowView.findViewById( R.id.gridView2 ) ;

       // TextView txtTitle = (TextView ) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView ) rowView.findViewById(R.id.icon);

      // TextView extratxt = (TextView) rowView.findViewById(R.id.textView1);

       //txtTitle.setText(itemname[position]);
        imageView.setImageResource(imgid[position]);
    //    extratxt.setText(itemname[position]);

        return rowView;

    };
}