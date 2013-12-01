
package com.dove.viewfactory.abs.listview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.dove.viewfactory.R;

public class ListViewDemoFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.list_fragment, null);
        ListView listView = (ListView) v.findViewById(R.id.list_vw);
        listView.setAdapter(new ListViewAdapter());
        return v;
    }
}
