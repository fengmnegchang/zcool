/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-17下午2:54:24
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.zcool.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.open.zcool.R;
import com.open.zcool.fragment.WorksFootExpendListFragment;
import com.open.zcool.utils.UrlUtils;

/**
 ***************************************************************************************************************************************************************************** 
 * 作品底部推荐信息
 * 
 * @author :fengguangjing
 * @createTime:2017-2-17下午2:54:24
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 ***************************************************************************************************************************************************************************** 
 */
public class WorksFootExpendListFragmentActivity extends ZcoolCommonFragmentActivity {
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.enrz.activity.CommonFragmentActivity#initValue()
	 */
	@Override
	protected void initValue() {
		// TODO Auto-generated method stub
		if (getIntent().getStringExtra("URL") != null) {
			url = getIntent().getStringExtra("URL");
		} else {
			url = UrlUtils.ZCOOL_GUESS;
		}
		addfragment();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.android.activity.CommonFragmentActivity#addfragment()
	 */
	@Override
	public void addfragment() {
		// TODO Auto-generated method stub
		Fragment fragment = WorksFootExpendListFragment.newInstance(url, true);
		getSupportFragmentManager().beginTransaction().replace(R.id.id_common_fragment, fragment).commit();
	}

	public static void startWorksFootExpendListFragmentActivity(Context context, String url) {
		Intent intent = new Intent();
		intent.putExtra("URL", url);
		intent.setClass(context, WorksFootExpendListFragmentActivity.class);
		context.startActivity(intent);
	}

}
