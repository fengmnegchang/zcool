/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-4-6下午4:42:30
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.zcool.fragment;

import com.open.android.fragment.BaseV4Fragment;
import com.open.zcool.json.HotAuthorsJson;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-4-6下午4:42:30
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class MonthHotAuthorsListFragment extends BaseV4Fragment<HotAuthorsJson, MonthHotAuthorsListFragment>{
	
	public static MonthHotAuthorsListFragment newInstance(String url, boolean isVisibleToUser) {
		MonthHotAuthorsListFragment fragment = new MonthHotAuthorsListFragment();
		fragment.setFragment(fragment);
		fragment.setUserVisibleHint(isVisibleToUser);
		fragment.url = url;
		return fragment;
	}
	
}
