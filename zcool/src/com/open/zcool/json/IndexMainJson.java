/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-3下午5:07:03
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
import com.open.zcool.bean.IndexMainBean;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-3下午5:07:03
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class IndexMainJson extends CommonJson {
	private List<IndexMainBean> list = new ArrayList<IndexMainBean>();

	public List<IndexMainBean> getList() {
		return list;
	}

	public void setList(List<IndexMainBean> list) {
		this.list = list;
	}

}
