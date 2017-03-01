/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-3-1下午3:03:54
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.zcool.adapter;

import java.util.List;

import android.content.Context;

import com.open.zcool.bean.PageSpinnerBean;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-3-1下午3:03:54
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class PageSpinnerAdapter extends CommonSpinnerAdapter<PageSpinnerBean>{

	public PageSpinnerAdapter(Context context, List<PageSpinnerBean> list) {
		super(context, list);
	}

	 @Override
     protected CharSequence getItemText(int index) {
         return list.get(index).getName();
     }
	 
}
