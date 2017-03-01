/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-3-1上午11:01:16
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
import com.open.zcool.bean.ToSearchMainBean;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-3-1上午11:01:16
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class ToSearchMainJson extends CommonJson {
	private List<ToSearchMainBean> list = new ArrayList<ToSearchMainBean>();

	public List<ToSearchMainBean> getList() {
		return list;
	}

	public void setList(List<ToSearchMainBean> list) {
		this.list = list;
	}

}
