/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-3-1下午4:53:03
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.zcool.fragment;

import android.support.v4.app.Fragment;

import com.open.zcool.bean.DesignerTabBean;
import com.open.zcool.json.DesignerTabJson;
import com.open.zcool.jsoup.ToSearchMainTabService;

/**
 ***************************************************************************************************************************************************************************** 
 * 
 * @author :fengguangjing
 * @createTime:2017-3-1下午4:53:03
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 ***************************************************************************************************************************************************************************** 
 */
public class ToSearchMainIndicatorFragment extends DesignerIndicatorFragment {

	public static ToSearchMainIndicatorFragment newInstance(String url, boolean isVisibleToUser) {
		ToSearchMainIndicatorFragment fragment = new ToSearchMainIndicatorFragment();
		fragment.setFragment(fragment);
		fragment.setUserVisibleHint(isVisibleToUser);
		fragment.url = url;
		return fragment;
	}

	@Override
	public DesignerTabJson call() throws Exception {
		// TODO Auto-generated method stub
		DesignerTabJson mDesignerTabJson = new DesignerTabJson();
		mDesignerTabJson.setList(ToSearchMainTabService.parseDesignerTab(url));
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
			if (bean.getTitle().contains("正版图片")) {
				fragment = CommonWebViewFragment.newInstance(bean.getHref(), false);
			} else if (bean.getTitle().contains("全站")) {
				fragment = ToSearchMainPullListFragment.newInstance(bean.getHref(), i, true);
			} else if (bean.getTitle().contains("设计师")) {
				fragment = ToSearchPageDesignerMainPullListFragment.newInstance(bean.getHref(), i, false);
			} else {
				fragment = ToSearchMainPullListFragment.newInstance(bean.getHref(), i, false);
			}
			listRankFragment.add(fragment);
		}
		mRankPagerAdapter.notifyDataSetChanged();
		indicator.notifyDataSetChanged();
	}
}
