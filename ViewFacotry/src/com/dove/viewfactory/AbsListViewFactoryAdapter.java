
package com.dove.viewfactory;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;

/**
 * This factory adapter is a tool that's used to split different view type
 * operation into different view factory.
 * 
 * @see BaseAdapter
 */
public abstract class AbsListViewFactoryAdapter extends BaseAdapter {
    private static final String TAG = "ViewFactoryAdapter";

    private SparseArray<ViewFactory> mFactories;

    protected abstract ViewFactory getViewFactory(int viewType);

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int viewType = getItemViewType(position);
        if (mFactories == null) {
            mFactories = new SparseArray<AbsListViewFactoryAdapter.ViewFactory>(getViewTypeCount());
        }
        ViewFactory viewFactory = mFactories.get(viewType);

        // First, try to get the view factory.
        if (viewFactory == null) {
            viewFactory = getViewFactory(viewType);

            if (viewFactory == null) {
                throw new UnsupportedOperationException(
                        "The concrete subclass should provide an new item view instance withe type "
                                + viewType);
            }

            mFactories.put(viewType, viewFactory);
        }

        // Second, get the convert view.
        if (convertView == null) {
            convertView = viewFactory.getView(viewType, position, (AbsListView) parent);

            Log.d(TAG, "ChildView Create an new view with type " + viewType);
        }

        // Last, set the convert view.
        viewFactory.setView(convertView, viewType, position, getItem(position),
                (AbsListView) parent);

        return convertView;
    }

    /**
     * View factory is used with to get and set a item view.
     */
    public static interface ViewFactory {
        /**
         * Get a new specified type view.
         * 
         * @param type The view type.
         * @param position The position of the item within the adapter's data
         *            set of the item whose view we want.
         * @param parent The AbsListView that this view will eventually be
         *            attached to.
         * @return The View corresponding to the item at the specified position.
         */
        public View getView(int type, int position, AbsListView parent);

        /**
         * Set the specific view data.
         * 
         * @param view The view to be set.
         * @param type The view type.
         * @param position The position of the item within the adapter's data
         *            set of the item whose view we want.
         * @param data The data that'll be displayed on the group view.
         * @param parent The AbsListView that view is attached to.
         */
        public void setView(View view, int type, int position, Object data, AbsListView parent);
    }
}
