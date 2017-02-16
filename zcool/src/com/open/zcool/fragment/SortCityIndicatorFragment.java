/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-16上午9:41:44
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.zcool.fragment;

import java.util.ArrayList;

import android.support.v4.app.Fragment;

import com.open.zcool.bean.DesignerTabBean;
import com.open.zcool.json.DesignerTabJson;

/**
 ***************************************************************************************************************************************************************************** 
 * 
 * @author :fengguangjing
 * @createTime:2017-2-16上午9:41:44
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 ***************************************************************************************************************************************************************************** 
 */
public class SortCityIndicatorFragment extends DesignerIndicatorFragment {

	public static SortCityIndicatorFragment newInstance(String url, boolean isVisibleToUser) {
		SortCityIndicatorFragment fragment = new SortCityIndicatorFragment();
		fragment.setFragment(fragment);
		fragment.setUserVisibleHint(isVisibleToUser);
		fragment.url = url;
		return fragment;
	}

	@Override
	public DesignerTabJson call() throws Exception {
		// TODO Auto-generated method stub
		DesignerTabJson mDesignerTabJson = new DesignerTabJson();
		ArrayList<DesignerTabBean> tlist = new ArrayList<DesignerTabBean>();
		DesignerTabBean tabBean = new DesignerTabBean();
		tabBean.setTitle("国内");
		tlist.add(tabBean);

		tabBean = new DesignerTabBean();
		tabBean.setTitle("境外");
		tlist.add(tabBean);
		mDesignerTabJson.setList(tlist);
		return mDesignerTabJson;
	}

	@Override
	public void onCallback(DesignerTabJson result) {
		// TODO Auto-generated method stub
		list.clear();
		list.addAll(result.getList());
		titleList.clear();

		Fragment fragment;
		for (int i = 0; i < result.getList().size(); i++) {
			DesignerTabBean bean = result.getList().get(i);
			titleList.add(bean.getTitle());
			if (i == 0) {
				fragment = SortCityFragment.newInstance(bean.getHref(), true);
			} else {
				fragment = SortCityFragment.newInstance(bean.getHref(), false);
			}
			listRankFragment.add(fragment);
		}
		mRankPagerAdapter.notifyDataSetChanged();
		indicator.notifyDataSetChanged();
	}
}
