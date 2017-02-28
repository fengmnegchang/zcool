/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-3下午5:20:42
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.zcool.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.open.android.fragment.BaseV4Fragment;
import com.open.android.view.ExpendListView;
import com.open.zcool.R;
import com.open.zcool.adapter.IndexMainListAdapter;
import com.open.zcool.bean.IndexMainBean;
import com.open.zcool.json.IndexMainJson;
import com.open.zcool.json.RecommendJobJson;
import com.open.zcool.jsoup.IndexMainListService;
import com.open.zcool.jsoup.RecommendJobService;
import com.open.zcool.utils.UrlUtils;

/**
 ***************************************************************************************************************************************************************************** 
 * 
 * @author :fengguangjing
 * @createTime:2017-2-3下午5:20:42
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 ***************************************************************************************************************************************************************************** 
 */
public class WorksFootExpendListFragment extends BaseV4Fragment<IndexMainJson, WorksFootExpendListFragment> {
	public List<IndexMainBean> list = new ArrayList<IndexMainBean>();
	public IndexMainListAdapter mIndexMainListAdapter;
	public ExpendListView mPullToRefreshListView;

	public static WorksFootExpendListFragment newInstance(String url, boolean isVisibleToUser) {
		WorksFootExpendListFragment fragment = new WorksFootExpendListFragment();
		fragment.setFragment(fragment);
		fragment.setUserVisibleHint(isVisibleToUser);
		fragment.url = url;
		return fragment;
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_common_expend_listview, container, false);
		mPullToRefreshListView = (ExpendListView) view.findViewById(R.id.pull_refresh_list);
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
		mIndexMainListAdapter = new IndexMainListAdapter(getActivity(), list);
		mPullToRefreshListView.setAdapter(mIndexMainListAdapter);
	}

//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see com.open.enrz.fragment.BaseV4Fragment#call()
//	 */
//	@Override
//	public IndexMainJson call() throws Exception {
//		// TODO Auto-generated method stub
//		IndexMainJson mIndexMainJson = new IndexMainJson();
//		mIndexMainJson.setList(IndexMainListService.parseIndexMain(url, pageNo));
//		return mIndexMainJson;
//	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.enrz.fragment.BaseV4Fragment#onCallback(java.lang.Object)
	 */
	@Override
	public void onCallback(IndexMainJson result) {
		// TODO Auto-generated method stub
		super.onCallback(result);
		list.clear();
		list.addAll(result.getList());
		pageNo = 1;
		mIndexMainListAdapter.notifyDataSetChanged();
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
			volleyJson(url);
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
		System.out.println(href);
		final Map<String, String> headers  = new HashMap<String, String>();
		headers.put("Cookie", "zid=1456470574xxxt; Hm_lvt_6100b0cf343809acdb5765a0be722a2c=1486103326; zcool_job_index_city=66; JSESSIONID=aaaDpTaHi4Ltm8lLqH-Pv; CNZZDATA30055681=cnzz_eid%3D571334616-1486169629-http%253A%252F%252Fwww.zcool.com.cn%252F%26ntime%3D1488263437; cn_e716846022b75pef3c0d_dplus=%7B%22distinct_id%22%3A%20%22153a17ca03682-083ce17f4-304a4d7d-1aeaa0-153a17ca038104%22%2C%22%24_sessionid%22%3A%200%2C%22%24_sessionTime%22%3A%201488265057%2C%22%24dp%22%3A%200%2C%22%24_sessionPVTime%22%3A%201488265057%7D; CNZZDATA30039725=cnzz_eid%3D987383166-1484726285-%26ntime%3D1488263855; tma=190930977.47996056.1456470574624.1487298180476.1488250848008.23; tmd=294.190930977.93910613.1484730619678.; fingerprint=5fc50e090746da024cb28c7dc7bde599; bfd_g=9facecf4bbcd46b40000444200002cd956cffa2e; randomcodetoken=3315426cb481bd1e155df0699347cf04");  
		headers.put("User-Agent", UrlUtils.userAgent);
		RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
		StringRequest jsonObjectRequest = new StringRequest(Request.Method.GET, href,  
		new Response.Listener<String>() {
			@Override
			public void onResponse(String response) {
				System.out.println(response);
				IndexMainJson mIndexMainJson = new IndexMainJson();
				mIndexMainJson.setList(IndexMainListService.parseWorksFoot(response));
				onCallback(mIndexMainJson);
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

	 

	/* (non-Javadoc)
	 * @see com.open.android.fragment.BaseV4Fragment#onErrorResponse(com.android.volley.VolleyError)
	 */
	@Override
	public void onErrorResponse(VolleyError error) {
		// TODO Auto-generated method stub
		super.onErrorResponse(error);
		System.out.println(error);
	}

}
