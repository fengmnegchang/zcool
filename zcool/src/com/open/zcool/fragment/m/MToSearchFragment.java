/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-5-24下午2:09:32
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.zcool.fragment.m;

import java.util.HashMap;
import java.util.Map;

import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.open.zcool.R;
import com.open.zcool.adapter.ToSearchMainListAdapter;
import com.open.zcool.fragment.ToSearchMainPullListFragment;
import com.open.zcool.json.ToSearchMainJson;
import com.open.zcool.jsoup.ToSearchMainListService;
import com.open.zcool.utils.UrlUtils;

/**
 ***************************************************************************************************************************************************************************** 
 * 
 * @author :fengguangjing
 * @createTime:2017-5-24下午2:09:32
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 ***************************************************************************************************************************************************************************** 
 */
public class MToSearchFragment extends ToSearchMainPullListFragment {
    public int oType=0;
    
	public static MToSearchFragment newInstance(String url, int page, boolean isVisibleToUser) {
		MToSearchFragment fragment = new MToSearchFragment();
		fragment.setFragment(fragment);
		fragment.setUserVisibleHint(isVisibleToUser);
		fragment.url = url;
		fragment.page = page;
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
		mToSearchMainListAdapter = new ToSearchMainListAdapter(getActivity(), list);
		mPullToRefreshListView.setAdapter(mToSearchMainListAdapter);
		mPullToRefreshListView.setMode(Mode.BOTH);
	}
	/* (non-Javadoc)
	 * @see com.open.enrz.fragment.BaseV4Fragment#call()
	 */
	@Override
	public ToSearchMainJson call() throws Exception {
		// TODO Auto-generated method stub
		ToSearchMainJson mToSearchMainJson = new ToSearchMainJson();
		//http://m.zcool.com.cn/tosearch.do?world=%E7%BE%8E%E5%A5%B3&closeUrl=/articles/
		//http://m.zcool.com.cn/getMoreWapSearch.do?world=%E7%BE%8E%E5%A5%B3&oType=0&curPage=2
		mToSearchMainJson.setList(ToSearchMainListService.parseMSearch(url,pageNo));
		return mToSearchMainJson;
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
			if(pageNo==1){
				doAsync(this, this, this);
			}else{
				volleyJson(UrlUtils.ZCOOL_M_TO_SEARCH_MORE+"oType="+oType+"&curPage="+pageNo);
			}
			break;
		default:
			break;
		}
	}

	/* (non-Javadoc)
	 * @see com.open.android.fragment.BaseV4Fragment#volleyJson(java.lang.String)
	 */
	@Override
	public void volleyJson(String href) {
		// TODO Auto-generated method stub
		final Map<String, String> headers  = new HashMap<String, String>();
		headers.put("User-Agent", UrlUtils.userAgent);
		
		System.out.println(href);
		RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
		StringRequest jsonObjectRequest = new StringRequest(Request.Method.GET, href,  
		new Response.Listener<String>() {
			@Override
			public void onResponse(String response) {
//				System.out.println(response);
				ToSearchMainJson mToSearchMainJson = new ToSearchMainJson();
				mToSearchMainJson.setList(ToSearchMainListService.parseMSearch(response,pageNo));
				onCallback(mToSearchMainJson);
			}
		}, this){
			
			/* (non-Javadoc)
			 * @see com.android.volley.toolbox.StringRequest#getHeaders()
			 */
			@Override
			public Map<String, String> getHeaders() throws AuthFailureError {
				// TODO Auto-generated method stub
				return headers;
			}
		} ;
		requestQueue.add(jsonObjectRequest); 
	}
	
	
}
