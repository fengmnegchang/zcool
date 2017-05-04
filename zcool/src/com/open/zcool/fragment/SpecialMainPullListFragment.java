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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.open.zcool.R;
import com.open.zcool.adapter.IndexMainListAdapter;
import com.open.zcool.json.IndexMainJson;
import com.open.zcool.jsoup.IndexMainListService;

/**
 ***************************************************************************************************************************************************************************** 
 *  
 * 
 * @author :fengguangjing
 * @createTime:2017-2-3下午5:20:42
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 ***************************************************************************************************************************************************************************** 
 */
public class SpecialMainPullListFragment extends IndexMainPullListFragment {
//	private View headview;
//	public NewestCommentMainListAdapter mIndexMainListAdapter;
	public static SpecialMainPullListFragment newInstance(String url, boolean isVisibleToUser) {
		SpecialMainPullListFragment fragment = new SpecialMainPullListFragment();
		fragment.setFragment(fragment);
		fragment.setUserVisibleHint(isVisibleToUser);
		fragment.url = url;
		return fragment;
	} 

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_common_pulllistview, container, false);
		mPullToRefreshListView = (PullToRefreshListView) view.findViewById(R.id.pull_refresh_list);
//		headview = LayoutInflater.from(getActivity()).inflate(R.layout.layout_search_post_head, null);
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
//		mPullToRefreshListView.getRefreshableView().addHeaderView(headview);
//		Fragment hfragment = ToSearchMainMenuHeadFragment.newInstance(weakReferenceHandler, url, true);
//		getChildFragmentManager().beginTransaction().replace(R.id.id_search_post_head, hfragment).commit();

		mIndexMainListAdapter = new IndexMainListAdapter(getActivity(), list);
		mPullToRefreshListView.setAdapter(mIndexMainListAdapter);
		mPullToRefreshListView.setMode(Mode.BOTH);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.enrz.fragment.BaseV4Fragment#call()
	 */
	@Override
	public IndexMainJson call() throws Exception {
		// TODO Auto-generated method stub
		IndexMainJson mIndexMainJson = new IndexMainJson();
		mIndexMainJson.setList(IndexMainListService.parseSpecial(url, pageNo));
		return mIndexMainJson;
	}
//	/* (non-Javadoc)
//	 * @see com.open.enrz.fragment.BaseV4Fragment#onCallback(java.lang.Object)
//	 */
//	@Override
//	public void onCallback(IndexMainJson result) {
//		// TODO Auto-generated method stub
//		Log.i(TAG, "getMode ===" + mPullToRefreshListView.getCurrentMode());
//		if (mPullToRefreshListView.getCurrentMode() == Mode.PULL_FROM_START) {
//			list.clear();
//			list.addAll(result.getList());
//			pageNo = 1;
//		} else {
//			if (result.getList() != null && result.getList().size() > 0) {
//				list.addAll(result.getList());
//			}
//		}
//		mIndexMainListAdapter.notifyDataSetChanged();
//		// Call onRefreshComplete when the list has been refreshed.
//		mPullToRefreshListView.onRefreshComplete();
//	}

}
