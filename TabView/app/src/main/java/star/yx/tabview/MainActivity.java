package star.yx.tabview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabClickListener {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ArrayList<TabItem> tabs;
    private ActionBar actionBar;
    BaseFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.wechat);
        }

    }

    private void initData() {

        tabs = new ArrayList<>();
        tabs.add(new TabItem(R.drawable.selector_tab_msg, R.string.wechat, WechatFragment.class));
        tabs.add(new TabItem(R.drawable.selector_tab_contact, R.string.contacts, ContactsFragment.class));
        tabs.add(new TabItem(R.drawable.selector_tab_moments, R.string.discover, DiscoverFragment.class));
        tabs.add(new TabItem(R.drawable.selector_tab_profile, R.string.me, ProfileFragment.class));

        mTabLayout.initData(tabs, this);
        mTabLayout.setCurrentTab(0);

        FragAdapter adapter = new FragAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        mViewPager.setOffscreenPageLimit(2);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTabLayout.setCurrentTab(position);
                actionBar.setTitle(tabs.get(position).lableResId);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public void onTabClick(TabItem tabItem) {

        actionBar.setTitle(tabItem.lableResId);
        mViewPager.setCurrentItem(tabs.indexOf(tabItem));

    }


    public class FragAdapter extends FragmentPagerAdapter {


        public FragAdapter(FragmentManager fm) {
            super(fm);
            // TODO Auto-generated constructor stub
        }

        @Override
        public Fragment getItem(int arg0) {
            // TODO Auto-generated method stub
            try {
                return tabs.get(arg0).tagFragmentClz.newInstance();

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return fragment;
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return tabs.size();
        }

    }
}
