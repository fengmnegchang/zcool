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
package com.open.zcool.activity.m;

import java.net.URLEncoder;

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
 * m搜索条件
 * @author :fengguangjing
 * @createTime:2017-2-9下午3:13:26
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class MSearchEditFragmentActivity extends CommonFragmentActivity<SearchHotJson>  {

	private EditText edit_search;
	private Button btn_search;
	/* (non-Javadoc)
	 * @see com.open.android.activity.CommonFragmentActivity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_m_search_edit);
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
			url = UrlUtils.ZCOOL_M_TO_SEARCH;
		}
		
//		doAsync(this, this, this);
	}

	/* (non-Javadoc)
	 * @see com.open.android.activity.CommonFragmentActivity#bindEvent()
	 */
	@Override
	protected void bindEvent() {
		// TODO Auto-generated method stub
		super.bindEvent();
		btn_search.setOnClickListener(this);
	}

	/* (non-Javadoc)
	 * @see com.open.android.activity.CommonFragmentActivity#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		super.onClick(v);
		switch (v.getId()) {
		case R.id.btn_search:
			startSearch(edit_search.getText().toString());
			break;
		default:
			break;
		}
	}
	
	public void startSearch(String keys){
		try {
			keys = URLEncoder.encode(keys, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		//world=%E7%BE%8E%E5%A5%B3&closeUrl=/
		String kurl = UrlUtils.ZCOOL_M_TO_SEARCH_EDIT+"world="+keys+"&closeUrl=/";
		ZcoolMToSearchIndicatorFragmentActivity.startZcoolMToSearchIndicatorFragmentActivity(this, kurl);
	}

 
	
	public static void startMSearchEditFragmentActivity(Context context, String url) {
		Intent intent = new Intent();
		intent.putExtra("URL", url);
		intent.setClass(context, MSearchEditFragmentActivity.class);
		context.startActivity(intent);
	}
	
}
