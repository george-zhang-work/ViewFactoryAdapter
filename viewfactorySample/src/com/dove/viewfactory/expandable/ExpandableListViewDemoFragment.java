
package com.dove.viewfactory.expandable;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.dove.viewfactory.R;

public class ExpandableListViewDemoFragment extends Fragment {

    private ExpandableListView mListView;
    private ExpandableListViewAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new ExpandableListViewAdapter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.expandable_fragment, null);
        mListView = (ExpandableListView) v.findViewById(R.id.expandable_list_vw);
        mListView.setAdapter(mAdapter);
        return v;
    }

}
