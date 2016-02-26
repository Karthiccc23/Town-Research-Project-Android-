package com.netw.sn;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Homepage extends Activity {
	ActionBar.Tab New,Peek; 
	ActionBar.Tab menuicon1,menuicon2;
	ActionBar actionBar;

	Fragment Newpage = new Newpage(); 
	Fragment Peekpage = new Peekpage(); 
	Fragment Settings=new Settings();
	LinearLayout settings,home;
	RelativeLayout header,homeheader;
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_ACTION_BAR);

		setContentView(R.layout.activity_homepage);
		settings=(LinearLayout)findViewById(R.id.settings);
		home=(LinearLayout)findViewById(R.id.home);
		homeheader=(RelativeLayout)findViewById(R.id.homeheader);
		homeheader.setVisibility(View.VISIBLE);
		header=(RelativeLayout)findViewById(R.id.header);
		header.setVisibility(View.GONE);
		String abc=getSizeName(getApplicationContext());
		Toast.makeText(this, abc, Toast.LENGTH_LONG).show();
		settings.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				actionBar.setDisplayShowTitleEnabled(false);
				actionBar.setDisplayShowCustomEnabled(true);
				actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
				
				actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM); 
				actionBar.setCustomView(R.layout.tablayout);
				homeheader.setVisibility(View.GONE);
				header.setVisibility(View.GONE);

				FragmentTransaction transaction = getFragmentManager().beginTransaction();

				// Replace whatever is in the fragment_container view with this fragment,
				// and add the transaction to the back stack if needed
				transaction.replace(R.id.fragment_container, Settings);
				transaction.addToBackStack(null);

				// Commit the transaction
				transaction.commit();

			}
		});
		home.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				actionBar.show();
				actionBar.setDisplayShowHomeEnabled(false);
				actionBar.setDisplayShowCustomEnabled(false);


				// Hide Actionbar Title
				actionBar.setDisplayShowTitleEnabled(false);

				// Create Actionbar Tabs
				actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
				header.setVisibility(View.GONE);

				homeheader.setVisibility(View.VISIBLE);

				FragmentTransaction transaction = getFragmentManager().beginTransaction();

				// Replace whatever is in the fragment_container view with this fragment,
				// and add the transaction to the back stack if needed
				transaction.replace(R.id.fragment_container,Newpage);
				transaction.addToBackStack(null);

				// Commit the transaction
				transaction.commit();

			}
		});


		actionBar = getActionBar();
		// Hide Actionbar Icon
		actionBar.setDisplayShowHomeEnabled(false);

		// Hide Actionbar Title
		actionBar.setDisplayShowTitleEnabled(false);

		// Create Actionbar Tabs
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		// Set Tab Icon and Titles
		menuicon1=actionBar.newTab();
		menuicon1.setIcon(R.drawable.mapnormal);
		New = actionBar.newTab().setText("New");
		Peek = actionBar.newTab().setText("Peek");
		menuicon2=actionBar.newTab();
		menuicon2.setIcon(R.drawable.postnormal);

		//				Tab3 = actionBar.newTab().setText("Tab3");

		// Set Tab Listeners
		menuicon1.setTabListener(new TabListener(Newpage));
		New.setTabListener(new TabListener(Newpage));
		Peek.setTabListener(new TabListener(Peekpage));
		menuicon2.setTabListener(new TabListener(Newpage));

		//				Tab3.setTabListener(new TabListener(fragmentTab3));

		// Add tabs to actionbar
		
		actionBar.addTab(menuicon1);
		actionBar.addTab(New);
		actionBar.addTab(Peek);
		actionBar.addTab(menuicon2);
		



	}

	private static String getSizeName(Context context) {
		int screenLayout = context.getResources().getConfiguration().screenLayout;
		screenLayout &= Configuration.SCREENLAYOUT_SIZE_MASK;

		switch (screenLayout) {
		case Configuration.SCREENLAYOUT_SIZE_SMALL:
			return "small";
		case Configuration.SCREENLAYOUT_SIZE_NORMAL:
			return "normal";
		case Configuration.SCREENLAYOUT_SIZE_LARGE:
			return "large";
		case 4: // Configuration.SCREENLAYOUT_SIZE_XLARGE is API >= 9
			return "xlarge";
		default:
			return "undefined";
		}
	}
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
	}
}
