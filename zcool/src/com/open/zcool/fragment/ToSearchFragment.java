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
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import co.lujun.androidtagview.TagContainerLayout;
import co.lujun.androidtagview.TagView.OnTagClickListener;

import com.open.android.fragment.BaseV4Fragment;
import com.open.zcool.R;
import com.open.zcool.activity.ToSearchMainPullListFragmentActivity;
import com.open.zcool.json.ToSearchJson;
import com.open.zcool.jsoup.ToSearchService;

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
public class ToSearchFragment extends BaseV4Fragment<ToSearchJson, ToSearchFragment> implements OnClickListener {
	public Spinner spinner;
	public EditText edit_search;
	public Button btn_search;
	public TagContainerLayout tagcontainerLayouto;
	public TagContainerLayout tagcontainerLayoutm;
	public List<String> plist = new ArrayList<String>();// page条件
	public ArrayAdapter<String> sadapter;
	
	
	public static ToSearchFragment newInstance(String url, boolean isVisibleToUser) {
		ToSearchFragment fragment = new ToSearchFragment();
		fragment.setFragment(fragment);
		fragment.setUserVisibleHint(isVisibleToUser);
		fragment.url = url;
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_to_search, container, false);
		spinner = (Spinner) view.findViewById(R.id.spinner);
		edit_search = (EditText) view.findViewById(R.id.edit_search);
		btn_search = (Button) view.findViewById(R.id.btn_search);
		tagcontainerLayouto = (TagContainerLayout) view.findViewById(R.id.tagcontainerLayouto);
		tagcontainerLayoutm = (TagContainerLayout) view.findViewById(R.id.tagcontainerLayoutm);
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
		sadapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, plist);
		sadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(sadapter);
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
		tagcontainerLayoutm.setOnTagClickListener(new OnTagClickListener() {
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
		ToSearchJson mToSearchJson = ToSearchService.parseSearchHot(url);
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
		tagcontainerLayoutm.setTags(result.getMlist());
		plist.clear();
		plist.addAll(result.getPlist());
		sadapter.notifyDataSetChanged();
	}

	public void startSearch(String keys) {
		try {
			keys = URLEncoder.encode(keys, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		//http://www.zcool.com.cn/tosearch.do?world=背景
		ToSearchMainPullListFragmentActivity.startToSearchMainPullListFragmentActivity(getActivity(), url+"world="+keys);
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
