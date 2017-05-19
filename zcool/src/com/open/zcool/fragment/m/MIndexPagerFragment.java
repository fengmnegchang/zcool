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
package com.open.zcool.fragment.m;

import com.open.zcool.fragment.CommonPagerFragment;
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
public class MIndexPagerFragment extends CommonPagerFragment {

	public static MIndexPagerFragment newInstance(String url, boolean isVisibleToUser) {
		MIndexPagerFragment fragment = new MIndexPagerFragment();
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
		mIndexFocusJson.setList(IndexFocusService.parseMIndex(url));
		return mIndexFocusJson;
	}

}