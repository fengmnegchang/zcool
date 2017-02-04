/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-4上午11:00:58
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
import com.open.zcool.bean.DesignerTabBean;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-4上午11:00:58
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class DesignerTabJson extends CommonJson {
	private List<DesignerTabBean> list = new ArrayList<DesignerTabBean>();

	public List<DesignerTabBean> getList() {
		return list;
	}

	public void setList(List<DesignerTabBean> list) {
		this.list = list;
	}
	
	
}
