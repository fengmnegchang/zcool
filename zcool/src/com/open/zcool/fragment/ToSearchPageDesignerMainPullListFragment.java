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

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.open.zcool.R;
import com.open.zcool.adapter.ToSearchMainListAdapter;
import com.open.zcool.json.ToSearchMainJson;
import com.open.zcool.jsoup.ToSearchMainListService;

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
public class ToSearchPageDesignerMainPullListFragment extends ToSearchMainPullListFragment {

	public static ToSearchPageDesignerMainPullListFragment newInstance(String url, int page, boolean isVisibleToUser) {
		ToSearchPageDesignerMainPullListFragment fragment = new ToSearchPageDesignerMainPullListFragment();
		fragment.setFragment(fragment);
		fragment.setUserVisibleHint(isVisibleToUser);
		fragment.url = url;
		fragment.page = page;
		return fragment;
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_common_pulllistview, container, false);
		mPullToRefreshListView = (PullToRefreshListView) view.findViewById(R.id.pull_refresh_list);
		headview = LayoutInflater.from(getActivity()).inflate(R.layout.layout_search_post_head, null);
		return view;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.android.fragment.BaseV4Fragment#initValues()
	 */
	@Override
	public void initValues() {
		// TODO Auto-generated method stub
		mPullToRefreshListView.getRefreshableView().addHeaderView(headview);
		Fragment hfragment = ToSearchPageDesignerMainMenuHeadFragment.newInstance(weakReferenceHandler, url, true);
		getChildFragmentManager().beginTransaction().replace(R.id.id_search_post_head, hfragment).commit();

		mToSearchMainListAdapter = new ToSearchMainListAdapter(getActivity(), list);
		mPullToRefreshListView.setAdapter(mToSearchMainListAdapter);
		mPullToRefreshListView.setMode(Mode.BOTH);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.enrz.fragment.BaseV4Fragment#call()
	 */
	@Override
	public ToSearchMainJson call() throws Exception {
		// TODO Auto-generated method stub
		ToSearchMainJson mToSearchMainJson = new ToSearchMainJson();
		mToSearchMainJson.setList(ToSearchMainListService.parseDesignerMain(url, pageNo));
		return mToSearchMainJson;
	}

}
