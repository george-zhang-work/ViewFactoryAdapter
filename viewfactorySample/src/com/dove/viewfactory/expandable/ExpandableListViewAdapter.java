
package com.dove.viewfactory.expandable;

import com.dove.viewfactory.ExpandableListViewFactoryAdapter;
import com.dove.viewfactory.MenuInfo;

public class ExpandableListViewAdapter extends ExpandableListViewFactoryAdapter {

    @Override
    public int getGroupCount() {
        return MenuInfo.GROUP_COUNT;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return MenuInfo.getChildCount(groupPosition);
    }

    @Override
    public Object getGroup(int groupPosition) {
        return MenuInfo.getGroup(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    @Override
    public int getGroupTypeCount() {
        return MenuInfo.GROUP_TYPE_COUNT;
    }

    @Override
    public int getChildTypeCount() {
        return MenuInfo.CHILD_TYPE_COUNT;
    }

    @Override
    public int getGroupType(int groupPosition) {
        return MenuInfo.getGroupType(groupPosition);
    }

    @Override
    public int getChildType(int groupPosition, int childPosition) {
        return MenuInfo.getChildType(groupPosition + childPosition);
    }

    @Override
    protected ViewGroupFactory newViewGroupFactory(int viewType) {
        switch (viewType) {
            case MenuInfo.GROUP_TYPE_GREEN:
                return new GroupGreenFactory();
            case MenuInfo.GROUP_TYPE_BLUE:
                return new GroupBlueFactory();
            case MenuInfo.GROUP_TYPE_RED:
                return new GroupRedFactory();
            case MenuInfo.GROUP_TYPE_ORANGE:
                return new GroupOrangeFactory();
        }
        return null;
    }

    @Override
    protected ViewChildFactory newChildViewFactory(int viewType) {
        switch (viewType) {
            case MenuInfo.CHILD_TYPE_BLUE:
                return new ChildBlueFactory();
            case MenuInfo.CHILD_TYPE_GREEN:
                return new ChildGreenFactory();
            case MenuInfo.CHILD_TYPE_ORANGE:
                return new ChildOrangeFactory();
            case MenuInfo.CHILD_TYPE_RED:
                return new ChildRedFactory();
        }
        return null;
    }

}
