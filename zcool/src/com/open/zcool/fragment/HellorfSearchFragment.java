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

import android.os.Bundle;
import android.os.Message;
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
public class HellorfSearchFragment extends BaseV4Fragment<ToSearchJson, HellorfSearchFragment> implements OnClickListener {
	public EditText edit_search;
	public Button btn_search;
	public TagContainerLayout tagcontainerLayouto;

	public static HellorfSearchFragment newInstance(String url, boolean isVisibleToUser) {
		HellorfSearchFragment fragment = new HellorfSearchFragment();
		fragment.setFragment(fragment);
		fragment.setUserVisibleHint(isVisibleToUser);
		fragment.url = url;
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_hellorf_search, container, false);
		edit_search = (EditText) view.findViewById(R.id.edit_search);
		btn_search = (Button) view.findViewById(R.id.btn_search);
		tagcontainerLayouto = (TagContainerLayout) view.findViewById(R.id.tagcontainerLayouto);
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

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.android.activity.CommonFragmentActivity#bindEvent()
	 */
	@Override
	public void bindEvent() {
		// TODO Auto-generated method stub
		super.bindEvent();
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
				startSearch(text);
			}
		});

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.open.android.activity.CommonFragmentActivity#onClick(android.view
	 * .View)
	 */
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_search:
			startSearch(edit_search.getText().toString());
			break;
		default:
			break;
		}
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
		super.onCallback(result);
		tagcontainerLayouto.setTags(result.getOlist());

	}

	public void startSearch(String keys) {
		try {
			keys = URLEncoder.encode(keys, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
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
