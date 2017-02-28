/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-3下午5:20:42
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.zcool.fragment;

import com.open.zcool.json.IndexMainJson;
import com.open.zcool.jsoup.IndexMainListService;

/**
 ***************************************************************************************************************************************************************************** 
 *  作品主列表
 * @author :fengguangjing
 * @createTime:2017-2-3下午5:20:42
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 ***************************************************************************************************************************************************************************** 
 */
public class WorksMainPullListFragment extends IndexMainPullListFragment {
	 

	public static WorksMainPullListFragment newInstance(String url, boolean isVisibleToUser) {
		WorksMainPullListFragment fragment = new WorksMainPullListFragment();
		fragment.setFragment(fragment);
		fragment.setUserVisibleHint(isVisibleToUser);
		fragment.url = url;
		return fragment;
	}

  

	/* (non-Javadoc)
	 * @see com.open.enrz.fragment.BaseV4Fragment#call()
	 */
	@Override
	public IndexMainJson call() throws Exception {
		// TODO Auto-generated method stub
		IndexMainJson mIndexMainJson = new IndexMainJson();
		mIndexMainJson.setList(IndexMainListService.parseIndexMain(url,pageNo));
		return mIndexMainJson;
	}
	 
}
