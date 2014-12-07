package com.example.pagerslidingtabstrip;

import java.util.ArrayList;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;

public class MainActivity extends FragmentActivity {

	private PagerSlidingTabStrip tabs;
	private ViewPager pager;
	private ArrayList<Fragment> fragmentsList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViews();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	protected void findViews() {
		// TODO Auto-generated method stub

		
		tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
		
		pager = (ViewPager) findViewById(R.id.pager);
		
		fragmentsList = new ArrayList<Fragment>();
		fragmentsList.add(new FragmentTest(MainActivity.this,1));
		fragmentsList.add(new FragmentTest(MainActivity.this,2));
		fragmentsList.add(new FragmentTest(MainActivity.this,3));
		
		pager.setAdapter(new MyPagerAdapter(
				getSupportFragmentManager(), fragmentsList));
		
		
		tabs.setViewPager(pager);
		tabs.setShouldExpand(true);
		
	}

	public class MyPagerAdapter extends FragmentPagerAdapter {

		private ArrayList<Fragment> fragmentsList;
		private final String[] titles = {"1","2","3" };
		
		public MyPagerAdapter(FragmentManager fm,
				ArrayList<Fragment> fragments) {
			super(fm);
			this.fragmentsList = fragments;
		}

		public MyPagerAdapter(FragmentManager fm) {
			super(fm);
		}
		@Override
		public CharSequence getPageTitle(int position) {
			return titles[position];
		}

		@Override
		public int getCount() {
			return titles.length;
		}

		@Override
		public Fragment getItem(int position) {
			return fragmentsList.get(position);
	
		}

	}
}
