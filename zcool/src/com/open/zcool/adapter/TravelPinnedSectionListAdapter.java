/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-5-18下午4:51:02
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.zcool.adapter;

import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.open.android.adapter.CommonAdapter;
import com.open.zcool.R;
import com.open.zcool.bean.AllBean;
import com.open.zcool.bean.TravelCityBean;
import com.open.zcool.widget.PinnedSectionListView.PinnedSectionListAdapter;

/**
 ***************************************************************************************************************************************************************************** 
 * 
 * @author :fengguangjing
 * @createTime:2017-5-18下午4:51:02
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 ***************************************************************************************************************************************************************************** 
 */
public class TravelPinnedSectionListAdapter extends CommonAdapter<TravelCityBean> implements PinnedSectionListAdapter {
	public static final int ITEM = 0;
	public static final int SECTION = 1;

	public TravelPinnedSectionListAdapter(Context mContext, List<TravelCityBean> list) {
		super(mContext, list);
	}

//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see com.open.android.adapter.CommonAdapter#getView(int,
//	 * android.view.View, android.view.ViewGroup)
//	 */
//	@Override
//	public View getView(int position, View convertView, ViewGroup parent) {
//		TextView view = new  TextView(mContext) ;
//		view.setTextColor(mContext.getResources().getColor(R.color.white));
//		view.setTag("" + position);
//		TravelCityBean bean = (TravelCityBean) getItem(position);
//		if (bean.getSectiontype() == SECTION) {
//			// view.setOnClickListener(PinnedSectionListActivity.this);
//			view.setBackgroundColor(mContext.getResources().getColor(bean.getTypecolor()));
//		}
//		return view;
//	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TravelCityBean bean = (TravelCityBean) getItem(position);
		View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_travel_item, null);
		TextView text_name = (TextView) view.findViewById(R.id.title);
		text_name.setTag("" + position);
		text_name.setTextColor(mContext.getResources().getColor(R.color.white));
		if (bean.getSectiontype() == SECTION) {
			text_name.setBackgroundColor(mContext.getResources().getColor(COLORS[position%4]));
		}
		text_name.setText(bean.getName());
		return view;
	}
	
	private static final int[] COLORS = new int[] {
	       R.color.green_light, R.color.orange_light,
	       R.color.blue_light, R.color.red_light };

	@Override
	public int getViewTypeCount() {
		return 2;
	}

	@Override
	public int getItemViewType(int position) {
		return ((TravelCityBean)getItem(position)).getSectiontype();
	}

	@Override
	public boolean isItemViewTypePinned(int viewType) {
		return viewType == SECTION;
	}

}
