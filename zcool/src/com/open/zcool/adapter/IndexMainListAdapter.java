/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-3下午5:08:03
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
import android.text.method.LinkMovementMethod;
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
import com.open.zcool.bean.IndexMainBean;

/**
 ***************************************************************************************************************************************************************************** 
 * 
 * @author :fengguangjing
 * @createTime:2017-2-3下午5:08:03
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 ***************************************************************************************************************************************************************************** 
 */
public class IndexMainListAdapter extends CommonAdapter<IndexMainBean> {

	public IndexMainListAdapter(Context mContext, List<IndexMainBean> list) {
		super(mContext, list);
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		if (convertView == null) {
			viewHolder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.adapter_index_main_list, parent, false);
			viewHolder.text_camLiDes = (TextView) convertView.findViewById(R.id.text_camLiDes);
			viewHolder.imageview = (ImageView) convertView.findViewById(R.id.imageview);
			viewHolder.text_title = (TextView) convertView.findViewById(R.id.text_title);
			viewHolder.text_author = (TextView) convertView.findViewById(R.id.text_author);
			viewHolder.imageview2 = (ImageView) convertView.findViewById(R.id.imageview2);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		final IndexMainBean bean = (IndexMainBean) getItem(position);
		if (bean != null) {
			viewHolder.text_author.setText(bean.getAuthor());
			viewHolder.text_title.setText(bean.getTitle());
			viewHolder.text_camLiDes.setText(Html.fromHtml(bean.getCamLiDes()));
			viewHolder.text_camLiDes.setMovementMethod(LinkMovementMethod.getInstance());    
			if (bean.getSrc() != null && bean.getSrc().length() > 0) {
				DisplayImageOptions options = new DisplayImageOptions.Builder().showStubImage(R.drawable.common_z).showImageForEmptyUri(R.drawable.common_z).showImageOnFail(R.drawable.common_z)
						.cacheInMemory().cacheOnDisc().build();
				ImageLoader.getInstance().displayImage(bean.getSrc(), viewHolder.imageview, options, getImageLoadingListener());
			}
			if (bean.getAuthorIcons() != null && bean.getAuthorIcons().length() > 0) {
				DisplayImageOptions options = new DisplayImageOptions.Builder().showStubImage(R.drawable.common_z).showImageForEmptyUri(R.drawable.common_z).showImageOnFail(R.drawable.common_z)
						.cacheInMemory().cacheOnDisc().build();
				ImageLoader.getInstance().displayImage(bean.getAuthorIcons(), viewHolder.imageview2, options, getImageLoadingListener());
			}
			convertView.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					ZcoolWebViewActivity.startZcoolWebViewActivity(mContext, bean.getHref());
				}
			});
			viewHolder.imageview2.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					ZcoolWebViewActivity.startZcoolWebViewActivity(mContext, bean.getAuthorhref());
				}
			});
			viewHolder.text_author.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					ZcoolWebViewActivity.startZcoolWebViewActivity(mContext, bean.getAuthorhref());
				}
			});
		}
		return convertView;
	}

	class ViewHolder {
		TextView text_camLiDes;
		TextView text_title;
		TextView text_author;
		ImageView imageview;
		ImageView imageview2;
	}
}
