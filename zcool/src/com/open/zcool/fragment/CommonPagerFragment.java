/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-3下午4:37:08
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
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.open.android.fragment.BaseV4Fragment;
import com.open.zcool.R;
import com.open.zcool.adapter.IndexFocusPagerAdapter;
import com.open.zcool.bean.IndexFocusBean;
import com.open.zcool.json.IndexFocusJson;
import com.open.zcool.jsoup.IndexFocusService;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-3下午4:37:08
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class CommonPagerFragment extends BaseV4Fragment<IndexFocusJson, CommonPagerFragment>implements OnPageChangeListener{
	public ViewPager viewpager;
	public List<IndexFocusBean> list = new ArrayList<IndexFocusBean>();
	public IndexFocusPagerAdapter mIndexFocusPagerAdapter;
	public ImageView[] dots;
	public int currentIndex;
	public int size;
	public LinearLayout layout_dot;
	
	public static CommonPagerFragment newInstance(String url, boolean isVisibleToUser) {
		CommonPagerFragment fragment = new CommonPagerFragment();
		fragment.setFragment(fragment);
		fragment.setUserVisibleHint(isVisibleToUser);
		fragment.url = url;
		return fragment;
	}
	

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_common_viewpager, container, false);
		viewpager = (ViewPager) view.findViewById(R.id.viewpager);
		layout_dot = (LinearLayout) view.findViewById(R.id.layout_dot);
		return view;
	}
	
	/* (non-Javadoc)
	 * @see com.open.enrz.fragment.BaseV4Fragment#initValues()
	 */
	@Override
	public void initValues() {
		// TODO Auto-generated method stub
		super.initValues();
		mIndexFocusPagerAdapter = new IndexFocusPagerAdapter(getActivity(),list);
		viewpager.setAdapter(mIndexFocusPagerAdapter);
	}
	
	/* (non-Javadoc)
	 * @see com.open.enrz.fragment.BaseV4Fragment#bindEvent()
	 */
	@Override
	public void bindEvent() {
		// TODO Auto-generated method stub
		super.bindEvent();
		viewpager.setOnPageChangeListener(this);
	}


	/* (non-Javadoc)
	 * @see com.open.enrz.fragment.BaseV4Fragment#call()
	 */
	@Override
	public IndexFocusJson call() throws Exception {
		// TODO Auto-generated method stub
		IndexFocusJson mIndexFocusJson = new IndexFocusJson();
		mIndexFocusJson.setList(IndexFocusService.parseIndexFocus(url));
		return mIndexFocusJson;
	}


	/* (non-Javadoc)
	 * @see com.open.enrz.fragment.BaseV4Fragment#onCallback(java.lang.Object)
	 */
	@Override
	public void onCallback(IndexFocusJson result) {
		// TODO Auto-generated method stub
		super.onCallback(result);
		list.clear();
		list.addAll(result.getList());
		mIndexFocusPagerAdapter.notifyDataSetChanged();
		
		 size = result.getList().size();
			dots = new ImageView[size];
			for (int i = 0; i < size; i++) {
				ImageView img = new ImageView(getActivity());
				img.setImageResource(R.drawable.dot);
				img.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
						LayoutParams.WRAP_CONTENT));
				img.setPadding(15, 15, 15, 15);
				img.setClickable(true);
				dots[i] = img;
				dots[i].setEnabled(true);
				dots[i].setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						int position = (Integer) v.getTag();
						setCurView(position);
						setCurDot(position);
					}
				});
				dots[i].setTag(i);

				layout_dot.addView(dots[i]);
			}

			currentIndex = 0;
			dots[currentIndex].setEnabled(false);
			viewpager.setCurrentItem(0);
	}
	
	/**
	 * 设置当前的引导页
	 */
	public void setCurView(int position) {
		if (position < 0 || position >= size) {
			return;
		}

		viewpager.setCurrentItem(position);
	}

	/**
	 * 这只当前引导小点的选中
	 */
	public void setCurDot(int positon) {
		if (positon < 0 || positon > size - 1
				|| currentIndex == positon) {
			return;
		}

		dots[positon].setEnabled(false);
		dots[currentIndex].setEnabled(true);

		currentIndex = positon;
	}
	
	/* (non-Javadoc)
	 * @see android.support.v4.view.ViewPager.OnPageChangeListener#onPageScrollStateChanged(int)
	 */
	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see android.support.v4.view.ViewPager.OnPageChangeListener#onPageScrolled(int, float, int)
	 */
	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see android.support.v4.view.ViewPager.OnPageChangeListener#onPageSelected(int)
	 */
	@Override
	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub
		setCurDot(arg0);
	}
	
	/* (non-Javadoc)
	 * @see com.open.enrz.fragment.BaseV4Fragment#handlerMessage(android.os.Message)
	 */
	@Override
	public void handlerMessage(Message msg) {
		// TODO Auto-generated method stub
		switch (msg.what) {
		case MESSAGE_HANDLER:
			doAsync(this, this, this);
			break;
		default:
			break;
		}
	}
}