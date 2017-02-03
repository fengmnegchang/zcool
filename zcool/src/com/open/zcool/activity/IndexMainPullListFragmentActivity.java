/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-3下午5:18:16
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
import com.open.zcool.fragment.IndexMainPullListFragment;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-3下午5:18:16
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class IndexMainPullListFragmentActivity extends ZcoolCommonFragmentActivity{
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.android.activity.CommonFragmentActivity#addfragment()
	 */
	@Override
	public void addfragment() {
		// TODO Auto-generated method stub
		Fragment fragment = IndexMainPullListFragment.newInstance(url, true);
		getSupportFragmentManager().beginTransaction().replace(R.id.id_common_fragment, fragment).commit();
	}

	public static void startIndexMainPullListFragmentActivity(Context context, String url) {
		Intent intent = new Intent();
		intent.putExtra("URL", url);
		intent.setClass(context, IndexMainPullListFragmentActivity.class);
		context.startActivity(intent);
	}
}
