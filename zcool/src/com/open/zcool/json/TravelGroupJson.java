/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-5-18下午4:31:16
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.zcool.json;

import java.util.List;

import com.open.android.json.CommonJson;
import com.open.zcool.bean.TravelCityBean;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-5-18下午4:31:16
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class TravelGroupJson extends CommonJson {
	private List<TravelCityBean> list;

	public List<TravelCityBean> getList() {
		return list;
	}

	public void setList(List<TravelCityBean> list) {
		this.list = list;
	}
	

}
