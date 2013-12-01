
package com.dove.viewfactory;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;

/**
 * This factory adapter is a tool that's used to split different view type
 * operation into different view factory.
 * 
 * @see BaseExpandableListAdapter
 */
public abstract class ExpandableListViewFactoryAdapter extends BaseExpandableListAdapter {
    private static final String TAG = "ExpandableListViewFactoryAdapter";
    /**
     * Stores different group view factories.
     */
    private SparseArray<ViewGroupFactory> mGroupFactories;

    /**
     * Stores different child view factories.
     */
    private SparseArray<ViewChildFactory> mChildFactories;

    /**
     * Get a new group view factory.
     * 
     * @param viewType The new view factory type.
     * @return A new view factory instance.
     */
    protected abstract ViewGroupFactory newViewGroupFactory(int viewType);

    /**
     * Get a new child view factory.
     * 
     * @param viewType The new view factory type.
     * @return A new view factory instance.
     */
    protected abstract ViewChildFactory newChildViewFactory(int viewType);

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
            ViewGroup parent) {
        if (mGroupFactories == null) {
            mGroupFactories = new SparseArray<ViewGroupFactory>(getGroupTypeCount());
        }

        final int viewType = getGroupType(groupPosition);
        ViewGroupFactory viewFactory = mGroupFactories.get(viewType);

        // First, try to get the view factory.
        if (viewFactory == null) {
            viewFactory = newViewGroupFactory(viewType);

            if (viewFactory == null) {
                throw new UnsupportedOperationException(
                        "The concrete subclass should provide an new group view instance withe type "
                                + viewType);
            }

            mGroupFactories.put(viewType, viewFactory);
        }

        // Second, get the convert view.
        if (convertView == null) {
            convertView = viewFactory.getView(viewType, groupPosition, isExpanded,
                    (ExpandableListView) parent);
            Log.d(TAG, "GroupView Create an new view with type " + viewType);
        }

        // Last, set the convert view.
        final Object groupData = getGroup(groupPosition);
        viewFactory.setView(convertView, viewType, groupPosition, groupData, isExpanded,
                (ExpandableListView) parent);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
            View convertView, ViewGroup parent) {
        if (mChildFactories == null) {
            mChildFactories = new SparseArray<ViewChildFactory>(getChildTypeCount());
        }

        final int viewType = getChildType(groupPosition, childPosition);
        ViewChildFactory viewFactory = mChildFactories.get(viewType);

        // First, try to get the view factory.
        if (viewFactory == null) {
            viewFactory = newChildViewFactory(viewType);

            if (viewFactory == null) {
                throw new UnsupportedOperationException(
                        "The concrete subclass should provide an new child view instance withe type "
                                + viewType);
            }

            mChildFactories.put(viewType, viewFactory);
        }

        // Second, get the convert view.
        if (convertView == null) {
            convertView = viewFactory.getView(viewType, groupPosition, childPosition,
                    (ExpandableListView) parent);
            Log.d(TAG, "ChildView Create an new view with type " + viewType);
        }

        // Last, set the convert view.
        final Object viewData = getChild(groupPosition, childPosition);
        viewFactory.setView(convertView, viewType, groupPosition, childPosition, childPosition,
                viewData, null);

        return convertView;
    }

    /**
     * View factory is used with to get and set a group view.
     */
    public static interface ViewGroupFactory {
        /**
         * Get a new specified type view.
         * 
         * @param type The view type.
         * @param position The position of the group for which the View is
         *            returned.
         * @param isExpanded Whether the group is expanded or collapsed.
         * @param parent The ExpandableListView that this view will eventually
         *            be attached to.
         * @return The View corresponding to the group at the specified
         *         position.
         */
        public View getView(int type, int position, boolean isExpanded, ExpandableListView parent);

        /**
         * Set the specific view data.
         * 
         * @param view The view to be set.
         * @param type The view type.
         * @param position The group view's position in the adapter
         * @param data The data that'll be displayed on the group view.
         * @param isExpanded Whether the group is expanded or collapsed.
         * @param parent The ExpandableListView that view is attached to.
         */
        public void setView(View view, int type, int position, Object data, boolean isExpanded,
                ExpandableListView parent);
    }

    /**
     * View factory is used with to get and set a child view.
     */
    public interface ViewChildFactory {
        /**
         * Get a new specified type view.
         * 
         * @param type The new child view's child type.
         * @param groupPosition The position of the group that contains the
         *            child.
         * @param childPosition The position of the child (for which the View is
         *            returned) within the group.
         * @param parent The ExpandableListView that this view will eventually
         *            be attached to.
         * @return A new child view.
         */
        public View getView(int type, int groupPosition, int childPosition,
                ExpandableListView parent);

        /**
         * Set the specific child view's data.
         * 
         * @param view The child view to be set.
         * @param type The child view's type.
         * @param groupPosition The position of the group that contains the
         *            child.
         * @param childPosition The position of the child (for which the View is
         *            returned) within the group.
         * @param position The child view's position in the adapter
         * @param data The data that'll be displayed on the child view.
         * @param parent The ExpandableListView that view is attached to.
         */
        public void setView(View view, int type, int groupPosition, int childPosition,
                int position, Object data, ExpandableListView parent);
    }
}
