/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-17下午4:26:36
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
import com.open.zcool.bean.EnterpriseMainBean;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-17下午4:26:36
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class EnterpriseMainJson extends CommonJson {
	private List<EnterpriseMainBean> list = new ArrayList<EnterpriseMainBean>();

	public List<EnterpriseMainBean> getList() {
		return list;
	}

	public void setList(List<EnterpriseMainBean> list) {
		this.list = list;
	}
	
	

}
