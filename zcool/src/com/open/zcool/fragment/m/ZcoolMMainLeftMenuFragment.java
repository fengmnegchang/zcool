/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-5-19下午2:44:33
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.zcool.fragment.m;

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
import com.open.zcool.adapter.m.MMainLeftMenuAdapter;
import com.open.zcool.bean.m.LeftMenuBean;
import com.open.zcool.json.m.LeftMenuJson;
import com.open.zcool.jsoup.m.MLeftMenuService;

/**
 ***************************************************************************************************************************************************************************** 
 * 
 * @author :fengguangjing
 * @createTime:2017-5-19下午2:44:33
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 ***************************************************************************************************************************************************************************** 
 */
public class ZcoolMMainLeftMenuFragment extends BaseV4Fragment<LeftMenuJson, ZcoolMMainLeftMenuFragment> {
	public PullToRefreshListView mPullToRefreshListView;
	public List<LeftMenuBean> list = new ArrayList<LeftMenuBean>();
	public MMainLeftMenuAdapter mMMainLeftMenuAdapter;

	public static ZcoolMMainLeftMenuFragment newInstance(String url, boolean isVisibleToUser) {
		ZcoolMMainLeftMenuFragment fragment = new ZcoolMMainLeftMenuFragment();
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
		mMMainLeftMenuAdapter = new MMainLeftMenuAdapter(getActivity(), list);
		mPullToRefreshListView.setAdapter(mMMainLeftMenuAdapter);
		mPullToRefreshListView.setMode(Mode.DISABLED);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.enrz.fragment.BaseV4Fragment#call()
	 */
	@Override
	public LeftMenuJson call() throws Exception {
		// TODO Auto-generated method stub
		LeftMenuJson mIndexMainJson = new LeftMenuJson();
		 mIndexMainJson.setList(MLeftMenuService.parseMenu(url));
		return mIndexMainJson;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.enrz.fragment.BaseV4Fragment#onCallback(java.lang.Object)
	 */
	@Override
	public void onCallback(LeftMenuJson result) {
		// TODO Auto-generated method stub
		super.onCallback(result);
		Log.i(TAG, "getMode ===" + mPullToRefreshListView.getCurrentMode());
		if (mPullToRefreshListView.getCurrentMode() == Mode.PULL_FROM_START) {
			list.clear();
			list.addAll(result.getList());
			pageNo = 1;
		} else {
			if (result.getList() != null && result.getList().size() > 0) {
				list.addAll(result.getList());
			}
		}
		mMMainLeftMenuAdapter.notifyDataSetChanged();
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
