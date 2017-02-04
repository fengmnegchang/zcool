/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-4上午10:34:54
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.zcool.fragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.open.android.fragment.BaseV4Fragment;
import com.open.zcool.R;
import com.open.zcool.adapter.DesignerAdapter;
import com.open.zcool.bean.DesignerBean;
import com.open.zcool.json.DesignerJson;
import com.open.zcool.jsoup.DesignerService;

/**
 ***************************************************************************************************************************************************************************** 
 * 
 * @author :fengguangjing
 * @createTime:2017-2-4上午10:34:54
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 ***************************************************************************************************************************************************************************** 
 */
public class DesignerListFragment extends BaseV4Fragment<DesignerJson, DesignerListFragment> {
	public List<DesignerBean> list = new ArrayList<DesignerBean>();
	public DesignerAdapter mDesignerAdapter;
	public PullToRefreshListView mPullToRefreshListView;

	public static DesignerListFragment newInstance(String url, boolean isVisibleToUser) {
		DesignerListFragment fragment = new DesignerListFragment();
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
		super.initValues();
		mDesignerAdapter = new DesignerAdapter(getActivity(), list);
		mPullToRefreshListView.setAdapter(mDesignerAdapter);
		mPullToRefreshListView.setMode(Mode.DISABLED);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.enrz.fragment.BaseV4Fragment#call()
	 */
	@Override
	public DesignerJson call() throws Exception {
		// TODO Auto-generated method stub
		DesignerJson mDesignerJson = new DesignerJson();
		mDesignerJson.setList(DesignerService.parseDesigner(url));
		return mDesignerJson;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.enrz.fragment.BaseV4Fragment#onCallback(java.lang.Object)
	 */
	@Override
	public void onCallback(DesignerJson result) {
		// TODO Auto-generated method stub
		super.onCallback(result);
		Log.i(TAG, "getMode ===" + mPullToRefreshListView.getCurrentMode());
		list.clear();
		list.addAll(result.getList());
		pageNo = 1;

		mDesignerAdapter.notifyDataSetChanged();
		// Call onRefreshComplete when the list has been refreshed.
		mPullToRefreshListView.onRefreshComplete();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.open.enrz.fragment.BaseV4Fragment#handlerMessage(android.os.Message)
	 */
	@Override
	public void handlerMessage(Message msg) {
		// TODO Auto-generated method stub
		switch (msg.what) {
		case MESSAGE_HANDLER:
			doAsync(this, this, this);
			break;
		default:
			break;
		}
	}
}
