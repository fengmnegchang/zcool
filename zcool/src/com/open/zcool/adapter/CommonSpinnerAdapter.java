/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-3-1下午2:53:46
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.zcool.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import antistatic.spinnerwheel.adapters.AbstractWheelTextAdapter;

import com.open.zcool.R;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-3-1下午2:53:46
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class CommonSpinnerAdapter<T> extends AbstractWheelTextAdapter{
	public List<T> list;
	public Context mContext;
	
	public CommonSpinnerAdapter(Context context,List<T> list){
		 super(context, R.layout.adapter_page_spinner_item, NO_RESOURCE);
         setItemTextResource(R.id.name);
         this.mContext = context;
         this.list = list;
	}

	protected CommonSpinnerAdapter(Context context) {
         super(context, R.layout.adapter_page_spinner_item, NO_RESOURCE);
         setItemTextResource(R.id.name);
     }
	 
	  @Override
      public View getItem(int index, View cachedView, ViewGroup parent, int currentItemIdx) {
          View view = super.getItem(index, cachedView, parent, currentItemIdx);
          ImageView img = (ImageView) view.findViewById(R.id.flag);
//          img.setImageResource(flags[index]);
          return view;
      }
      
      @Override
      public int getItemsCount() {
          return list.size();
      }
      
      @Override
      protected CharSequence getItemText(int index) {
          return null;
      }

}
