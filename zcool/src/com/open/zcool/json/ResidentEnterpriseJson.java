/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-17下午3:39:44
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
import com.open.zcool.bean.ResidentEnterpriseBean;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-17下午3:39:44
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class ResidentEnterpriseJson extends CommonJson {
	private List<ResidentEnterpriseBean> list = new ArrayList<ResidentEnterpriseBean>();

	public List<ResidentEnterpriseBean> getList() {
		return list;
	}

	public void setList(List<ResidentEnterpriseBean> list) {
		this.list = list;
	}

}
