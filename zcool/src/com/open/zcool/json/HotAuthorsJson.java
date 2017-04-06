/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-4-6下午4:37:35
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
import com.open.zcool.bean.HotAuthorsBean;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-4-6下午4:37:35
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class HotAuthorsJson extends CommonJson {
	private List<HotAuthorsBean> list = new ArrayList<HotAuthorsBean>();

	public List<HotAuthorsBean> getList() {
		return list;
	}

	public void setList(List<HotAuthorsBean> list) {
		this.list = list;
	}

}
