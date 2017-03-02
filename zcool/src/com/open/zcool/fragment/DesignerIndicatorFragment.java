/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-4上午10:59:02
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
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.open.android.adapter.CommonFragmentPagerAdapter;
import com.open.android.fragment.BaseV4Fragment;
import com.open.indicator.TabPageIndicator;
import com.open.zcool.R;
import com.open.zcool.bean.DesignerTabBean;
import com.open.zcool.json.DesignerTabJson;
import com.open.zcool.jsoup.DesignerService;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-4上午10:59:02
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class DesignerIndicatorFragment extends BaseV4Fragment<DesignerTabJson, DesignerIndicatorFragment> {
	public ArrayList<DesignerTabBean> list = new ArrayList<DesignerTabBean>();
	public ViewPager viewpager;
	public TabPageIndicator indicator;
	public List<String> titleList = new ArrayList<String>();
	public List<Fragment> listRankFragment = new ArrayList<Fragment>();// view数组
	public CommonFragmentPagerAdapter mRankPagerAdapter;

	public static DesignerIndicatorFragment newInstance(String url, boolean isVisibleToUser) {
		DesignerIndicatorFragment fragment = new DesignerIndicatorFragment();
		fragment.setFragment(fragment);
		fragment.setUserVisibleHint(isVisibleToUser);
		fragment.url = url;
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_common_indicator_viewpager, container, false);
		viewpager = (ViewPager) view.findViewById(R.id.viewpager);
		indicator = (TabPageIndicator) view.findViewById(R.id.indicator);
		return view;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.qianbailu.fragment.BaseV4Fragment#initValues()
	 */
	@Override
	public void initValues() {
		// TODO Auto-generated method stub
		super.initValues();
		mRankPagerAdapter = new CommonFragmentPagerAdapter(getChildFragmentManager(), listRankFragment, titleList);
		viewpager.setAdapter(mRankPagerAdapter);
		indicator.setViewPager(viewpager);
	}

	@Override
	public DesignerTabJson call() throws Exception {
		// TODO Auto-generated method stub
		DesignerTabJson mDesignerTabJson = new DesignerTabJson();
		mDesignerTabJson.setList(DesignerService.parseDesignerTab(url));
		return mDesignerTabJson;
	}

	@Override
	public void onCallback(DesignerTabJson result) {
		// TODO Auto-generated method stub
		super.onCallback(result);
		list.clear();
		list.addAll(result.getList());
		titleList.clear();

		Fragment fragment;
		for (int i=0;i< result.getList().size();i++) {
			DesignerTabBean bean = result.getList().get(i);
			titleList.add(bean.getTitle());
			if(i==0){
				fragment = DesignerListFragment.newInstance(bean.getHref(),true,i);
			}else{
				fragment = DesignerListFragment.newInstance(bean.getHref(),false,i);
			}
			listRankFragment.add(fragment);
		}
		mRankPagerAdapter.notifyDataSetChanged();
		indicator.notifyDataSetChanged();
		
		 
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.tencenttv.BaseV4Fragment#handlerMessage(android.os.Message)
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
