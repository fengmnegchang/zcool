/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-5-19下午2:47:01
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.zcool.json.m;

import java.util.List;

import com.open.android.json.CommonJson;
import com.open.zcool.bean.m.LeftMenuBean;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-5-19下午2:47:01
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class LeftMenuJson extends CommonJson {
	private List<LeftMenuBean> list;

	public List<LeftMenuBean> getList() {
		return list;
	}

	public void setList(List<LeftMenuBean> list) {
		this.list = list;
	}
	

}
