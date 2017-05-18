/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-3下午4:07:19
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
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.open.android.adapter.CommonPagerAdapter;
import com.open.zcool.R;
import com.open.zcool.activity.ZcoolWebViewActivity;
import com.open.zcool.bean.HellorfSearchBean;

/**
 ***************************************************************************************************************************************************************************** 
 * 
 * @author :fengguangjing
 * @createTime:2017-2-3下午4:07:19
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 ***************************************************************************************************************************************************************************** 
 */
public class HellorfPagerAdapter extends CommonPagerAdapter<HellorfSearchBean> {

	public HellorfPagerAdapter(Context mContext, List<HellorfSearchBean> list) {
		super(mContext, list);
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		final HellorfSearchBean bean = (HellorfSearchBean) getItem(position);
		final ViewHolder mViewHolder = new ViewHolder();
		View convertView = LayoutInflater.from(mContext).inflate(R.layout.adapter_index_focus_viewpager, null);
		mViewHolder.imageview = (ImageView) convertView.findViewById(R.id.imageview);
		mViewHolder.txt_alt = (TextView) convertView.findViewById(R.id.txt_alt);
		if (bean != null) {
			if (bean.getSrc() != null && bean.getSrc().length() > 0) {
				DisplayImageOptions options = new DisplayImageOptions.Builder().showStubImage(R.drawable.index_focus).showImageForEmptyUri(R.drawable.index_focus).showImageOnFail(R.drawable.index_focus)
						.cacheInMemory().cacheOnDisc().build();
				ImageLoader.getInstance().displayImage(bean.getSrc(), mViewHolder.imageview, options, null);
			}
			mViewHolder.txt_alt.setText(bean.getTitle());
			convertView.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					ZcoolWebViewActivity.startZcoolWebViewActivity(mContext, bean.getHref());
				}
			});
		}
		container.addView(convertView);
		return convertView;
	}

	private class ViewHolder {
		ImageView imageview;
		TextView txt_alt;
	}

}
