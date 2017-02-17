/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-17下午4:25:32
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.zcool.fragment;

import com.open.android.fragment.BaseV4Fragment;
import com.open.zcool.json.EnterpriseMainJson;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-17下午4:25:32
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class EnterpriseMainListFragment extends BaseV4Fragment<EnterpriseMainJson, EnterpriseMainListFragment>{

	public static EnterpriseMainListFragment newInstance(String url, boolean isVisibleToUser) {
		EnterpriseMainListFragment fragment = new EnterpriseMainListFragment();
		fragment.setFragment(fragment);
		fragment.setUserVisibleHint(isVisibleToUser);
		fragment.url = url;
		return fragment;
	}
	
}
