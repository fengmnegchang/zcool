/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-5-19下午2:57:34
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.zcool.adapter.m;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.open.android.adapter.CommonAdapter;
import com.open.zcool.R;
import com.open.zcool.activity.ZcoolWebViewActivity;
import com.open.zcool.bean.TravelCityBean;
import com.open.zcool.bean.m.LeftMenuBean;

/**
 ***************************************************************************************************************************************************************************** 
 * 
 * @author :fengguangjing
 * @createTime:2017-5-19下午2:57:34
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 ***************************************************************************************************************************************************************************** 
 */
public class MMainLeftMenuAdapter extends CommonAdapter<LeftMenuBean> {

	public MMainLeftMenuAdapter(Context mContext, List<LeftMenuBean> list) {
		super(mContext, list);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final LeftMenuBean bean = (LeftMenuBean) getItem(position);
		View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_travel_item, null);
		TextView text_name = (TextView) view.findViewById(R.id.title);
		text_name.setTag("" + position);
		text_name.setTextColor(mContext.getResources().getColor(R.color.white));
		text_name.setBackgroundColor(mContext.getResources().getColor(COLORS[position % 4]));
		text_name.setText(bean.getTitle());
		text_name.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ZcoolWebViewActivity.startZcoolWebViewActivity(mContext, bean.getHref());
			}
		});
		return view;
	}

	private static final int[] COLORS = new int[] { R.color.green_light, R.color.orange_light, R.color.blue_light, R.color.red_light };

}
