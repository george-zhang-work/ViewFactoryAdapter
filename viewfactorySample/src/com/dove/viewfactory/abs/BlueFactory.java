
package com.dove.viewfactory.abs;

import android.view.View;
import android.widget.AbsListView;

import com.dove.viewfactory.AbsListViewFactoryAdapter.ViewFactory;
import com.dove.viewfactory.MenuInfo;
import com.dove.viewfactory.R;

public class BlueFactory implements ViewFactory {

    public final static int COLOR = MenuInfo.ColorLightInfo.ORANGE.getColor();


    @Override
    public View getView(int type, int position, AbsListView parent) {
        View v = View.inflate(parent.getContext(), R.layout.abs_list_item, null);
        v.setBackgroundColor(parent.getContext().getResources().getColor(COLOR));
        return v;
    }

    @Override
    public void setView(View view, int type, int position, Object data, AbsListView parent) {
        
    }

}
