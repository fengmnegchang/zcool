/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-4上午9:37:22
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.zcool.widget;

import android.content.Context;
import android.text.style.ClickableSpan;
import android.view.View;

import com.open.zcool.activity.ZcoolWebViewActivity;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-4上午9:37:22
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class OpenClickableSpan extends ClickableSpan {
	private String url;  
	private Context context;
	
	public OpenClickableSpan(Context context,String url){
		this.context = context;
		this.url = url;
	}
	
	/* (non-Javadoc)
	 * @see android.text.style.ClickableSpan#onClick(android.view.View)
	 */
	@Override
	public void onClick(View widget) {
		ZcoolWebViewActivity.startZcoolWebViewActivity(context, url);
	}

}
