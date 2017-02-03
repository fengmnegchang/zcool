/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-3下午3:05:14
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.zcool.activity;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.open.android.activity.CommonFragmentActivity;
import com.open.zcool.R;
import com.open.zcool.adapter.AllClassAdapter;
import com.open.zcool.bean.AllBean;

/**
 *****************************************************************************************************************************************************************************
 * 所有类列表
 * @author :fengguangjing
 * @createTime:2017-2-3下午3:05:14
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class ZcoolALLActivity extends CommonFragmentActivity implements OnItemClickListener {
	private ListView listview;
	private AllClassAdapter mAllClassAdapter;
	private List<AllBean> list = new ArrayList<AllBean>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.open.tencenttv.CommonFragmentActivity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_zcool_all);
		init();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.tencenttv.CommonFragmentActivity#findView()
	 */
	@Override
	protected void findView() {
		// TODO Auto-generated method stub
		super.findView();
		listview = (ListView) findViewById(R.id.listview);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.tencenttv.CommonFragmentActivity#initValue()
	 */
	@Override
	protected void initValue() {
		// TODO Auto-generated method stub
		super.initValue();
		try {
			// 这样就能获取ActivityInfo了，之后可以获得Activity的name
			ActivityInfo[] activities = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_ACTIVITIES).activities;
			list.clear();
			AllBean allBean;
			for (ActivityInfo info : activities) {
				if (!ZcoolALLActivity.class.getName().equals(info.name)) {
					allBean = new AllBean(info.name, getResources().getString(info.descriptionRes));
					list.add(allBean);
				}
			}
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mAllClassAdapter = new AllClassAdapter(this, list);
		listview.setAdapter(mAllClassAdapter);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.open.tencenttv.BaseFragmentActivity#handlerMessage(android.os.Message
	 * )
	 */
	@Override
	public void handlerMessage(Message msg) {
		// TODO Auto-generated method stub
		super.handlerMessage(msg);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.tencenttv.CommonFragmentActivity#bindEvent()
	 */
	@Override
	protected void bindEvent() {
		// TODO Auto-generated method stub
		super.bindEvent();
		listview.setOnItemClickListener(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.widget.AdapterView.OnItemClickListener#onItemClick(android.widget
	 * .AdapterView, android.view.View, int, long)
	 */
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub
		Log.i(TAG, "listView item" + view.getId() + ";postion=" + (int) id + " ========onItemClick ");
		AllBean bean = list.get((int) id);
		if (bean != null && !ZcoolALLActivity.class.getName().equals(bean.getClassName())) {
			Intent intent = new Intent();
			intent.setClassName(getPackageName(), bean.getClassName());
			startActivity(intent);
		}
	}

}
