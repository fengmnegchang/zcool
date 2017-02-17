/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-17下午3:15:45
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.zcool.fragment;

import com.open.zcool.json.IndexFocusJson;
import com.open.zcool.jsoup.EnterpriseService;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-17下午3:15:45
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class EnterpriseHeadViewPagerFragment extends CommonPagerFragment {
	public static EnterpriseHeadViewPagerFragment newInstance(String url, boolean isVisibleToUser) {
		EnterpriseHeadViewPagerFragment fragment = new EnterpriseHeadViewPagerFragment();
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
		mIndexFocusJson.setList(EnterpriseService.parseIndexFocus(url));
		return mIndexFocusJson;
	}
}
