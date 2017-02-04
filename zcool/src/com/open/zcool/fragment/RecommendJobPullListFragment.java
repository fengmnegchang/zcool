/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-4上午11:40:47
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.zcool.fragment;

import java.util.HashMap;
import java.util.Map;

import android.os.Message;
import android.text.format.DateUtils;
import android.util.Log;
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
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.open.zcool.adapter.RecommendJobAdapter;
import com.open.zcool.json.RecommendJobJson;
import com.open.zcool.jsoup.RecommendJobService;
import com.open.zcool.utils.UrlUtils;

/**
 ***************************************************************************************************************************************************************************** 
 * 
 * @author :fengguangjing
 * @createTime:2017-2-4上午11:40:47
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 ***************************************************************************************************************************************************************************** 
 */
public class RecommendJobPullListFragment extends RecommendJobListFragment implements OnRefreshListener<ListView> {

	public static RecommendJobPullListFragment newInstance(String url, boolean isVisibleToUser) {
		RecommendJobPullListFragment fragment = new RecommendJobPullListFragment();
		fragment.setFragment(fragment);
		fragment.setUserVisibleHint(isVisibleToUser);
		fragment.url = url;
		return fragment;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.android.fragment.BaseV4Fragment#initValues()
	 */
	@Override
	public void initValues() {
		// TODO Auto-generated method stub
		mRecommendJobAdapter = new RecommendJobAdapter(getActivity(), list);
		mPullToRefreshListView.setAdapter(mRecommendJobAdapter);
		mPullToRefreshListView.setMode(Mode.BOTH);
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
		mPullToRefreshListView.setOnRefreshListener(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.enrz.fragment.BaseV4Fragment#call()
	 */
	@Override
	public RecommendJobJson call() throws Exception {
		// TODO Auto-generated method stub
		RecommendJobJson mRecommendJobJson = new RecommendJobJson();
		mRecommendJobJson.setList(RecommendJobService.parseRecommendJob(url,pageNo));
		return mRecommendJobJson;
	}

	/* (non-Javadoc)
	 * @see com.open.android.fragment.BaseV4Fragment#volleyJson(java.lang.String)
	 */
	@Override
	public void volleyJson(String href) {
		System.out.println(href);
		// TODO Auto-generated method stub
		/**
Accept:text/html,application/xhtml+xml,application/xml;q=0.9,image/webp, ;q=0.8
Accept-Encoding:gzip, deflate, sdch
Accept-Language:zh-CN,zh;q=0.8
Cache-Control:max-age=0
Connection:keep-alive
Cookie:zid=1456470574xxxt; Hm_lvt_6100b0cf343809acdb5765a0be722a2c=1486103326; JSESSIONID=aaahsdGan9QWc7VNlM7Mv; zcool_job_index_city=66; cn_e716846022b75pef3c0d_dplus=%7B%22distinct_id%22%3A%20%22153a17ca03682-083ce17f4-304a4d7d-1aeaa0-153a17ca038104%22%2C%22%24_sessionid%22%3A%200%2C%22%24_sessionTime%22%3A%201486189943%2C%22%24dp%22%3A%200%2C%22%24_sessionPVTime%22%3A%201486189943%7D; CNZZDATA30039725=cnzz_eid%3D987383166-1484726285-%26ntime%3D1486184842; CNZZDATA30055681=cnzz_eid%3D571334616-1486169629-http%253A%252F%252Fwww.zcool.com.cn%252F%26ntime%3D1486185842; tma=190930977.47996056.1456470574624.1486102752577.1486171339214.15; tmd=54.190930977.93910613.1484730619678.; fingerprint=5fc50e090746da024cb28c7dc7bde599; bfd_g=9facecf4bbcd46b40000444200002cd956cffa2e
Host:www.zcool.com.cn
Upgrade-Insecure-Requests:1
User-Agent:Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.75 Safari/537.36 QQBrowser/4.1.4132.400
		 */
		final Map<String, String> headers  = new HashMap<String, String>();
		headers.put("Cookie", "zid=1456470574xxxt; Hm_lvt_6100b0cf343809acdb5765a0be722a2c=1486103326; JSESSIONID=aaahsdGan9QWc7VNlM7Mv; zcool_job_index_city=66; cn_e716846022b75pef3c0d_dplus=%7B%22distinct_id%22%3A%20%22153a17ca03682-083ce17f4-304a4d7d-1aeaa0-153a17ca038104%22%2C%22%24_sessionid%22%3A%200%2C%22%24_sessionTime%22%3A%201486189943%2C%22%24dp%22%3A%200%2C%22%24_sessionPVTime%22%3A%201486189943%7D; CNZZDATA30039725=cnzz_eid%3D987383166-1484726285-%26ntime%3D1486184842; CNZZDATA30055681=cnzz_eid%3D571334616-1486169629-http%253A%252F%252Fwww.zcool.com.cn%252F%26ntime%3D1486185842; tma=190930977.47996056.1456470574624.1486102752577.1486171339214.15; tmd=54.190930977.93910613.1484730619678.; fingerprint=5fc50e090746da024cb28c7dc7bde599; bfd_g=9facecf4bbcd46b40000444200002cd956cffa2e");
		headers.put("User-Agent", UrlUtils.userAgent);
		RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
		StringRequest jsonObjectRequest = new StringRequest(Request.Method.GET, href,  
		new Response.Listener<String>() {
			@Override
			public void onResponse(String response) {
				System.out.println(response);
				RecommendJobJson mRecommendJobJson = new RecommendJobJson();
				mRecommendJobJson.setList(RecommendJobService.parseRecommendJob(response,pageNo));
				onCallback(mRecommendJobJson);
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

	/* (non-Javadoc)
	 * @see com.open.enrz.fragment.BaseV4Fragment#onCallback(java.lang.Object)
	 */
	@Override
	public void onCallback(RecommendJobJson result) {
		// TODO Auto-generated method stub
		Log.i(TAG, "getMode ===" + mPullToRefreshListView.getCurrentMode());
		if (mPullToRefreshListView.getCurrentMode() == Mode.PULL_FROM_START) {
			list.clear();
			list.addAll(result.getList());
			pageNo = 1;
		} else {
			if (result.getList() != null && result.getList().size() > 0) {
				list.addAll(result.getList());
			}
		}
		mRecommendJobAdapter.notifyDataSetChanged();
		// Call onRefreshComplete when the list has been refreshed.
		mPullToRefreshListView.onRefreshComplete();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener
	 * #onRefresh(com.handmark.pulltorefresh.library.PullToRefreshBase)
	 */
	@Override
	public void onRefresh(PullToRefreshBase<ListView> refreshView) {
		String label = DateUtils.formatDateTime(getActivity(), System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);
		// Update the LastUpdatedLabel
		refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(label);
		// Do work to refresh the list here.
		if (mPullToRefreshListView.getCurrentMode() == Mode.PULL_FROM_START) {
			pageNo = 1;
			weakReferenceHandler.sendEmptyMessage(MESSAGE_HANDLER);
		} else if (mPullToRefreshListView.getCurrentMode() == Mode.PULL_FROM_END) {
			pageNo++;
			weakReferenceHandler.sendEmptyMessage(MESSAGE_HANDLER);
		}
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
			if(pageNo>1){
				//推荐
				//http://www.zcool.com.cn/job/index.do?pageNo=2
				// 最新
				//http://www.zcool.com.cn/job/loadMoreIndex.do?pageNo=3
				if(url.contains("index.do")){
					volleyJson(url+"?pageNo="+pageNo);
				}else{
					volleyJson(UrlUtils.ZCOOL_JOB+"loadMoreIndex.do?pageNo="+pageNo);
				}
			}else{
				doAsync(this, this, this);
			}
			break;
		default:
			break;
		}
	}
	
}