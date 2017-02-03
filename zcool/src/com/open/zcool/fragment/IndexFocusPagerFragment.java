/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-3下午4:37:08
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.zcool.fragment;

import com.open.zcool.json.IndexFocusJson;
import com.open.zcool.jsoup.IndexFocusService;

/**
 ***************************************************************************************************************************************************************************** 
 * 
 * @author :fengguangjing
 * @createTime:2017-2-3下午4:37:08
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 ***************************************************************************************************************************************************************************** 
 */
public class IndexFocusPagerFragment extends CommonPagerFragment {

	public static IndexFocusPagerFragment newInstance(String url, boolean isVisibleToUser) {
		IndexFocusPagerFragment fragment = new IndexFocusPagerFragment();
		fragment.setFragment(fragment);
		fragment.setUserVisibleHint(isVisibleToUser);
		fragment.url = url;
		return fragment;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.enrz.fragment.BaseV4Fragment#call()
	 */
	@Override
	public IndexFocusJson call() throws Exception {
		// TODO Auto-generated method stub
		IndexFocusJson mIndexFocusJson = new IndexFocusJson();
		mIndexFocusJson.setList(IndexFocusService.parseIndexFocus(url));
		return mIndexFocusJson;
	}

}