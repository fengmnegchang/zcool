/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-17下午2:54:24
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.zcool.activity;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.open.android.activity.CommonAppCompatActivity;
import com.open.zcool.R;
import com.open.zcool.adapter.YesterdayCollectionGridAdapter;
import com.open.zcool.utils.UrlUtils;

/**
 ***************************************************************************************************************************************************************************** 
 * pc 工具搜素材
 * 
 * @author :fengguangjing
 * @createTime:2017-2-17下午2:54:24
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 ***************************************************************************************************************************************************************************** 
 */
public class ToolsYesterdayCollectionGridAppCompatActivity extends CommonAppCompatActivity<String> {
	private RecyclerView recyclerView;
	private YesterdayCollectionGridAdapter mYesterdayCollectionGridAdapter;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.open.enrz.activity.CommonFragmentActivity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tools_yesterday_collection_grid);
		init();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.enrz.activity.CommonFragmentActivity#initValue()
	 */
	@Override
	protected void initValue() {
		// TODO Auto-generated method stub
		super.initValue();
		if (getIntent().getStringExtra("URL") != null) {
			url = getIntent().getStringExtra("URL");
		} else {
			url = UrlUtils.ZCOOL_SUCAI;
		}
		addfragment();
		recyclerView.setHasFixedSize(true);
		recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
		recyclerView.setAdapter(mYesterdayCollectionGridAdapter = new YesterdayCollectionGridAdapter());
		mYesterdayCollectionGridAdapter.replaceAll(getData());
	}

	public ArrayList<String> getData() {
		ArrayList<String> list = new ArrayList<String>();
		for (String url : imageUrls) {
			list.add(url);
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.android.activity.CommonAppCompatActivity#findView()
	 */
	@Override
	protected void findView() {
		// TODO Auto-generated method stub
		super.findView();
		recyclerView = (RecyclerView) findViewById(R.id.recylerview);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.android.activity.CommonFragmentActivity#addfragment()
	 */
	@Override
	public void addfragment() {
		// TODO Auto-generated method stub
		super.addfragment();
		// Fragment fragment = CommonV4Fragment.newInstance(url, true);
		// getSupportFragmentManager().beginTransaction().replace(R.id.id_common_fragment,
		// fragment).commit();
	}

	public static void startToolsYesterdayCollectionGridAppCompatActivity(Context context, String url) {
		Intent intent = new Intent();
		intent.putExtra("URL", url);
		intent.setClass(context, ToolsYesterdayCollectionGridAppCompatActivity.class);
		context.startActivity(intent);
	}

	public final static String[] imageUrls = new String[] { "http://img.my.csdn.net/uploads/201508/05/1438760758_3497.jpg", "http://img.my.csdn.net/uploads/201508/05/1438760758_6667.jpg",
			"http://img.my.csdn.net/uploads/201508/05/1438760757_3588.jpg", "http://img.my.csdn.net/uploads/201508/05/1438760756_3304.jpg",
			"http://img.my.csdn.net/uploads/201508/05/1438760755_6715.jpeg", "http://img.my.csdn.net/uploads/201508/05/1438760726_5120.jpg",
			"http://img.my.csdn.net/uploads/201508/05/1438760726_8364.jpg", "http://img.my.csdn.net/uploads/201508/05/1438760725_4031.jpg",
			"http://img.my.csdn.net/uploads/201508/05/1438760724_9463.jpg", "http://img.my.csdn.net/uploads/201508/05/1438760724_2371.jpg",
			"http://img.my.csdn.net/uploads/201508/05/1438760707_4653.jpg", "http://img.my.csdn.net/uploads/201508/05/1438760706_6864.jpg",
			"http://img.my.csdn.net/uploads/201508/05/1438760706_9279.jpg", "http://img.my.csdn.net/uploads/201508/05/1438760704_2341.jpg",
			"http://img.my.csdn.net/uploads/201508/05/1438760704_5707.jpg", "http://img.my.csdn.net/uploads/201508/05/1438760685_5091.jpg",
			"http://img.my.csdn.net/uploads/201508/05/1438760685_4444.jpg", "http://img.my.csdn.net/uploads/201508/05/1438760684_8827.jpg",
			"http://img.my.csdn.net/uploads/201508/05/1438760683_3691.jpg", "http://img.my.csdn.net/uploads/201508/05/1438760683_7315.jpg",
			"http://img.my.csdn.net/uploads/201508/05/1438760663_7318.jpg", "http://img.my.csdn.net/uploads/201508/05/1438760662_3454.jpg",
			"http://img.my.csdn.net/uploads/201508/05/1438760662_5113.jpg", "http://img.my.csdn.net/uploads/201508/05/1438760661_3305.jpg",
			"http://img.my.csdn.net/uploads/201508/05/1438760661_7416.jpg", "http://img.my.csdn.net/uploads/201508/05/1438760589_2946.jpg",
			"http://img.my.csdn.net/uploads/201508/05/1438760589_1100.jpg", "http://img.my.csdn.net/uploads/201508/05/1438760588_8297.jpg",
			"http://img.my.csdn.net/uploads/201508/05/1438760587_2575.jpg", "http://img.my.csdn.net/uploads/201508/05/1438760587_8906.jpg",
			"http://img.my.csdn.net/uploads/201508/05/1438760550_2875.jpg", "http://img.my.csdn.net/uploads/201508/05/1438760550_9517.jpg",
			"http://img.my.csdn.net/uploads/201508/05/1438760549_7093.jpg", "http://img.my.csdn.net/uploads/201508/05/1438760549_1352.jpg",
			"http://img.my.csdn.net/uploads/201508/05/1438760548_2780.jpg", "http://img.my.csdn.net/uploads/201508/05/1438760531_1776.jpg",
			"http://img.my.csdn.net/uploads/201508/05/1438760531_1380.jpg", "http://img.my.csdn.net/uploads/201508/05/1438760530_4944.jpg",
			"http://img.my.csdn.net/uploads/201508/05/1438760530_5750.jpg", "http://img.my.csdn.net/uploads/201508/05/1438760529_3289.jpg",
			"http://img.my.csdn.net/uploads/201508/05/1438760500_7871.jpg", "http://img.my.csdn.net/uploads/201508/05/1438760500_6063.jpg",
			"http://img.my.csdn.net/uploads/201508/05/1438760499_6304.jpeg", "http://img.my.csdn.net/uploads/201508/05/1438760499_5081.jpg",
			"http://img.my.csdn.net/uploads/201508/05/1438760498_7007.jpg", "http://img.my.csdn.net/uploads/201508/05/1438760478_3128.jpg",
			"http://img.my.csdn.net/uploads/201508/05/1438760478_6766.jpg", "http://img.my.csdn.net/uploads/201508/05/1438760477_1358.jpg",
			"http://img.my.csdn.net/uploads/201508/05/1438760477_3540.jpg", "http://img.my.csdn.net/uploads/201508/05/1438760476_1240.jpg",
			"http://img.my.csdn.net/uploads/201508/05/1438760446_7993.jpg", "http://img.my.csdn.net/uploads/201508/05/1438760446_3641.jpg",
			"http://img.my.csdn.net/uploads/201508/05/1438760445_3283.jpg", "http://img.my.csdn.net/uploads/201508/05/1438760444_8623.jpg",
			"http://img.my.csdn.net/uploads/201508/05/1438760444_6822.jpg", "http://img.my.csdn.net/uploads/201508/05/1438760422_2224.jpg",
			"http://img.my.csdn.net/uploads/201508/05/1438760421_2824.jpg", "http://img.my.csdn.net/uploads/201508/05/1438760420_2660.jpg",
			"http://img.my.csdn.net/uploads/201508/05/1438760420_7188.jpg", "http://img.my.csdn.net/uploads/201508/05/1438760419_4123.jpg", };
}
