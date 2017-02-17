/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-9下午5:11:39
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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.jayfang.dropdownmenu.MenuBean;
import com.open.zcool.R;
import com.open.zcool.adapter.RecommendJobAdapter;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-9下午5:11:39
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class SearchPostFragment extends RecommendJobPullListFragment{
	public View headview;
	
	public static SearchPostFragment newInstance(String url, boolean isVisibleToUser) {
		SearchPostFragment fragment = new SearchPostFragment();
		fragment.setFragment(fragment);
		fragment.setUserVisibleHint(isVisibleToUser);
		fragment.url = url;
		return fragment;
	}
	
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_common_pulllistview, container, false);
		mPullToRefreshListView = (PullToRefreshListView) view.findViewById(R.id.pull_refresh_list);
		
		headview = LayoutInflater.from(getActivity()).inflate(R.layout.layout_search_post_head, null);
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
		mPullToRefreshListView.getRefreshableView().addHeaderView(headview);
		SearchPostDropMenuHeadFragment fragment = SearchPostDropMenuHeadFragment.newInstance(weakReferenceHandler,url, true);
		getChildFragmentManager().beginTransaction().replace(R.id.id_search_post_head, fragment).commit();
		
		mRecommendJobAdapter = new RecommendJobAdapter(getActivity(), list);
		mPullToRefreshListView.setAdapter(mRecommendJobAdapter);
		mPullToRefreshListView.setMode(Mode.BOTH);
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
		super.handlerMessage(msg);
		switch (msg.what) {
		case MESSAGE_DROP_MENU_ITEM_SELECTED:
			Log.i(TAG, "handler msg == name==" +msg.obj + ";what==" + MESSAGE_DROP_MENU_ITEM_SELECTED);
			MenuBean mMenuBean = (MenuBean) msg.obj;
			String ckeys = mMenuBean.getHref();
			String ckeyid = "0";
			String pkeyid = "0";
			if(ckeys.contains("javascript:salaryclick(")){
				//按月薪 search_salaryid
				ckeyid = ckeys.replace("javascript:salaryclick(", "").replace(")", "");
				pkeyid = mMenuBean.getTypehref().replace("javascript:salaryclick(", "").replace(")", "");
				url  = url.replace("&search_salaryid="+pkeyid, "&search_salaryid="+ckeyid);
			}else if(ckeys.contains("javascript:workstatusclick(")){
				//按职业性质 search_workstatus
				ckeyid = ckeys.replace("javascript:workstatusclick(", "").replace(")", "");
				pkeyid = mMenuBean.getTypehref().replace("javascript:workstatusclick(", "").replace(")", "");
				url  = url.replace("&search_workstatus="+pkeyid, "&search_workstatus="+ckeyid);
			}
			Log.i(TAG, "pkeyid=="+pkeyid+";ckeyid=="+ckeyid);
			weakReferenceHandler.sendEmptyMessage(MESSAGE_HANDLER);
			break;
		default:
			break;
		}
	}
}
