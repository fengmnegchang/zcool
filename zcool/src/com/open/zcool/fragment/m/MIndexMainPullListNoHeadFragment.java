/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-5-19下午3:49:15
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.zcool.fragment.m;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.open.zcool.R;
import com.open.zcool.adapter.IndexMainListAdapter;
import com.open.zcool.fragment.IndexMainPullListFragment;
import com.open.zcool.json.IndexMainJson;
import com.open.zcool.jsoup.IndexMainListService;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-5-19下午3:49:15
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class MIndexMainPullListNoHeadFragment extends IndexMainPullListFragment {
	public static MIndexMainPullListNoHeadFragment newInstance(String url, boolean isVisibleToUser) {
		MIndexMainPullListNoHeadFragment fragment = new MIndexMainPullListNoHeadFragment();
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
		
		mIndexMainListAdapter = new IndexMainListAdapter(getActivity(), list);
		mPullToRefreshListView.setAdapter(mIndexMainListAdapter);
		mPullToRefreshListView.setMode(Mode.BOTH);
	}
	
	/* (non-Javadoc)
	 * @see com.open.enrz.fragment.BaseV4Fragment#call()
	 */
	@Override
	public IndexMainJson call() throws Exception {
		// TODO Auto-generated method stub
		IndexMainJson mIndexMainJson = new IndexMainJson();
		mIndexMainJson.setList(IndexMainListService.parseMIndexMain(url,pageNo));
		return mIndexMainJson;
	}

}
