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

import android.graphics.Color;
import android.os.Message;
import android.util.Log;
import android.view.View;

import com.jayfang.dropdownmenu.MenuBean;
import com.jayfang.dropdownmenu.OnMenuSelectedListener;
import com.open.android.weak.WeakReferenceHandler;
import com.open.zcool.R;
import com.open.zcool.json.SearchPostJson;
import com.open.zcool.jsoup.SearchWorksHeadService;

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
public class SearchWorksHeadDropFragment extends SearchPostDropMenuHeadFragment {

	public static SearchWorksHeadDropFragment newInstance(WeakReferenceHandler sweakReferenceHandler, String url, boolean isVisibleToUser) {
		SearchWorksHeadDropFragment fragment = new SearchWorksHeadDropFragment();
		fragment.setFragment(fragment);
		fragment.setUserVisibleHint(isVisibleToUser);
		fragment.url = url;
		fragment.sweakReferenceHandler = sweakReferenceHandler;
		return fragment;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.android.fragment.BaseV4Fragment#call()
	 */
	@Override
	public SearchPostJson call() throws Exception {
		// TODO Auto-generated method stub
		SearchPostJson mSearchPostJson = new SearchPostJson();
		mSearchPostJson.setItems(SearchWorksHeadService.parseSearchPost(url));
		return mSearchPostJson;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.open.android.fragment.BaseV4Fragment#onCallback(java.lang.Object)
	 */
	@Override
	public void onCallback(SearchPostJson result) {
		// TODO Auto-generated method stub
		items.clear();
		items.addAll(result.getItems());
		moreitems.clear();
		moreitems.addAll(result.getMoreitems());

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
			public void onSelected(View listview, int item, int RowIndex, int ColumnIndex) {
				if (RowIndex == 0) {
					RowIndex = 1;
				}
				Log.i(TAG, "select " + ColumnIndex + " column and " + RowIndex + " row");

				MenuBean mMenuBean = null;
				String typehref = null;
				if (item == 0) {
					if (items != null && items.size() > 0) {
						typehref = items.get(ColumnIndex).getTypehref();
						mMenuBean = items.get(ColumnIndex).getMenulist().get(RowIndex);
						items.get(ColumnIndex).setTypehref(mMenuBean.getHref());
					}
				} else if (item == 1) {
					typehref = moreitems.get(0).getMenulist().get(ColumnIndex).getTypehref();
					mMenuBean = moreitems.get(0).getMenulist().get(ColumnIndex).getRightlist().get(RowIndex);
					moreitems.get(0).getMenulist().get(ColumnIndex).setTypehref(mMenuBean.getHref());
				}
				// // 过滤筛选
				mMenuBean.setTypehref(typehref);
				Log.i(TAG, mMenuBean.getMenuname() + mMenuBean.getHref());
				if(sweakReferenceHandler!=null){
					Message msg = sweakReferenceHandler.obtainMessage();
					msg.what = MESSAGE_DROP_MENU_ITEM_SELECTED;
					msg.obj = mMenuBean;
					Log.i(TAG, "send msg == " + mMenuBean.getMenuname() + mMenuBean.getHref() + ";what==" + MESSAGE_DROP_MENU_ITEM_SELECTED);
					sweakReferenceHandler.sendMessage(msg);
				}
			}
		});
		mDropDownMenu.setmMenuMoreItems(moreitems);
		mDropDownMenu.setmMenuItems(items);
		mDropDownMenu.setIsDebug(false);
	}

}
