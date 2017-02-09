/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-9下午3:13:26
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.zcool.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import co.lujun.androidtagview.TagContainerLayout;
import co.lujun.androidtagview.TagView.OnTagClickListener;

import com.open.android.activity.CommonFragmentActivity;
import com.open.zcool.R;
import com.open.zcool.json.SearchHotJson;
import com.open.zcool.jsoup.SearchHotService;
import com.open.zcool.utils.UrlUtils;

/**
 *****************************************************************************************************************************************************************************
 * 热门搜索
 * @author :fengguangjing
 * @createTime:2017-2-9下午3:13:26
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class SearchHotFragmentActivity extends CommonFragmentActivity<SearchHotJson>  {

	private EditText edit_search;
	private Button btn_search;
	private TagContainerLayout tagcontainerLayouth,tagcontainerLayoutd,tagcontainerLayoutm;
	/* (non-Javadoc)
	 * @see com.open.android.activity.CommonFragmentActivity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_hot);
		init();
	}

	/* (non-Javadoc)
	 * @see com.open.android.activity.CommonFragmentActivity#findView()
	 */
	@Override
	protected void findView() {
		// TODO Auto-generated method stub
		super.findView();
		edit_search = (EditText) findViewById(R.id.edit_search);
		btn_search = (Button) findViewById(R.id.btn_search);
		tagcontainerLayouth = (TagContainerLayout) findViewById(R.id.tagcontainerLayouth);
		tagcontainerLayoutd = (TagContainerLayout) findViewById(R.id.tagcontainerLayoutd);
		tagcontainerLayoutm = (TagContainerLayout) findViewById(R.id.tagcontainerLayoutm);
	}

	/* (non-Javadoc)
	 * @see com.open.android.activity.CommonFragmentActivity#initValue()
	 */
	@Override
	protected void initValue() {
		// TODO Auto-generated method stub
		super.initValue();
		if (getIntent().getStringExtra("URL") != null) {
			url = getIntent().getStringExtra("URL");
		} else {
			url = UrlUtils.ZCOOL_JOB;
		}
		
		doAsync(this, this, this);
	}

	/* (non-Javadoc)
	 * @see com.open.android.activity.CommonFragmentActivity#bindEvent()
	 */
	@Override
	protected void bindEvent() {
		// TODO Auto-generated method stub
		super.bindEvent();
		tagcontainerLayouth.setOnTagClickListener(new OnTagClickListener() {
			
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
		tagcontainerLayoutd.setOnTagClickListener(new OnTagClickListener() {
			
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
		tagcontainerLayoutm.setOnTagClickListener(new OnTagClickListener() {
			
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

	/* (non-Javadoc)
	 * @see com.open.android.activity.CommonFragmentActivity#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		super.onClick(v);
	}

	/* (non-Javadoc)
	 * @see com.open.android.activity.BaseFragmentActivity#call()
	 */
	@Override
	public SearchHotJson call() throws Exception {
		// TODO Auto-generated method stub
		SearchHotJson mSearchHotJson = SearchHotService.parseSearchHot(url);
		return mSearchHotJson;
	}

	/* (non-Javadoc)
	 * @see com.open.android.activity.BaseFragmentActivity#onCallback(java.lang.Object)
	 */
	@Override
	public void onCallback(SearchHotJson result) {
		// TODO Auto-generated method stub
		super.onCallback(result);
		tagcontainerLayouth.setTags(result.getHotlist());
		tagcontainerLayoutd.setTags(result.getDesignerlist());
		tagcontainerLayoutm.setTags(result.getManagerlist());
	}
	
	public static void startSearchHotFragmentActivity(Context context, String url) {
		Intent intent = new Intent();
		intent.putExtra("URL", url);
		intent.setClass(context, SearchHotFragmentActivity.class);
		context.startActivity(intent);
	}
	
}
