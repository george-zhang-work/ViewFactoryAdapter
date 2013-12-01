
package com.dove.viewfactory.expandable;

import android.util.Pair;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.dove.viewfactory.ExpandableListViewFactoryAdapter.ViewGroupFactory;
import com.dove.viewfactory.MenuInfo;
import com.dove.viewfactory.MenuInfo.ChildTextInfo;
import com.dove.viewfactory.MenuInfo.ColorDarkInfo;
import com.dove.viewfactory.MenuInfo.ColorLightInfo;
import com.dove.viewfactory.MenuInfo.GroupTextInfo;
import com.dove.viewfactory.R;

public class GroupBlueFactory implements ViewGroupFactory, View.OnClickListener {

    @Override
    public View getView(int type, int position, boolean isExpanded, ExpandableListView parent) {
        ViewHoler h = new ViewHoler();
        View v = View.inflate(parent.getContext(), R.layout.expandable_group, null);

        h.zeroView = (TextView) v.findViewById(R.id.zero_txt_vw);
        h.oneView = (TextView) v.findViewById(R.id.one_txt_vw);
        h.twoView = (TextView) v.findViewById(R.id.two_txt_vw);
        h.threeView = (TextView) v.findViewById(R.id.three_txt_vw);
        h.fourView = (TextView) v.findViewById(R.id.four_txt_vw);

        v.setTag(h);

        return v;
    }

    @Override
    public void setView(View view, int type, int position, Object data, boolean isExpanded,
            ExpandableListView parent) {

        ViewHoler h = (ViewHoler) view.getTag();
        ViewInfo info = (ViewInfo) data;

        setView(h.zeroView, info.zero.first.getText(), info.zero.second.getColor());

        setView(h.oneView, info.one.first.getText(), info.cone, info.one.second.getColor());
        setView(h.twoView, info.two.first.getText(), info.ctwo, info.two.second.getColor());
        setView(h.threeView, info.three.first.getText(), info.cthree, info.three.second.getColor());
        setView(h.fourView, info.four.first.getText(), info.cfour, info.four.second.getColor());

    }

    private static void setView(TextView v, String text, int count, int color) {
        setView(v, text + " := " + count, color);
    }

    private static void setView(TextView v, String text, int color) {
        v.setBackgroundColor(v.getContext().getResources().getColor(color));
        // v.setText(text);
    }

    public static class ViewInfo {
        Pair<GroupTextInfo, ColorDarkInfo> zero = MenuInfo.GROUP_BLUE;

        Pair<ChildTextInfo, ColorLightInfo> four = MenuInfo.CHILD_GREEN;
        int cone = MenuInfo.GREEN_COUNT;
        Pair<ChildTextInfo, ColorLightInfo> three = MenuInfo.CHILD_BLUE;
        int ctwo = MenuInfo.BLUE_COUN;
        Pair<ChildTextInfo, ColorLightInfo> two = MenuInfo.CHILD_ORANGE;
        int cthree = MenuInfo.ORANGE_COUNT;
        Pair<ChildTextInfo, ColorLightInfo> one = MenuInfo.CHILD_RED;
        int cfour = MenuInfo.REC_COUNT;
    }

    static class ViewHoler {
        TextView zeroView;
        TextView oneView;
        TextView twoView;
        TextView threeView;
        TextView fourView;
    }

    @Override
    public void onClick(View v) {
        final CharSequence text = ((TextView) v).getText();
        Toast.makeText(v.getContext(), text, Toast.LENGTH_SHORT).show();
    }
}
