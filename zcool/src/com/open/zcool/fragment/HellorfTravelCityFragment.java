/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-3-1上午9:53:59
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
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.open.android.fragment.BaseV4Fragment;
import com.open.zcool.R;
import com.open.zcool.adapter.HellorfPagerAdapter;
import com.open.zcool.bean.HellorfSearchBean;
import com.open.zcool.json.ToSearchJson;
import com.open.zcool.jsoup.HellorfSearchService;

/**
 ***************************************************************************************************************************************************************************** 
 * 
 * @author :fengguangjing
 * @createTime:2017-3-1上午9:53:59
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 ***************************************************************************************************************************************************************************** 
 */
public class HellorfTravelCityFragment extends BaseV4Fragment<ToSearchJson, HellorfTravelCityFragment>  {
	public ViewPager mViewPager;
	public List<HellorfSearchBean> list = new ArrayList<HellorfSearchBean>();
	public HellorfPagerAdapter mHellorfPagerAdapter;

	public static HellorfTravelCityFragment newInstance(String url, boolean isVisibleToUser) {
		HellorfTravelCityFragment fragment = new HellorfTravelCityFragment();
		fragment.setFragment(fragment);
		fragment.setUserVisibleHint(isVisibleToUser);
		fragment.url = url;
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_hellorf_travel, container, false);
		mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
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
		mHellorfPagerAdapter = new HellorfPagerAdapter(getActivity(), list);
		mViewPager.setAdapter(mHellorfPagerAdapter);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.android.fragment.BaseV4Fragment#call()
	 */
	@Override
	public ToSearchJson call() throws Exception {
		// TODO Auto-generated method stub
		ToSearchJson mToSearchJson = new ToSearchJson();;
		mToSearchJson.setPagerlist(HellorfSearchService.parseTravel(url));
		return mToSearchJson;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.open.android.fragment.BaseV4Fragment#onCallback(java.lang.Object)
	 */
	@Override
	public void onCallback(ToSearchJson result) {
		// TODO Auto-generated method stub
		list.clear();
		list.addAll(result.getPagerlist());
		mHellorfPagerAdapter.notifyDataSetChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.tencenttv.BaseV4Fragment#handlerMessage(android.os.Message)
	 */
	@Override
	public void handlerMessage(Message msg) {
		// TODO Auto-generated method stub
		super.handlerMessage(msg);
		switch (msg.what) {
		case MESSAGE_HANDLER:
			doAsync(this, this, this);
			break;
		default:
			break;
		}
	}

}
