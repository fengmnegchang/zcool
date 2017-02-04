/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-4上午11:24:24
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
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.open.android.adapter.CommonAdapter;
import com.open.zcool.R;
import com.open.zcool.activity.ZcoolWebViewActivity;
import com.open.zcool.adapter.DesignerAdapter.ViewHolder;
import com.open.zcool.bean.DesignerBean;
import com.open.zcool.bean.RecommendJobBean;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-4上午11:24:24
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class RecommendJobAdapter extends CommonAdapter<RecommendJobBean> {

	public RecommendJobAdapter(Context mContext, List<RecommendJobBean> list) {
		super(mContext, list);
	}
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		if (convertView == null) {
			viewHolder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.adapter_recommend_job, parent, false);
			viewHolder.text_job_body_left = (TextView) convertView.findViewById(R.id.text_job_body_left);
			viewHolder.imageview = (ImageView) convertView.findViewById(R.id.imageview);
			viewHolder.text_pic_box = (TextView) convertView.findViewById(R.id.text_pic_box);
			viewHolder.text_slogn = (TextView) convertView.findViewById(R.id.text_slogn);
			viewHolder.text_tags = (TextView) convertView.findViewById(R.id.text_tags);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		final RecommendJobBean bean = (RecommendJobBean) getItem(position);
		if (bean != null) {
			if (bean.getPic_box_src() != null && bean.getPic_box_src().length() > 0) {
				DisplayImageOptions options = new DisplayImageOptions.Builder().showStubImage(R.drawable.common_z).showImageForEmptyUri(R.drawable.common_z).showImageOnFail(R.drawable.common_z)
						.cacheInMemory().cacheOnDisc().build();
				ImageLoader.getInstance().displayImage(bean.getPic_box_src(), viewHolder.imageview, options, getImageLoadingListener());
			}
			viewHolder.text_tags.setText(Html.fromHtml(bean.getTags()));
			viewHolder.text_slogn.setText(bean.getSlogn());
			viewHolder.text_pic_box.setText(Html.fromHtml(bean.getPic_box()));
			viewHolder.text_job_body_left.setText(Html.fromHtml(bean.getJob_body_left()));
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
		TextView text_job_body_left;
		TextView text_pic_box;
		TextView text_slogn;
		TextView text_tags;
		ImageView imageview;
	}
}
