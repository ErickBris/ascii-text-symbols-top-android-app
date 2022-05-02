package com.t4t.symbols;



import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter
{

	private ArrayList<String> list;
	private Context mContext;

	public GridAdapter(Context baseContext, ArrayList<String> symbols) {
		
		list=symbols;
		mContext=baseContext;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		
		LayoutInflater mInflater = (LayoutInflater)
                mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        convertView = mInflater.inflate(R.layout.grid_adapter, null);
        
        TextView symbols=(TextView) convertView.findViewById(R.id.textView1);
        symbols.setText(list.get(position).toString());
        
		return convertView;
	}
	

}
