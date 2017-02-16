/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-10下午6:03:14
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.zcool.activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.open.android.activity.CommonFragmentActivity;
import com.open.android.json.CommonJson;
import com.open.android.utils.CharacterParser;
import com.open.zcool.R;
import com.open.zcool.adapter.sort.SortCityAdapter;
import com.open.zcool.bean.sort.SortModel;
import com.open.zcool.utils.sort.PinyinComparator;
import com.open.zcool.widget.ClearEditText;
import com.open.zcool.widget.SideBar;
import com.open.zcool.widget.SideBar.OnTouchingLetterChangedListener;

/**
 ***************************************************************************************************************************************************************************** 
 * 
 * @author :fengguangjing
 * @createTime:2017-2-10下午6:03:14
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 ***************************************************************************************************************************************************************************** 
 */
public class SortCityListActivity extends CommonFragmentActivity<CommonJson> {
	private ListView sortListView;
	private SideBar sideBar;
	private TextView dialog;
	private SortCityAdapter adapter;
	private ClearEditText mClearEditText;

	/**
	 * 汉字转换成拼音的类
	 */
	private CharacterParser characterParser;
	private List<SortModel> SourceDateHeadList = new ArrayList<SortModel>();
	
	private List<SortModel> TSourceDateList = new ArrayList<SortModel>();
	private List<SortModel> TSourceDateHeadList = new ArrayList<SortModel>();
	/**
	 * 根据拼音来排列ListView里面的数据类
	 */
	private PinyinComparator pinyinComparator;

