/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-5-17下午3:10:16
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.zcool.json;

import java.util.List;

import com.open.android.json.CommonJson;
import com.open.zcool.bean.HellorfSearchBean;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-5-17下午3:10:16
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class HellorfSearchJson extends CommonJson {
	private List<HellorfSearchBean> list;

	public List<HellorfSearchBean> getList() {
		return list;
	}

	public void setList(List<HellorfSearchBean> list) {
		this.list = list;
	}
	

}
