/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-5-19上午10:50:56
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.zcool.json;

import java.util.List;

import com.open.android.json.CommonJson;
import com.open.zcool.bean.CitySpotBean;

/**
 ***************************************************************************************************************************************************************************** 
 * 
 * @author :fengguangjing
 * @createTime:2017-5-19上午10:50:56
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 ***************************************************************************************************************************************************************************** 
 */
public class CitySpotJson extends CommonJson {
	private List<CitySpotBean> list;

	public List<CitySpotBean> getList() {
		return list;
	}

	public void setList(List<CitySpotBean> list) {
		this.list = list;
	}
	
	
}
