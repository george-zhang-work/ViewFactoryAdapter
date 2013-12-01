
package com.dove.viewfactory;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;

import com.dove.viewfactory.R;
import com.dove.viewfactory.abs.gridview.GridViewDemoFragment;
import com.dove.viewfactory.abs.listview.ListViewDemoFragment;
import com.dove.viewfactory.expandable.ExpandableListViewDemoFragment;

public class ViewFactoryActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factory);

        ViewPager pager = (ViewPager) findViewById(R.id.view_pager);
        pager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.factory, menu);
        return true;
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position % 3) {
                case 0:
                    return new GridViewDemoFragment();
                case 1:
                    return new ListViewDemoFragment();
                default:
                    return new ExpandableListViewDemoFragment();
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
