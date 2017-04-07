/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-4-7下午2:14:43
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.zcool.fragment;

import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import co.lujun.androidtagview.TagContainerLayout;
import co.lujun.androidtagview.TagView.OnTagClickListener;

import com.open.android.fragment.BaseV4Fragment;
import com.open.zcool.R;
import com.open.zcool.json.SearchSuCaiJson;
import com.open.zcool.jsoup.ToolsSearchSuCaiService;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-4-7下午2:14:43
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class ToolsSearchSuCaiListFragment extends BaseV4Fragment<SearchSuCaiJson, ToolsSearchSuCaiListFragment> implements OnClickListener {
	public EditText edit_search;
	public Button btn_search_p;
	public Button btn_search_img;
	public TagContainerLayout tagcontainerLayoutmain;
	public TagContainerLayout tagcontainerLayoutk;
	public TagContainerLayout tagcontainerLayoutimg;
	
	public static ToolsSearchSuCaiListFragment newInstance(String url, boolean isVisibleToUser) {
		ToolsSearchSuCaiListFragment fragment = new ToolsSearchSuCaiListFragment();
		fragment.setFragment(fragment);
		fragment.setUserVisibleHint(isVisibleToUser);
		fragment.url = url;
		return fragment;
	}
	
	/* (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_tools_search_sucai, container, false);
		edit_search = (EditText) view.findViewById(R.id.edit_search);
		btn_search_p = (Button) view.findViewById(R.id.btn_search_p);
		btn_search_img = (Button) view.findViewById(R.id.btn_search_img);
		tagcontainerLayoutmain = (TagContainerLayout) view.findViewById(R.id.tagcontainerLayoutmain);
		tagcontainerLayoutk = (TagContainerLayout) view.findViewById(R.id.tagcontainerLayoutk);
		tagcontainerLayoutimg = (TagContainerLayout) view.findViewById(R.id.tagcontainerLayoutimg);
		return view;
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
		btn_search_p.setOnClickListener(this);
		btn_search_img.setOnClickListener(this);
		tagcontainerLayoutmain.setOnTagClickListener(new OnTagClickListener() {
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
			}
		});
		tagcontainerLayoutk.setOnTagClickListener(new OnTagClickListener() {
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
			}
		});
		tagcontainerLayoutimg.setOnTagClickListener(new OnTagClickListener() {
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
		case R.id.btn_search_p:
			break;
		case R.id.btn_search_img:
			break;
		default:
			break;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.open.android.fragment.BaseV4Fragment#call()
	 */
	@Override
	public SearchSuCaiJson call() throws Exception {
		// TODO Auto-generated method stub
		SearchSuCaiJson mSearchSuCaiJson = ToolsSearchSuCaiService.parseSearchHot(url);
		return mSearchSuCaiJson;
	}
	
	/* (non-Javadoc)
	 * @see com.open.android.fragment.BaseV4Fragment#onCallback(java.lang.Object)
	 */
	@Override
	public void onCallback(SearchSuCaiJson result) {
		// TODO Auto-generated method stub
		super.onCallback(result);
		for(int i=0;i<result.getIndexnavlist().size();i++){
			tagcontainerLayoutmain.addTag(result.getIndexnavlist().get(i).getTitle());
		}
		
		for(int i=0;i<result.getHotWordsLeftlist().size();i++){
			tagcontainerLayoutk.addTag(result.getHotWordsLeftlist().get(i).getTitle());
		}
		
		for(int i=0;i<result.getHotWordsRightlist().size();i++){
			tagcontainerLayoutimg.addTag(result.getHotWordsRightlist().get(i).getTitle());
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