	private Handler mHandler = new Handler() {
		/*
		 * (non-Javadoc)
		 * 
		 * @see android.os.Handler#handleMessage(android.os.Message)
		 */
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			// SourceDateList =
			// filledData(getResources().getStringArray(R.array.date));
			// 根据a-z进行排序源数据

			adapter.notifyDataSetChanged();
		}

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sort_city_list);
		init();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.android.activity.CommonFragmentActivity#findView()
	 */
	@Override
	protected void findView() {
		// TODO Auto-generated method stub
		super.findView();
		sideBar = (SideBar) findViewById(R.id.sidrbar);
		dialog = (TextView) findViewById(R.id.dialog);
		sortListView = (ListView) findViewById(R.id.country_lvcountry);
		mClearEditText = (ClearEditText) findViewById(R.id.filter_edit);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.android.activity.CommonFragmentActivity#initValue()
	 */
	@Override
	protected void initValue() {
		// TODO Auto-generated method stub
		super.initValue();
		// 实例化汉字转拼音类
		characterParser = CharacterParser.getInstance();
		pinyinComparator = new PinyinComparator();
		sideBar.setTextView(dialog);
		adapter = new SortCityAdapter(this, SourceDateHeadList);
		sortListView.setAdapter(adapter);

		new Thread() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see java.lang.Thread#run()
			 */
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				citydata();
				Collections.sort(TSourceDateList, pinyinComparator);
				
				SourceDateHeadList.clear();
				SourceDateHeadList.addAll(TSourceDateHeadList);
				SourceDateHeadList.addAll(TSourceDateList);
				mHandler.sendEmptyMessage(1000);
			}

		}.start();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.android.activity.CommonFragmentActivity#bindEvent()
	 */
	@Override
	protected void bindEvent() {
		// TODO Auto-generated method stub
		super.bindEvent();
		// 设置右侧触摸监听
		sideBar.setOnTouchingLetterChangedListener(new OnTouchingLetterChangedListener() {

			@Override
			public void onTouchingLetterChanged(String s) {
				// 该字母首次出现的位置
				int position = adapter.getPositionForSection(s.charAt(0));
				if (position != -1) {
					sortListView.setSelection(position);
				}

			}
		});
		sortListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// 这里要利用adapter.getItem(position)来获取当前position所对应的对象
				Toast.makeText(getApplication(), ((SortModel) adapter.getItem(position)).getName(), Toast.LENGTH_SHORT).show();
			}
		});
		// 根据输入框输入值的改变来过滤搜索
		mClearEditText.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// 当输入框里面的值为空，更新为原来的列表，否则为过滤数据列表
				filterData(s.toString());
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}

			@Override
			public void afterTextChanged(Editable s) {
			}
		});
	}

	private void citydata() {
		try {
			InputStream inputStream = getAssets().open("city.txt");
			InputStreamReader inputStreamReader = null;
			try {
				inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			BufferedReader reader = new BufferedReader(inputStreamReader);
			StringBuffer sb = new StringBuffer("");
			String line;
			try {
				while ((line = reader.readLine()) != null) {
					SortModel sortModel = new SortModel();
					sb.append(line);

					String code = line.substring(0, 7).replace("　", "").replace(" ", "");
					String name = line.substring(7, line.length()).replace("　", "").replace(" ", "");
					sortModel.setName(name);
					sortModel.setCode(code);

					// 汉字转换成拼音
					String pinyin = characterParser.getSelling(name);
					String sortString = pinyin.substring(0, 1).toUpperCase();

					// 正则表达式，判断首字母是否是英文字母
					if (sortString.matches("[A-Z]")) {
						sortModel.setSortLetters(sortString.toUpperCase());
						if (name.equals("市辖区") || name.equals("城区") || name.equals("矿区")) {

						} else {
							if (code.endsWith("000")) {
								if (name.equals("北京市") || name.equals("天津市") || name.equals("重庆市") || name.equals("深圳市") || name.equals("台湾省") || name.equals("香港特别行政区") || name.equals("澳门特别行政区")) {
									TSourceDateList.add(sortModel);
								}
							} else {
								TSourceDateList.add(sortModel);
							}
						}
					} else {
						if (name.startsWith("#c")) {
							sortModel.setName(name.replace("#c", ""));
							sortModel.setSortLetters("当前");
						} else if (name.startsWith("#h")) {
							sortModel.setName(name.replace("#h", ""));
							sortModel.setSortLetters("历史");
						} else if (name.startsWith("#r")) {
							sortModel.setName(name.replace("#r", ""));
							sortModel.setSortLetters("热门");
						} else {
							sortModel.setSortLetters("#");
						}
						TSourceDateHeadList.add(sortModel);
					}

					sb.append("\n");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 为ListView填充数据
	 * 
	 * @param date
	 * @return
	 */
	private List<SortModel> filledData(String[] date) {
		List<SortModel> mSortList = new ArrayList<SortModel>();

		for (int i = 0; i < date.length; i++) {
			SortModel sortModel = new SortModel();
			sortModel.setName(date[i]);
			// 汉字转换成拼音
			String pinyin = characterParser.getSelling(date[i]);
			String sortString = pinyin.substring(0, 1).toUpperCase();

			// 正则表达式，判断首字母是否是英文字母
			if (sortString.matches("[A-Z]")) {
				sortModel.setSortLetters(sortString.toUpperCase());
			} else {
				sortModel.setSortLetters("#");
			}

			mSortList.add(sortModel);
		}
		return mSortList;

	}

	/**
	 * 根据输入框中的值来过滤数据并更新ListView
	 * 
	 * @param filterStr
	 */
	private void filterData(String filterStr) {
		List<SortModel> filterDateList = new ArrayList<SortModel>();
		List<SortModel> filterDateList2 = new ArrayList<SortModel>();
		filterDateList2.clear();
		filterDateList2.addAll(TSourceDateHeadList);
		if (TextUtils.isEmpty(filterStr)) {
			filterDateList.clear();
			filterDateList.addAll(TSourceDateList);
		} else {
			filterDateList.clear();
			for (SortModel sortModel : TSourceDateList) {
				String name = sortModel.getName();
				if (name.indexOf(filterStr.toString()) != -1 || characterParser.getSelling(name).startsWith(filterStr.toString())) {
					filterDateList.add(sortModel);
				}
			}
		}

		// 根据a-z进行排序
		Collections.sort(filterDateList, pinyinComparator);
		filterDateList2.addAll(filterDateList);
		adapter.updateListView(filterDateList2);
	}

}