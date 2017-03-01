/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-3-1上午11:06:29
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
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
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
import com.open.zcool.bean.ToSearchMainBean;
import com.open.zcool.widget.OpenClickableSpan;

/**
 ***************************************************************************************************************************************************************************** 
 * 
 * @author :fengguangjing
 * @createTime:2017-3-1上午11:06:29
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 ***************************************************************************************************************************************************************************** 
 */
public class ToSearchMainListAdapter extends CommonAdapter<ToSearchMainBean> {

	public ToSearchMainListAdapter(Context mContext, List<ToSearchMainBean> list) {
		super(mContext, list);
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		if (convertView == null) {
			viewHolder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.adapter_to_search_main_list, parent, false);
			viewHolder.text_caaa = (TextView) convertView.findViewById(R.id.text_caaa);
			viewHolder.imageview = (ImageView) convertView.findViewById(R.id.imageview);
			viewHolder.text_title = (TextView) convertView.findViewById(R.id.text_title);
			viewHolder.text_blackLink = (TextView) convertView.findViewById(R.id.text_blackLink);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		final ToSearchMainBean bean = (ToSearchMainBean) getItem(position);
		if (bean != null) {
			viewHolder.text_caaa.setText(bean.getCaaa());
			viewHolder.text_title.setText(bean.getTitle());
			viewHolder.text_blackLink.setText(Html.fromHtml(bean.getBlackLink()));
			viewHolder.text_blackLink.setMovementMethod(LinkMovementMethod.getInstance());
			CharSequence text = viewHolder.text_blackLink.getText();
			if (text instanceof Spannable) {
				int end = text.length();
				Spannable sp = (Spannable) viewHolder.text_blackLink.getText();
				URLSpan[] urls = sp.getSpans(0, end, URLSpan.class);
				SpannableStringBuilder style = new SpannableStringBuilder(text);
				style.clearSpans();// should clear old spans
				for (URLSpan url : urls) {
					OpenClickableSpan openClickableSpan = new OpenClickableSpan(mContext, url.getURL());
					style.setSpan(openClickableSpan, sp.getSpanStart(url), sp.getSpanEnd(url), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
				}
				viewHolder.text_blackLink.setText(style);
			}

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
		TextView text_blackLink;
		TextView text_title;
		TextView text_caaa;
		ImageView imageview;
	}
}