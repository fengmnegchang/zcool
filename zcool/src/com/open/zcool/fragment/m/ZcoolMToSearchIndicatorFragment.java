/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-5-23上午10:08:28
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.zcool.fragment.m;

import android.support.v4.app.Fragment;

import com.open.zcool.bean.DesignerTabBean;
import com.open.zcool.fragment.DesignerIndicatorFragment;
import com.open.zcool.json.DesignerTabJson;
import com.open.zcool.jsoup.ToSearchMainTabService;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-5-23上午10:08:28
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class ZcoolMToSearchIndicatorFragment  extends DesignerIndicatorFragment {

	public static ZcoolMToSearchIndicatorFragment newInstance(String url, boolean isVisibleToUser) {
		ZcoolMToSearchIndicatorFragment fragment = new ZcoolMToSearchIndicatorFragment();
		fragment.setFragment(fragment);
		fragment.setUserVisibleHint(isVisibleToUser);
		fragment.url = url;
		return fragment;
	}

	@Override
	public DesignerTabJson call() throws Exception {
		// TODO Auto-generated method stub
		DesignerTabJson mDesignerTabJson = new DesignerTabJson();
		mDesignerTabJson.setList(ToSearchMainTabService.parseMSearchTab(url));
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
				fragment = MToSearchFragment.newInstance(bean.getHref(),i, true);
			}else {
				fragment = MToSearchFragment.newInstance(bean.getHref(),i, false);
			}
			listRankFragment.add(fragment);
		}
		mRankPagerAdapter.notifyDataSetChanged();
		indicator.notifyDataSetChanged();
	}
}