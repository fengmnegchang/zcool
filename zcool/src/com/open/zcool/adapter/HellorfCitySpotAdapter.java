/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-5-19上午10:52:20
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.zcool.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.open.android.adapter.CommonAdapter;
import com.open.zcool.R;
import com.open.zcool.activity.HellorfSearchGridFragmentActivity;
import com.open.zcool.activity.ZcoolWebViewActivity;
import com.open.zcool.bean.CitySpotBean;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-5-19上午10:52:20
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class HellorfCitySpotAdapter extends CommonAdapter<CitySpotBean> {

	public HellorfCitySpotAdapter(Context mContext, List<CitySpotBean> list) {
		super(mContext, list);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final CitySpotBean bean = (CitySpotBean) getItem(position);
		View view;
		view = LayoutInflater.from(mContext).inflate(R.layout.adapter_hellorf_spot, null);
		TextView text_name = (TextView) view.findViewById(R.id.text_name);
		text_name.setText(bean.getName());
		text_name.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
//				ZcoolWebViewActivity.startZcoolWebViewActivity(mContext, bean.getHref());
				HellorfSearchGridFragmentActivity.startHellorfSearchGridFragmentActivity(mContext, bean.getHref());
			}
		});
		return view;
	}
}
