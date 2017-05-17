/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-5-17下午3:07:13
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
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.handmark.pulltorefresh.library.HeaderGridView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshHeadGridView;
import com.open.android.fragment.BaseV4Fragment;
import com.open.zcool.R;
import com.open.zcool.adapter.HellorfSearchGridAdapter;
import com.open.zcool.bean.HellorfSearchBean;
import com.open.zcool.json.HellorfSearchJson;
import com.open.zcool.jsoup.HellorfSearchService;

/**
 ***************************************************************************************************************************************************************************** 
 * 
 * @author :fengguangjing
 * @createTime:2017-5-17下午3:07:13
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 ***************************************************************************************************************************************************************************** 
 */
public class HellorfSearchGridFragment extends BaseV4Fragment<HellorfSearchJson, HellorfSearchGridFragment>implements OnRefreshListener<HeaderGridView> {
	public List<HellorfSearchBean> list = new ArrayList<HellorfSearchBean>();
	public HellorfSearchGridAdapter mHellorfSearchGridAdapter;
	public PullToRefreshHeadGridView mPullToRefreshGridView;
	
	public static HellorfSearchGridFragment newInstance(String url, boolean isVisibleToUser) {
		HellorfSearchGridFragment fragment = new HellorfSearchGridFragment();
		fragment.setFragment(fragment);
		fragment.setUserVisibleHint(isVisibleToUser);
		fragment.url = url;
		return fragment;
	}
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_common_pullgridview, container, false);
		mPullToRefreshGridView = (PullToRefreshHeadGridView) view.findViewById(R.id.pull_refresh_grid);
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
		mHellorfSearchGridAdapter = new HellorfSearchGridAdapter(getActivity(), list);
		mPullToRefreshGridView.setAdapter(mHellorfSearchGridAdapter);
		mPullToRefreshGridView.setMode(Mode.BOTH);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.enrz.fragment.BaseV4Fragment#bindEvent()
	 */
	@Override
	public void bindEvent() {
		// TODO Auto-generated method stub
		mPullToRefreshGridView.setOnRefreshListener(this);
	}

	/* (non-Javadoc)
	 * @see com.open.enrz.fragment.BaseV4Fragment#call()
	 */
	@Override
	public HellorfSearchJson call() throws Exception {
		// TODO Auto-generated method stub
		HellorfSearchJson mHellorfSearchJson = new HellorfSearchJson();
		mHellorfSearchJson.setList(HellorfSearchService.parseSearchGrid(url, pageNo));
		return mHellorfSearchJson;
	}

	/* (non-Javadoc)
	 * @see com.open.enrz.fragment.BaseV4Fragment#onCallback(java.lang.Object)
	 */
	@Override
	public void onCallback(HellorfSearchJson result) {
		// TODO Auto-generated method stub
		Log.i(TAG, "getMode ===" + mPullToRefreshGridView.getCurrentMode());
		if (mPullToRefreshGridView.getCurrentMode() == Mode.PULL_FROM_START) {
			list.clear();
			list.addAll(result.getList());
			pageNo = 1;
		} else {
			if (result.getList() != null && result.getList().size() > 0) {
				list.addAll(result.getList());
			}
		}
		mHellorfSearchGridAdapter.notifyDataSetChanged();
		// Call onRefreshComplete when the list has been refreshed.
		mPullToRefreshGridView.onRefreshComplete();
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener
	 * #onRefresh(com.handmark.pulltorefresh.library.PullToRefreshBase)
	 */
	@Override
	public void onRefresh(PullToRefreshBase<HeaderGridView> refreshView) {
		String label = DateUtils.formatDateTime(getActivity(), System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);
		// Update the LastUpdatedLabel
		refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(label);
		// Do work to refresh the list here.
		if (mPullToRefreshGridView.getCurrentMode() == Mode.PULL_FROM_START) {
			pageNo = 1;
			weakReferenceHandler.sendEmptyMessage(MESSAGE_HANDLER);
		} else if (mPullToRefreshGridView.getCurrentMode() == Mode.PULL_FROM_END) {
			pageNo++;
			weakReferenceHandler.sendEmptyMessage(MESSAGE_HANDLER);
		}
	}
	
}
