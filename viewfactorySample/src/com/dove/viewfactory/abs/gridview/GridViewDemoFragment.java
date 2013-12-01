
package com.dove.viewfactory.abs.gridview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.dove.viewfactory.R;

public class GridViewDemoFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.grid_fragment, null);
        GridView gridView = (GridView) v.findViewById(R.id.grid_vw);
        GridViewAdapter adapter = new GridViewAdapter();
        gridView.setAdapter(adapter);
        return v;
    }
}
