/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-3下午4:02:03
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.zcool.json;

import java.util.ArrayList;
import java.util.List;

import com.open.android.json.CommonJson;
import com.open.zcool.bean.IndexFocusBean;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-3下午4:02:03
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class IndexFocusJson extends CommonJson {
	private List<IndexFocusBean> list = new ArrayList<IndexFocusBean>();

	public List<IndexFocusBean> getList() {
		return list;
	}

	public void setList(List<IndexFocusBean> list) {
		this.list = list;
	}

}
