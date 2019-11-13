package com.example.busspass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Switch;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class BusInfoAdapter extends ArrayAdapter<BusInfo>{
    public BusInfoAdapter(Context context, List<BusInfo> BusInfo) {
        super( context, 0, BusInfo);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        BusInfo currentBus = getItem(position);

        TextView time = (TextView) listItemView.findViewById(R.id.time);
        String s1 = currentBus.getTime();
        time.setText(s1);

        TextView start = (TextView) listItemView.findViewById(R.id.start);
        String s2 = currentBus.getStart();
        start.setText(s2);

        TextView end = (TextView) listItemView.findViewById(R.id.end);
        String s3 = currentBus.getEnd();
        end.setText(s3);

        TextView bus = (TextView) listItemView.findViewById(R.id.bus);
        String s4 = currentBus.getBus();
        bus.setText(s4);

        Switch setReminder=(Switch) listItemView.findViewById(R.id.setReminder);



      /*  all_string[z]=s11[k] ;
        z++;
        all_string[z]=s21[k];
        z++;
        k++;*/
        return listItemView;
    }
   /* public String[] getString()
    {

        return all_string;
    }
*/

}