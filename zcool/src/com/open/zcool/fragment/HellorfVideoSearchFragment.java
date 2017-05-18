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

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import co.lujun.androidtagview.TagContainerLayout;
import co.lujun.androidtagview.TagView.OnTagClickListener;

import com.open.android.fragment.BaseV4Fragment;
import com.open.zcool.R;
import com.open.zcool.activity.HellorfSearchGridFragmentActivity;
import com.open.zcool.adapter.HellorfPagerAdapter;
import com.open.zcool.bean.HellorfSearchBean;
import com.open.zcool.json.ToSearchJson;
import com.open.zcool.jsoup.HellorfSearchService;
import com.open.zcool.utils.UrlUtils;

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
public class HellorfVideoSearchFragment extends HellorfSearchFragment {
	public static HellorfVideoSearchFragment newInstance(String url, boolean isVisibleToUser) {
		HellorfVideoSearchFragment fragment = new HellorfVideoSearchFragment();
		fragment.setFragment(fragment);
		fragment.setUserVisibleHint(isVisibleToUser);
		fragment.url = url;
		return fragment;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.android.activity.CommonFragmentActivity#bindEvent()
	 */
	@Override
	public void bindEvent() {
		// TODO Auto-generated method stub
		btn_search.setOnClickListener(this);
		tagcontainerLayouto.setOnTagClickListener(new OnTagClickListener() {
			@Override
			public void onTagLongClick(int position, String text) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onTagCrossClick(int position) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onTagClick(int position, String text) {
				// TODO Auto-generated method stub
//				startSearch(text);
				HellorfSearchGridFragmentActivity.startHellorfSearchGridFragmentActivity(getActivity(), plist.get(position));
			}
		});

	}
 

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.android.fragment.BaseV4Fragment#call()
	 */
	@Override
	public ToSearchJson call() throws Exception {
		// TODO Auto-generated method stub
		ToSearchJson mToSearchJson = HellorfSearchService.parseSearchHot(url);
		mToSearchJson.setPagerlist(HellorfSearchService.parsePager(url));
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
		tagcontainerLayouto.setTags(result.getOlist());
		plist.clear();
		plist.addAll(result.getPlist());

		list.clear();
		list.addAll(result.getPagerlist());
		mHellorfPagerAdapter.notifyDataSetChanged();
	}

	public void startSearch(String keys) {
		try {
			keys = URLEncoder.encode(keys, "UTF-8");
			//http://www.hellorf.com/image/search/%E7%BE%8E%E5%A5%B3
			HellorfSearchGridFragmentActivity.startHellorfSearchGridFragmentActivity(getActivity(),UrlUtils.HELLO_RF_SEARCH_VIDEO+keys);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

 

}
