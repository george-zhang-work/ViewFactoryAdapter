
package com.dove.viewfactory.abs.gridview;

import com.dove.viewfactory.AbsListViewFactoryAdapter;
import com.dove.viewfactory.MenuInfo;
import com.dove.viewfactory.abs.BlueFactory;
import com.dove.viewfactory.abs.GreenFactory;
import com.dove.viewfactory.abs.OrangeFactory;
import com.dove.viewfactory.abs.RedFactory;

public class GridViewAdapter extends AbsListViewFactoryAdapter {

    @Override
    public int getCount() {
        return MenuInfo.GRID_COUNT;
    }

    @Override
    public int getViewTypeCount() {
        return MenuInfo.TYPE_COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        return position % MenuInfo.TYPE_COUNT;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    protected ViewFactory getViewFactory(int viewType) {
        switch (viewType) {
            case MenuInfo.TYPE_BLUE:
                return new BlueFactory();
            case MenuInfo.TYPE_GREEN:
                return new GreenFactory();
            case MenuInfo.TYPE_ORANGE:
                return new OrangeFactory();
            case MenuInfo.TYPE_RED:
                return new RedFactory();
        }
        return null;
    }

}
