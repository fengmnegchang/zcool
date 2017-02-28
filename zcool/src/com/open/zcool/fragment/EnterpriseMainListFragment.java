/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-17下午4:25:32
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
import android.support.annotation.Nullable;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.jayfang.dropdownmenu.MenuBean;
import com.open.android.fragment.BaseV4Fragment;
import com.open.zcool.R;
import com.open.zcool.adapter.EnterpriseMainListAdapter;
import com.open.zcool.bean.EnterpriseMainBean;
import com.open.zcool.json.EnterpriseMainJson;
import com.open.zcool.jsoup.EnterPriseMainService;

/**
 ***************************************************************************************************************************************************************************** 
 * 
 * @author :fengguangjing
 * @createTime:2017-2-17下午4:25:32
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 ***************************************************************************************************************************************************************************** 
 */
public class EnterpriseMainListFragment extends BaseV4Fragment<EnterpriseMainJson, EnterpriseMainListFragment> implements OnRefreshListener<ListView> {
	private List<EnterpriseMainBean> list = new ArrayList<EnterpriseMainBean>();
	private EnterpriseMainListAdapter mEnterpriseMainListAdapter;
	public PullToRefreshListView mPullToRefreshListView;
	public View headview;
	
	public static EnterpriseMainListFragment newInstance(String url, boolean isVisibleToUser) {
		EnterpriseMainListFragment fragment = new EnterpriseMainListFragment();
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
		super.initValues();
		mPullToRefreshListView.getRefreshableView().addHeaderView(headview);
		SearchEnterpriseMainMenuHeadFragment fragment = SearchEnterpriseMainMenuHeadFragment.newInstance(weakReferenceHandler,url, true);
		getChildFragmentManager().beginTransaction().replace(R.id.id_search_post_head, fragment).commit();
		
		mEnterpriseMainListAdapter = new EnterpriseMainListAdapter(getActivity(), list);
		mPullToRefreshListView.setAdapter(mEnterpriseMainListAdapter);
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
	public EnterpriseMainJson call() throws Exception {
		// TODO Auto-generated method stub
		EnterpriseMainJson mEnterpriseMainJson = new EnterpriseMainJson();
		mEnterpriseMainJson.setList(EnterPriseMainService.parseEnterPriseMain(url, pageNo));
		return mEnterpriseMainJson;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.enrz.fragment.BaseV4Fragment#onCallback(java.lang.Object)
	 */
	@Override
	public void onCallback(EnterpriseMainJson result) {
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
		mEnterpriseMainListAdapter.notifyDataSetChanged();
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
		super.handlerMessage(msg);
		switch (msg.what) {
		case MESSAGE_HANDLER:
			doAsync(this, this, this);
			break;
		case MESSAGE_DROP_MENU_ITEM_SELECTED:
			Log.i(TAG, "handler msg == name==" +msg.obj + ";what==" + MESSAGE_DROP_MENU_ITEM_SELECTED);
			MenuBean mMenuBean = (MenuBean) msg.obj;
			String ckeys = mMenuBean.getHref();
			String ckeyid = "0";
			String pkeyid = "0";
			  if(ckeys.contains("javascript:stageclick(")){
				//融资阶段 search_diplomaid
				ckeyid = ckeys.replace("javascript:stageclick(", "").replace(")", "");
				pkeyid = mMenuBean.getTypehref().replace("javascript:stageclick(", "").replace(")", "");
				url  = url.replace("&search_stageid="+pkeyid, "&search_stageid="+ckeyid);
			}else if(ckeys.contains("javascript:industryclick(")){
				//所属行业 search_diplomaid
				ckeyid = ckeys.replace("javascript:industryclick(", "").replace(")", "");
				pkeyid = mMenuBean.getTypehref().replace("javascript:industryclick(", "").replace(")", "");
				url  = url.replace("&search_industryid="+pkeyid, "&search_industryid="+ckeyid);
			}else if(ckeys.contains("data-id")){
				//工作地点 search_cityid
				//<a href="javascript:cityclick(0,47);"  class="city-one-text" data-id="47">北京</a>
				ckeyid = ckeys.replace("data-id", "").replace(")", "");
				pkeyid = mMenuBean.getTypehref().replace("data-id", "").replace(")", "");
				url  = url.replace("&search_cityid="+pkeyid, "&search_cityid="+ckeyid);
			}
			Log.i(TAG, "pkeyid=="+pkeyid+";ckeyid=="+ckeyid);
			weakReferenceHandler.sendEmptyMessage(MESSAGE_HANDLER);
			break;
		default:
			break;
		}
	}
}
