package com.netw.sn;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


public class Settings extends Fragment {
	ListView settingslist;
	Settingsadapter sa;
	ArrayList<String> list=new ArrayList<String>();

	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_settings, container, false);
		settingslist=(ListView)rootView.findViewById(R.id.settingslist);
		list.clear();
		list.add("My Posts");
		list.add("Notifications");
		list.add("Rules Of use");
		list.add("Contact us");
		list.add("Terms of service");
		list.add("Privacy Policy");
		list.add("Share the app");
		list.add("Like Us");
		sa=new Settingsadapter(this.getActivity(), list);
		settingslist.setAdapter(sa);
		


        return rootView;
    }
 
}