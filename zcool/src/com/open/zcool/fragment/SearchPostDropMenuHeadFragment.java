/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-10上午10:22:15
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.zcool.fragment;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jayfang.dropdownmenu.DropDownMenu;
import com.jayfang.dropdownmenu.DropItemBean;
import com.jayfang.dropdownmenu.MenuBean;
import com.jayfang.dropdownmenu.OnMenuSelectedListener;
import com.open.android.fragment.BaseV4Fragment;
import com.open.zcool.R;
import com.open.zcool.json.SearchPostJson;
import com.open.zcool.jsoup.SearchPostService;

/**
 ***************************************************************************************************************************************************************************** 
 * 
 * @author :fengguangjing
 * @createTime:2017-2-10上午10:22:15
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 ***************************************************************************************************************************************************************************** 
 */
public class SearchPostDropMenuHeadFragment extends BaseV4Fragment<SearchPostJson, SearchPostDropMenuHeadFragment> {
	public DropDownMenu mDropDownMenu;
	public List<DropItemBean> items = new ArrayList<DropItemBean>();
	 
	public static SearchPostDropMenuHeadFragment newInstance(String url, boolean isVisibleToUser) {
		SearchPostDropMenuHeadFragment fragment = new SearchPostDropMenuHeadFragment();
		fragment.setFragment(fragment);
		fragment.setUserVisibleHint(isVisibleToUser);
		fragment.url = url;
		return fragment;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_search_post_drop_menu_head, container, false);
		mDropDownMenu = (DropDownMenu) view.findViewById(R.id.drop_menu);
		return view;
	}
	
	/* (non-Javadoc)
	 * @see com.open.android.fragment.BaseV4Fragment#initValues()
	 */
	@Override
	public void initValues() {
		// TODO Auto-generated method stub
		super.initValues();
		
	}

	/* (non-Javadoc)
	 * @see com.open.android.fragment.BaseV4Fragment#call()
	 */
	@Override
	public SearchPostJson call() throws Exception {
		// TODO Auto-generated method stub
		SearchPostJson mSearchPostJson = new SearchPostJson();
		mSearchPostJson.setItems(SearchPostService.parseSearchPost(url));
		return mSearchPostJson;
	}

	/* (non-Javadoc)
	 * @see com.open.android.fragment.BaseV4Fragment#onCallback(java.lang.Object)
	 */
	@Override
	public void onCallback(SearchPostJson result) {
		// TODO Auto-generated method stub
		items.clear();
		items.addAll(result.getItems());
		mDropDownMenu.setmMenuCount(items.size());
		mDropDownMenu.setmShowCount(6);
		mDropDownMenu.setShowCheck(true);
		mDropDownMenu.setmMenuTitleTextSize(16);
		mDropDownMenu.setmMenuTitleTextColor(Color.parseColor("#777777"));
		mDropDownMenu.setmMenuListTextSize(16);
		mDropDownMenu.setmMenuListTextColor(Color.BLACK);
		mDropDownMenu.setmMenuBackColor(Color.parseColor("#eeeeee"));
		mDropDownMenu.setmMenuPressedBackColor(Color.WHITE);
		mDropDownMenu.setmMenuPressedTitleTextColor(Color.BLACK);

		mDropDownMenu.setmCheckIcon(R.drawable.ico_make);

		mDropDownMenu.setmUpArrow(R.drawable.arrow_up);
		mDropDownMenu.setmDownArrow(R.drawable.arrow_down);


		mDropDownMenu.setShowDivider(false);
		mDropDownMenu.setmMenuListBackColor(getResources().getColor(R.color.white));
		mDropDownMenu.setmMenuListSelectorRes(R.color.white);
		mDropDownMenu.setmArrowMarginTitle(20);
		mDropDownMenu.setMenuSelectedListener(new OnMenuSelectedListener() {
			@Override
			public void onSelected(View listview, int RowIndex, int ColumnIndex) {
				if (RowIndex == 0) {
					RowIndex = 1;
				}
				Log.i(TAG, "select " + ColumnIndex + " column and " + RowIndex + " row");
//				// 过滤筛选
//				MenuBean mMenuBean = mMenuItems.get(ColumnIndex).getMenulist().get(RowIndex);
//				Log.i(TAG, mMenuBean.getHref() + ";" + mMenuBean.getMenuname());
//				Message msg = weakReferenceHandler.obtainMessage();
//				msg.what = 111;
//				msg.obj = mMenuBean.getHref();
//				Log.i(TAG, "send msg ==href==" + mMenuBean.getHref() + ";what==" + 111);
//				weakReferenceHandler.sendMessage(msg);
			}
		});
		
         mDropDownMenu.setmMenuItems(items);
         mDropDownMenu.setIsDebug(false);
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
