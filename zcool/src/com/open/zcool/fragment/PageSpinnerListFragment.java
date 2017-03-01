/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-3-1下午2:38:16
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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import antistatic.spinnerwheel.AbstractWheel;
import antistatic.spinnerwheel.OnWheelChangedListener;
import antistatic.spinnerwheel.WheelVerticalView;

import com.open.android.fragment.BaseV4Fragment;
import com.open.zcool.R;
import com.open.zcool.adapter.PageSpinnerAdapter;
import com.open.zcool.bean.PageSpinnerBean;
import com.open.zcool.json.PageSpinnerJson;
import com.open.zcool.jsoup.ToSearchPageService;

/**
 ***************************************************************************************************************************************************************************** 
 * 
 * @author :fengguangjing
 * @createTime:2017-3-1下午2:38:16
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 ***************************************************************************************************************************************************************************** 
 */
public class PageSpinnerListFragment extends BaseV4Fragment<PageSpinnerJson, PageSpinnerListFragment> {
	public Button text_pre;
	public Button text_fisrt;
	public Button text_current;
	public Button text_last;
	public Button text_next;
	public WheelVerticalView wheel;
	public PageSpinnerAdapter mPageSpinnerAdapter;
	public List<PageSpinnerBean> list = new ArrayList<PageSpinnerBean>();
	
	public static PageSpinnerListFragment newInstance(String url, boolean isVisibleToUser) {
		PageSpinnerListFragment fragment = new PageSpinnerListFragment();
		fragment.setFragment(fragment);
		fragment.setUserVisibleHint(isVisibleToUser);
		fragment.url = url;
		return fragment;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_common_page_spinner, container, false);
		text_pre = (Button) view.findViewById(R.id.text_pre);
		text_fisrt = (Button) view.findViewById(R.id.text_fisrt);
		text_current = (Button) view.findViewById(R.id.text_current);
		text_last = (Button) view.findViewById(R.id.text_last);
		text_next = (Button) view.findViewById(R.id.text_next);
		wheel = (WheelVerticalView) view.findViewById(R.id.wheel);
		return view;
	}
	
	/* (non-Javadoc)
	 * @see com.open.android.fragment.BaseV4Fragment#initValues()
	 */
	@Override
	public void initValues() {
		// TODO Auto-generated method stub
		super.initValues();
	}
	
	/* (non-Javadoc)
	 * @see com.open.android.fragment.BaseV4Fragment#bindEvent()
	 */
	@Override
	public void bindEvent() {
		// TODO Auto-generated method stub
		super.bindEvent();
		wheel.addChangingListener(new OnWheelChangedListener() {
			@Override
			public void onChanged(AbstractWheel wheel, int oldValue, int newValue) {
				// TODO Auto-generated method stub
				Log.i(TAG, "oldValue="+oldValue+";newValue="+newValue);
				text_current.setText((newValue+1)+"");
			}
		});
	}
	
	
	/* (non-Javadoc)
	 * @see com.open.android.fragment.BaseV4Fragment#call()
	 */
	@Override
	public PageSpinnerJson call() throws Exception {
		// TODO Auto-generated method stub
		PageSpinnerJson mPageSpinnerJson = ToSearchPageService.parsePage(url);
		return mPageSpinnerJson;
	}

	/* (non-Javadoc)
	 * @see com.open.android.fragment.BaseV4Fragment#onCallback(java.lang.Object)
	 */
	@Override
	public void onCallback(PageSpinnerJson result) {
		// TODO Auto-generated method stub
		super.onCallback(result);
		list.clear();
		list.addAll(result.getList());
		mPageSpinnerAdapter = new PageSpinnerAdapter(getActivity(),list);
		wheel.setVisibleItems(5);
		wheel.setViewAdapter(mPageSpinnerAdapter);
		wheel.setCurrentItem(0);
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
