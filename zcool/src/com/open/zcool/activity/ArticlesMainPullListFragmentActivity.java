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
import com.open.zcool.fragment.ArticlesMainPullListFragment;
import com.open.zcool.utils.UrlUtils;

/**
 ***************************************************************************************************************************************************************************** 
 * 文章主列表
 * 
 * @author :fengguangjing
 * @createTime:2017-2-17下午2:54:24
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 ***************************************************************************************************************************************************************************** 
 */
public class ArticlesMainPullListFragmentActivity extends ZcoolCommonFragmentActivity {
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
			url = UrlUtils.ZCOOL_ARTICLES;
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
		Fragment fragment = ArticlesMainPullListFragment.newInstance(url, true);
		getSupportFragmentManager().beginTransaction().replace(R.id.id_common_fragment, fragment).commit();
	}

	public static void startArticlesMainPullListFragmentActivity(Context context, String url) {
		Intent intent = new Intent();
		intent.putExtra("URL", url);
		intent.setClass(context, ArticlesMainPullListFragmentActivity.class);
		context.startActivity(intent);
	}

}
