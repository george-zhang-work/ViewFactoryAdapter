
package com.dove.viewfactory.expandable;

import android.view.View;
import android.widget.ExpandableListView;

import com.dove.viewfactory.ExpandableListViewFactoryAdapter.ViewChildFactory;
import com.dove.viewfactory.MenuInfo;
import com.dove.viewfactory.R;

public class ChildRedFactory implements ViewChildFactory {

    public final static int COLOR = MenuInfo.ColorLightInfo.GREEN.getColor();

    @Override
    public View getView(int type, int groupPosition, int childPosition, ExpandableListView parent) {
        View v = View.inflate(parent.getContext(), R.layout.expandable_child, null);
        v.setBackgroundColor(parent.getContext().getResources().getColor(COLOR));
        return v;
    }

    @Override
    public void setView(View view, int type, int groupPosition, int childPosition, int position,
            Object data, ExpandableListView parent) {

    }

}
