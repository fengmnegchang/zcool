/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-10上午11:01:29
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.zcool.json;

import java.util.ArrayList;
import java.util.List;

import com.jayfang.dropdownmenu.DropItemBean;
import com.open.android.json.CommonJson;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-10上午11:01:29
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class SearchPostJson extends CommonJson {
	public List<DropItemBean> items = new ArrayList<DropItemBean>();

	public List<DropItemBean> getItems() {
		return items;
	}

	public void setItems(List<DropItemBean> items) {
		this.items = items;
	}
	
	
}
