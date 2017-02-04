/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-4上午10:05:20
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.zcool.adapter;

import java.util.List;

import android.content.Context;
import android.text.Html;
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
import com.open.zcool.bean.DesignerBean;

/**
 ***************************************************************************************************************************************************************************** 
 * 
 * @author :fengguangjing
 * @createTime:2017-2-4上午10:05:20
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 ***************************************************************************************************************************************************************************** 
 */
public class DesignerAdapter extends CommonAdapter<DesignerBean> {

	public DesignerAdapter(Context mContext, List<DesignerBean> list) {
		super(mContext, list);
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		if (convertView == null) {
			viewHolder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.adapter_designer, parent, false);
			viewHolder.text_pRight = (TextView) convertView.findViewById(R.id.text_pRight);
			viewHolder.imageview = (ImageView) convertView.findViewById(R.id.imageview);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		final DesignerBean bean = (DesignerBean) getItem(position);
		if (bean != null) {
			viewHolder.text_pRight.setText(Html.fromHtml(bean.getpRight()));
			if (bean.getSrc() != null && bean.getSrc().length() > 0) {
				DisplayImageOptions options = new DisplayImageOptions.Builder().showStubImage(R.drawable.common_z).showImageForEmptyUri(R.drawable.common_z).showImageOnFail(R.drawable.common_z)
						.cacheInMemory().cacheOnDisc().build();
				ImageLoader.getInstance().displayImage(bean.getSrc(), viewHolder.imageview, options, getImageLoadingListener());
			}

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
		TextView text_pRight;
		ImageView imageview;
	}
}
