/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-17下午3:42:08
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.zcool.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.open.android.adapter.CommonAdapter;
import com.open.zcool.R;
import com.open.zcool.activity.ZcoolWebViewActivity;
import com.open.zcool.bean.ResidentEnterpriseBean;

/**
 ***************************************************************************************************************************************************************************** 
 * 
 * @author :fengguangjing
 * @createTime:2017-2-17下午3:42:08
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 ***************************************************************************************************************************************************************************** 
 */
public class ResidentEnterpriseAdapter extends CommonAdapter<ResidentEnterpriseBean> {

	public ResidentEnterpriseAdapter(Context mContext, List<ResidentEnterpriseBean> list) {
		super(mContext, list);
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		if (convertView == null) {
			viewHolder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.adapter_resident_enterprise, parent, false);
			viewHolder.text_name = (TextView) convertView.findViewById(R.id.text_name);
			viewHolder.text_index = (TextView) convertView.findViewById(R.id.text_index);
			viewHolder.imageview = (ImageView) convertView.findViewById(R.id.imageview);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		final ResidentEnterpriseBean bean = (ResidentEnterpriseBean) getItem(position);
		if (bean != null) {
			viewHolder.text_name.setText(bean.getName());
			viewHolder.text_index.setText(bean.getCompanyindex());
			if (bean.getSrc() != null && bean.getSrc().length() > 0) {
				DisplayImageOptions options = new DisplayImageOptions.Builder().showStubImage(R.drawable.common_z).showImageForEmptyUri(R.drawable.common_z).showImageOnFail(R.drawable.common_z)
						.cacheInMemory().cacheOnDisc().build();
				ImageLoader.getInstance().displayImage(bean.getSrc(), viewHolder.imageview, options, getImageLoadingListener());
			}

			viewHolder.imageview.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					ZcoolWebViewActivity.startZcoolWebViewActivity(mContext, bean.getHref());
				}
			});
			viewHolder.text_name.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					ZcoolWebViewActivity.startZcoolWebViewActivity(mContext, bean.getHref());
				}
			});
			viewHolder.text_index.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					ZcoolWebViewActivity.startZcoolWebViewActivity(mContext, bean.getIndexhref());
				}
			});
			convertView.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					ZcoolWebViewActivity.startZcoolWebViewActivity(mContext, bean.getHref());
				}
			});

		}
		return convertView;
	}

	class ViewHolder {
		TextView text_name, text_index;
		ImageView imageview;
	}
}