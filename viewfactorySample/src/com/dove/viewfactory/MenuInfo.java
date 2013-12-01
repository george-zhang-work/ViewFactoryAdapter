
package com.dove.viewfactory;

import android.util.Pair;

import com.dove.viewfactory.expandable.GroupBlueFactory;
import com.dove.viewfactory.expandable.GroupGreenFactory;
import com.dove.viewfactory.expandable.GroupOrangeFactory;
import com.dove.viewfactory.expandable.GroupRedFactory;

public class MenuInfo {
    public static final int GRID_COUNT = 0x11;
    public static final int LIST_COUNT = 0x40;
    public static final int TYPE_COUNT = 0x04;

    public static final int TYPE_GREEN = 0x00;
    public static final int TYPE_BLUE = 0x01;
    public static final int TYPE_ORANGE = 0x02;
    public static final int TYPE_RED = 0x03;

    public static final int GROUP_COUNT = 0X0B;
    public static final int GROUP_TYPE_COUNT = 0x04;
    public static final int CHILD_TYPE_COUNT = 0x04;

    public static final int GROUP_TYPE_GREEN = 0x00;
    public static final int GROUP_TYPE_BLUE = 0x01;
    public static final int GROUP_TYPE_ORANGE = 0x02;
    public static final int GROUP_TYPE_RED = 0x03;

    public static final int CHILD_TYPE_BLUE = 0x00;
    public static final int CHILD_TYPE_GREEN = 0x01;
    public static final int CHILD_TYPE_ORANGE = 0x02;
    public static final int CHILD_TYPE_RED = 0x03;

    public static int getChildCount(int groupPosition) {
        return 3 + groupPosition % 3;
    }

    public static Object getGroup(int groupPosition) {
        final int viewType = groupPosition % GROUP_TYPE_COUNT;
        switch (viewType) {
            case MenuInfo.GROUP_TYPE_GREEN:
                return new GroupGreenFactory.ViewInfo();
            case MenuInfo.GROUP_TYPE_BLUE:
                return new GroupBlueFactory.ViewInfo();
            case MenuInfo.GROUP_TYPE_RED:
                return new GroupRedFactory.ViewInfo();
            case MenuInfo.GROUP_TYPE_ORANGE:
                return new GroupOrangeFactory.ViewInfo();
        }
        return new GroupGreenFactory.ViewInfo();
    }

    public static int getGroupType(int groupPosition) {
        return groupPosition % GROUP_TYPE_COUNT;
    }

    public static int getChildType(int childPosition) {
        return childPosition % CHILD_TYPE_COUNT;
    }

    public static final int BLUE_COUN = 5;
    public static final int GREEN_COUNT = 5;
    public static final int ORANGE_COUNT = 5;
    public static final int REC_COUNT = 5;

    public static final Pair<GroupTextInfo, ColorDarkInfo> GROUP_BLUE = new Pair<GroupTextInfo, ColorDarkInfo>(
            GroupTextInfo.BLUE, ColorDarkInfo.BLUE);
    public static final Pair<GroupTextInfo, ColorDarkInfo> GROUP_GREEN = new Pair<GroupTextInfo, ColorDarkInfo>(
            GroupTextInfo.GREEN, ColorDarkInfo.GREEN);
    public static final Pair<GroupTextInfo, ColorDarkInfo> GROUP_ORANGE = new Pair<GroupTextInfo, ColorDarkInfo>(
            GroupTextInfo.ORANGE, ColorDarkInfo.ORANGE);
    public static final Pair<GroupTextInfo, ColorDarkInfo> GROUP_RED = new Pair<GroupTextInfo, ColorDarkInfo>(
            GroupTextInfo.RED, ColorDarkInfo.RED);

    public static final Pair<ChildTextInfo, ColorLightInfo> CHILD_BLUE = new Pair<ChildTextInfo, ColorLightInfo>(
            ChildTextInfo.BLUE, ColorLightInfo.BLUE);
    public static final Pair<ChildTextInfo, ColorLightInfo> CHILD_GREEN = new Pair<ChildTextInfo, ColorLightInfo>(
            ChildTextInfo.GREEN, ColorLightInfo.GREEN);
    public static final Pair<ChildTextInfo, ColorLightInfo> CHILD_ORANGE = new Pair<ChildTextInfo, ColorLightInfo>(
            ChildTextInfo.ORANGE, ColorLightInfo.ORANGE);
    public static final Pair<ChildTextInfo, ColorLightInfo> CHILD_RED = new Pair<ChildTextInfo, ColorLightInfo>(
            ChildTextInfo.RED, ColorLightInfo.RED);

    public static enum ColorLightInfo {
        BLUE(android.R.color.holo_blue_light), GREEN(android.R.color.holo_green_light), ORANGE(
                android.R.color.holo_orange_light), RED(android.R.color.holo_red_light);

        int mColor;

        private ColorLightInfo(int color) {
            mColor = color;
        }

        public int getColor() {
            return mColor;
        }
    }

    public static enum ColorDarkInfo {
        BLUE(android.R.color.holo_blue_dark), GREEN(android.R.color.holo_green_dark), ORANGE(
                android.R.color.holo_orange_dark), RED(android.R.color.holo_red_dark);

        int mColor;

        private ColorDarkInfo(int color) {
            mColor = color;
        }

        public int getColor() {
            return mColor;
        }
    }

    public static enum ChildTextInfo {
        BLUE("Child BLue"), GREEN("Child Green"), ORANGE("Child Orange"), RED("Child Red");

        String mText;

        private ChildTextInfo(String text) {
            mText = text;
        }

        public String getText() {
            return mText;
        }
    }

    public static enum GroupTextInfo {
        BLUE("Group BLue"), GREEN("Group Green"), ORANGE("Group Orange"), RED("Group Red");

        String mText;

        private GroupTextInfo(String text) {
            mText = text;
        }

        public String getText() {
            return mText;
        }
    }

}
