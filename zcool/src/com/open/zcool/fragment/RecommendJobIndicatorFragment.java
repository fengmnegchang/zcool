/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-4下午2:05:33
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.zcool.fragment;

import android.support.v4.app.Fragment;

import com.open.android.fragment.CommonV4Fragment;
import com.open.zcool.bean.OpenTabBean;
import com.open.zcool.json.OpenTabJson;
import com.open.zcool.jsoup.RecommendJobTabService;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-4下午2:05:33
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class RecommendJobIndicatorFragment extends OpenIndicatorFragment{
	
	public static RecommendJobIndicatorFragment newInstance(String url, boolean isVisibleToUser) {
		RecommendJobIndicatorFragment fragment = new RecommendJobIndicatorFragment();
		fragment.setFragment(fragment);
		fragment.setUserVisibleHint(isVisibleToUser);
		fragment.url = url;
		return fragment;
	}
	
	@Override
	public OpenTabJson call() throws Exception {
		// TODO Auto-generated method stub
		OpenTabJson mOpenTabJson = new OpenTabJson();
		mOpenTabJson.setList(RecommendJobTabService.parseOpenTab(url));
		return mOpenTabJson;
	}

	@Override
	public void onCallback(OpenTabJson result) {
		// TODO Auto-generated method stub
		list.clear();
		list.addAll(result.getList());
		titleList.clear();

		Fragment fragment;
		for (int i=0;i< result.getList().size();i++) {
			OpenTabBean bean = result.getList().get(i);
			titleList.add(bean.getTitle());
			if(i==0){
				fragment = RecommendJobPullListFragment.newInstance(bean.getHref(),true);
			}else{
				fragment = RecommendJobPullListFragment.newInstance(bean.getHref(),false);
			}
			listRankFragment.add(fragment);
		}
		mRankPagerAdapter.notifyDataSetChanged();
		indicator.notifyDataSetChanged();
		
		 
	}
}
