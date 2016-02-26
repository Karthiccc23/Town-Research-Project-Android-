package com.netw.sn;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Settingsadapter extends BaseAdapter {

	private  Activity context;
	private  String[] itemname;
	ArrayList<String> data;
	ArrayList<String> share;
	private  Integer[] imgid;
	private static LayoutInflater inflater=null;
	public Settingsadapter(Activity a, ArrayList d) {

		/********** Take passed values **********/
		context = a;
		data=d;

		/***********  Layout inflator to call external xml layout () ***********/
		inflater = ( LayoutInflater )context.
				getSystemService(Context.LAYOUT_INFLATER_SERVICE);

	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View vi = convertView;
		vi = inflater.inflate(R.layout.activity_settingsadapter, null);
		TextView setname=(TextView)vi.findViewById(R.id.settingsname);
		ImageView fb=(ImageView)vi.findViewById(R.id.fb);

		ImageView twit=(ImageView)vi.findViewById(R.id.twit);
		ImageView insta=(ImageView)vi.findViewById(R.id.insta);
		String settingname=data.get(position);
		setname.setText(settingname);
		if(settingname.equals("Share the app")||settingname.equals("Like Us"))
		{
			fb.setVisibility(View.VISIBLE);
			twit.setVisibility(View.VISIBLE);
			insta.setVisibility(View.VISIBLE);

		}
		else
		{
			fb.setVisibility(View.GONE);
			twit.setVisibility(View.GONE);
			insta.setVisibility(View.GONE);
		}

		// TODO Auto-generated method stub
		return vi;
	}



}
