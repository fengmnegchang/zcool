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
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.open.android.activity.CommonFragmentActivity;
import com.open.zcool.R;
import com.open.zcool.adapter.TravelPinnedSectionListAdapter;
import com.open.zcool.bean.TravelCityBean;
import com.open.zcool.json.TravelGroupJson;
import com.open.zcool.jsoup.TravelService;
import com.open.zcool.utils.UrlUtils;
import com.open.zcool.widget.PinnedSectionListView;

/**
 ***************************************************************************************************************************************************************************** 
 * 海洛旅游城市
 * 
 * @author :fengguangjing
 * @createTime:2017-2-17下午2:54:24
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 ***************************************************************************************************************************************************************************** 
 */
public class HellorfTravelCitySectionListFragmentActivity extends CommonFragmentActivity<TravelGroupJson> implements OnClickListener {
	PinnedSectionListView mPinnedSectionListView;
	List<TravelCityBean> list = new ArrayList<TravelCityBean>();
	TravelPinnedSectionListAdapter mTravelPinnedSectionListAdapter;
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
		setContentView(R.layout.activity_hellorf_travel_city);
		init();
		if (savedInstanceState != null) {
		    isFastScroll = savedInstanceState.getBoolean("isFastScroll");
		    addPadding = savedInstanceState.getBoolean("addPadding");
		    isShadowVisible = savedInstanceState.getBoolean("isShadowVisible");
		    hasHeaderAndFooter = savedInstanceState.getBoolean("hasHeaderAndFooter");
		}
		initializeHeaderAndFooter();
		initializeAdapter();
		initializePadding();
	}
	
	/* (non-Javadoc)
	 * @see com.open.android.activity.CommonFragmentActivity#findView()
	 */
	@Override
	protected void findView() {
		// TODO Auto-generated method stub
		super.findView();
		mPinnedSectionListView = (PinnedSectionListView) findViewById(R.id.sectionlist);
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.enrz.activity.CommonFragmentActivity#initValue()
	 */
	@Override
	protected void initValue() {
		// TODO Auto-generated method stub
		if (getIntent().getStringExtra("URL") != null) {
			url = getIntent().getStringExtra("URL");
		} else {
			url = UrlUtils.HELLO_RF_TRAVEL;
		}
		mTravelPinnedSectionListAdapter = new TravelPinnedSectionListAdapter(this, list);
//		addfragment();
		doAsync(this, this, this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.android.activity.CommonFragmentActivity#addfragment()
	 */
	@Override
	public void addfragment() {
		// TODO Auto-generated method stub
//		Fragment fragment = HellorfTravelCityFragment.newInstance(url, true);
//		getSupportFragmentManager().beginTransaction().replace(R.id.id_common_fragment, fragment).commit();
	}
	

//    static class SimpleAdapter extends ArrayAdapter<Item> implements PinnedSectionListAdapter {
//
//        private static final int[] COLORS = new int[] {
//            R.color.green_light, R.color.orange_light,
//            R.color.blue_light, R.color.red_light };
//
//        public SimpleAdapter(Context context, int resource, int textViewResourceId) {
//            super(context, resource, textViewResourceId);
//            generateDataset('A', 'Z', false);
//        }
//
//        public void generateDataset(char from, char to, boolean clear) {
//
//        	if (clear) clear();
//
//            final int sectionsNumber = to - from + 1;
//            prepareSections(sectionsNumber);
//
//            int sectionPosition = 0, listPosition = 0;
//            for (char i=0; i<sectionsNumber; i++) {
//                Item section = new Item(Item.SECTION, String.valueOf((char)('A' + i)));
//                section.sectionPosition = sectionPosition;
//                section.listPosition = listPosition++;
//                onSectionAdded(section, sectionPosition);
//                add(section);
//
//                final int itemsNumber = (int) Math.abs((Math.cos(2f*Math.PI/3f * sectionsNumber / (i+1f)) * 25f));
//                for (int j=0;j<itemsNumber;j++) {
//                    Item item = new Item(Item.ITEM, section.text.toUpperCase(Locale.ENGLISH) + " - " + j);
//                    item.sectionPosition = sectionPosition;
//                    item.listPosition = listPosition++;
//                    add(item);
//                }
//
//                sectionPosition++;
//            }
//        }
//
//        protected void prepareSections(int sectionsNumber) { }
//        protected void onSectionAdded(Item section, int sectionPosition) { }
//
//        @Override public View getView(int position, View convertView, ViewGroup parent) {
//            TextView view = (TextView) super.getView(position, convertView, parent);
//            view.setTextColor(Color.DKGRAY);
//            view.setTag("" + position);
//            Item item = getItem(position);
//            if (item.type == Item.SECTION) {
//                //view.setOnClickListener(PinnedSectionListActivity.this);
//                view.setBackgroundColor(parent.getResources().getColor(COLORS[item.sectionPosition % COLORS.length]));
//            }
//            return view;
//        }
//
//        @Override public int getViewTypeCount() {
//            return 2;
//        }
//
//        @Override public int getItemViewType(int position) {
//            return getItem(position).type;
//        }
//
//        @Override
//        public boolean isItemViewTypePinned(int viewType) {
//            return viewType == Item.SECTION;
//        }
//
//    }

//    static class FastScrollAdapter extends SimpleAdapter implements SectionIndexer {
//
//        private Item[] sections;
//
//        public FastScrollAdapter(Context context, int resource, int textViewResourceId) {
//            super(context, resource, textViewResourceId);
//        }
//
//        @Override protected void prepareSections(int sectionsNumber) {
//            sections = new Item[sectionsNumber];
//        }
//
//        @Override protected void onSectionAdded(Item section, int sectionPosition) {
//            sections[sectionPosition] = section;
//        }
//
//        @Override public Item[] getSections() {
//            return sections;
//        }
//
//        @Override public int getPositionForSection(int section) {
//            if (section >= sections.length) {
//                section = sections.length - 1;
//            }
//            return sections[section].listPosition;
//        }
//
//        @Override public int getSectionForPosition(int position) {
//            if (position >= getCount()) {
//                position = getCount() - 1;
//            }
//            return getItem(position).sectionPosition;
//        }
//
//    }

//	static class Item {
//
//		public static final int ITEM = 0;
//		public static final int SECTION = 1;
//
//		public final int type;
//		public final String text;
//
//		public int sectionPosition;
//		public int listPosition;
//
//		public Item(int type, String text) {
//		    this.type = type;
//		    this.text = text;
//		}
//
//		@Override public String toString() {
//			return text;
//		}
//
//	}

	private boolean hasHeaderAndFooter;
	private boolean isFastScroll;
	private boolean addPadding;
	private boolean isShadowVisible = true;
	private int mDatasetUpdateCount;

 
    @Override
	protected void onSaveInstanceState(Bundle outState) {
	    super.onSaveInstanceState(outState);
	    outState.putBoolean("isFastScroll", isFastScroll);
	    outState.putBoolean("addPadding", addPadding);
	    outState.putBoolean("isShadowVisible", isShadowVisible);
	    outState.putBoolean("hasHeaderAndFooter", hasHeaderAndFooter);
	}

//	@Override
//	protected void onListItemClick(ListView l, View v, int position, long id) {
//	    Item item = (Item) getListView().getAdapter().getItem(position);
//	    if (item != null) {
//	        Toast.makeText(this, "Item " + position + ": " + item.text, Toast.LENGTH_SHORT).show();
//	    } else {
//	        Toast.makeText(this, "Item " + position, Toast.LENGTH_SHORT).show();
//	    }
//	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		getMenuInflater().inflate(R.menu.main, menu);
//		menu.getItem(0).setChecked(isFastScroll);
//		menu.getItem(1).setChecked(addPadding);
//		menu.getItem(2).setChecked(isShadowVisible);
//		return true;
//	}
//
//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//	    switch (item.getItemId()) {
//    	    case R.id.action_fastscroll:
//    	        isFastScroll = !isFastScroll;
//    	        item.setChecked(isFastScroll);
//    	        initializeAdapter();
//    	        break;
//    	    case R.id.action_addpadding:
//    	        addPadding = !addPadding;
//    	        item.setChecked(addPadding);
//    	        initializePadding();
//    	        break;
//    	    case R.id.action_showShadow:
//    	        isShadowVisible = !isShadowVisible;
//    	        item.setChecked(isShadowVisible);
//    	        ((PinnedSectionListView)getListView()).setShadowVisible(isShadowVisible);
//    	        break;
//    	    case R.id.action_showHeaderAndFooter:
//    	        hasHeaderAndFooter = !hasHeaderAndFooter;
//    	        item.setChecked(hasHeaderAndFooter);
//    	        initializeHeaderAndFooter();
//    	        break;
//    	    case R.id.action_updateDataset:
//    	    	updateDataset();
//    	    	break;
//	    }
//	    return true;
//	}

//	private void updateDataset() {
//		mDatasetUpdateCount++;
//		SimpleAdapter adapter = (SimpleAdapter) mPinnedSectionListView.getAdapter();
//		switch (mDatasetUpdateCount % 4) {
//			case 0: adapter.generateDataset('A', 'B', true); break;
//			case 1: adapter.generateDataset('C', 'M', true); break;
//			case 2: adapter.generateDataset('P', 'Z', true); break;
//			case 3: adapter.generateDataset('A', 'Z', true); break;
//		}
//		adapter.notifyDataSetChanged();
//	}

	private void initializePadding() {
	    float density = getResources().getDisplayMetrics().density;
	    int padding = addPadding ? (int) (16 * density) : 0;
	    mPinnedSectionListView.setPadding(padding, padding, padding, padding);
	}

    private void initializeHeaderAndFooter() {
//        setListAdapter(null);
    	mPinnedSectionListView.setAdapter(null);
        if (hasHeaderAndFooter) {
//            ListView list = getListView();

            LayoutInflater inflater = LayoutInflater.from(this);
            TextView header1 = (TextView) inflater.inflate(android.R.layout.simple_list_item_1, mPinnedSectionListView, false);
            header1.setText("First header");
            mPinnedSectionListView.addHeaderView(header1);

            TextView header2 = (TextView) inflater.inflate(android.R.layout.simple_list_item_1, mPinnedSectionListView, false);
            header2.setText("Second header");
            mPinnedSectionListView.addHeaderView(header2);

            TextView footer = (TextView) inflater.inflate(android.R.layout.simple_list_item_1, mPinnedSectionListView, false);
            footer.setText("Single footer");
            mPinnedSectionListView.addFooterView(footer);
        }
        initializeAdapter();
    }

    @SuppressLint("NewApi")
    private void initializeAdapter() {
    	mPinnedSectionListView.setFastScrollEnabled(isFastScroll);
        if (isFastScroll) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            	mPinnedSectionListView.setFastScrollAlwaysVisible(true);
            }
//            setListAdapter(new FastScrollAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1));
//            mPinnedSectionListView.setAdapter(new FastScrollAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1));
        } else {
//            setListAdapter(new SimpleAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1));
//            mPinnedSectionListView.setAdapter(new SimpleAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1));
        	mPinnedSectionListView.setAdapter(mTravelPinnedSectionListAdapter);
        }
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Item: " + v.getTag() , Toast.LENGTH_SHORT).show();
    }

    

	/* (non-Javadoc)
	 * @see com.open.android.activity.BaseFragmentActivity#call()
	 */
	@Override
	public TravelGroupJson call() throws Exception {
		// TODO Auto-generated method stub
		TravelGroupJson mTravelGroupJson = new TravelGroupJson();
		mTravelGroupJson.setList(TravelService.parseSearchHot(url));
		return mTravelGroupJson;
	}

	/* (non-Javadoc)
	 * @see com.open.android.activity.BaseFragmentActivity#onCallback(java.lang.Object)
	 */
	@Override
	public void onCallback(TravelGroupJson result) {
		// TODO Auto-generated method stub
		super.onCallback(result);
		list.clear();
		list.addAll(result.getList());
		mTravelPinnedSectionListAdapter.notifyDataSetChanged();
	}

	/* (non-Javadoc)
	 * @see com.open.android.activity.BaseFragmentActivity#handlerMessage(android.os.Message)
	 */
	@Override
	public void handlerMessage(Message msg) {
		// TODO Auto-generated method stub
		super.handlerMessage(msg);
	}

	public static void startHellorfTravelCitySectionListFragmentActivity(Context context, String url) {
		Intent intent = new Intent();
		intent.putExtra("URL", url);
		intent.setClass(context, HellorfTravelCitySectionListFragmentActivity.class);
		context.startActivity(intent);
	}

}
