/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-16上午9:45:14
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.zcool.fragment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.open.android.fragment.BaseV4Fragment;
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
 * @createTime:2017-2-16上午9:45:14
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 ***************************************************************************************************************************************************************************** 
 */
public class SortCityFragment extends BaseV4Fragment<CommonJson, SortCityFragment> {
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

	public static SortCityFragment newInstance(String url, boolean isVisibleToUser) {
		SortCityFragment fragment = new SortCityFragment();
		fragment.setFragment(fragment);
		fragment.setUserVisibleHint(isVisibleToUser);
		fragment.url = url;
		return fragment;
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_sort_city_list, container, false);
		sideBar = (SideBar) view.findViewById(R.id.sidrbar);
		dialog = (TextView) view.findViewById(R.id.dialog);
		sortListView = (ListView) view.findViewById(R.id.country_lvcountry);
		mClearEditText = (ClearEditText) view.findViewById(R.id.filter_edit);
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
		// 实例化汉字转拼音类
		characterParser = CharacterParser.getInstance();
		pinyinComparator = new PinyinComparator();
		sideBar.setTextView(dialog);
		
		adapter = new SortCityAdapter(getActivity(), SourceDateHeadList);
		sortListView.setAdapter(adapter);
		
		
		
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.android.fragment.BaseV4Fragment#bindEvent()
	 */
	@Override
	public void bindEvent() {
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
				Toast.makeText(getActivity(), ((SortModel) adapter.getItem(position)).getName(), Toast.LENGTH_SHORT).show();
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
		case 1005:
			adapter.notifyDataSetChanged();
			break;
		case MESSAGE_HANDLER:
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
					weakReferenceHandler.sendEmptyMessage(1005);
				}

			}.start();
			break;
		default:
			break;
		}
	}

	private void citydata() {
		try {
			InputStream inputStream = getActivity().getAssets().open("city.txt");
			InputStreamReader inputStreamReader = null;
			try {
				inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			BufferedReader reader = new BufferedReader(inputStreamReader);
			StringBuffer sb = new StringBuffer("");
			String line;
			int i=0;
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
					System.out.println("i=="+i+";"+pinyin);
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
					i++;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
//			System.out.println(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
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
