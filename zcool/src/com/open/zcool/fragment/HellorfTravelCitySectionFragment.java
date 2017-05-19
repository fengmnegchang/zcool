/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-5-19上午10:14:14
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.zcool.fragment;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.open.android.fragment.BaseV4Fragment;
import com.open.zcool.R;
import com.open.zcool.adapter.TravelPinnedSectionListAdapter;
import com.open.zcool.bean.TravelCityBean;
import com.open.zcool.json.TravelGroupJson;
import com.open.zcool.jsoup.TravelService;
import com.open.zcool.widget.PinnedSectionListView;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-5-19上午10:14:14
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class HellorfTravelCitySectionFragment extends BaseV4Fragment<TravelGroupJson, HellorfTravelCitySectionFragment>{
	PinnedSectionListView mPinnedSectionListView;
	List<TravelCityBean> list = new ArrayList<TravelCityBean>();
	TravelPinnedSectionListAdapter mTravelPinnedSectionListAdapter;
	
	public static HellorfTravelCitySectionFragment newInstance(String url, boolean isVisibleToUser) {
		HellorfTravelCitySectionFragment fragment = new HellorfTravelCitySectionFragment();
		fragment.setFragment(fragment);
		fragment.setUserVisibleHint(isVisibleToUser);
		fragment.url = url;
		return fragment;
	}
	
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_hellorf_travel_city, container, false);
		mPinnedSectionListView = (PinnedSectionListView) view.findViewById(R.id.sectionlist);
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
		mTravelPinnedSectionListAdapter = new TravelPinnedSectionListAdapter(getActivity(), list);
		mPinnedSectionListView.setAdapter(mTravelPinnedSectionListAdapter);
//		if (savedInstanceState != null) {
//		    isFastScroll = savedInstanceState.getBoolean("isFastScroll");
//		    addPadding = savedInstanceState.getBoolean("addPadding");
//		    isShadowVisible = savedInstanceState.getBoolean("isShadowVisible");
//		    hasHeaderAndFooter = savedInstanceState.getBoolean("hasHeaderAndFooter");
//		}
		initializeHeaderAndFooter();
		initializeAdapter();
		initializePadding();
	}

	private void initializePadding() {
	    float density = getResources().getDisplayMetrics().density;
	    int padding = addPadding ? (int) (16 * density) : 0;
	    mPinnedSectionListView.setPadding(padding, padding, padding, padding);
	}

    private void initializeHeaderAndFooter() {
//        setListAdapter(null);
    	mPinnedSectionListView.setAdapter(null);
        if (hasHeaderAndFooter) {
//            ListView list = getListView();

            LayoutInflater inflater = LayoutInflater.from(getActivity());
            TextView header1 = (TextView) inflater.inflate(android.R.layout.simple_list_item_1, mPinnedSectionListView, false);
            header1.setText("First header");
            mPinnedSectionListView.addHeaderView(header1);

            TextView header2 = (TextView) inflater.inflate(android.R.layout.simple_list_item_1, mPinnedSectionListView, false);
            header2.setText("Second header");
            mPinnedSectionListView.addHeaderView(header2);

            TextView footer = (TextView) inflater.inflate(android.R.layout.simple_list_item_1, mPinnedSectionListView, false);
            footer.setText("Single footer");
            mPinnedSectionListView.addFooterView(footer);
        }
        initializeAdapter();
    }
    
	private boolean hasHeaderAndFooter;
	private boolean isFastScroll;
	private boolean addPadding;
	private boolean isShadowVisible = true;
	private int mDatasetUpdateCount;

 
    @Override
    public void onSaveInstanceState(Bundle outState) {
	    super.onSaveInstanceState(outState);
	    outState.putBoolean("isFastScroll", isFastScroll);
	    outState.putBoolean("addPadding", addPadding);
	    outState.putBoolean("isShadowVisible", isShadowVisible);
	    outState.putBoolean("hasHeaderAndFooter", hasHeaderAndFooter);
	}
    
    @SuppressLint("NewApi")
    private void initializeAdapter() {
    	mPinnedSectionListView.setFastScrollEnabled(isFastScroll);
        if (isFastScroll) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            	mPinnedSectionListView.setFastScrollAlwaysVisible(true);
            }
//            setListAdapter(new FastScrollAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1));
//            mPinnedSectionListView.setAdapter(new FastScrollAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1));
        } else {
//            setListAdapter(new SimpleAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1));
//            mPinnedSectionListView.setAdapter(new SimpleAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1));
        	mPinnedSectionListView.setAdapter(mTravelPinnedSectionListAdapter);
        }
    }
    
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.enrz.fragment.BaseV4Fragment#bindEvent()
	 */
	@Override
	public void bindEvent() {
		// TODO Auto-generated method stub
		super.bindEvent();
	}

	/* (non-Javadoc)
	 * @see com.open.android.activity.BaseFragmentActivity#call()
	 */
	@Override
	public TravelGroupJson call() throws Exception {
		// TODO Auto-generated method stub
		TravelGroupJson mTravelGroupJson = new TravelGroupJson();
		mTravelGroupJson.setList(TravelService.parseSearchHot(url));
		return mTravelGroupJson;
	}

	/* (non-Javadoc)
	 * @see com.open.android.activity.BaseFragmentActivity#onCallback(java.lang.Object)
	 */
	@Override
	public void onCallback(TravelGroupJson result) {
		// TODO Auto-generated method stub
		list.clear();
		list.addAll(result.getList());
		mTravelPinnedSectionListAdapter.notifyDataSetChanged();
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
