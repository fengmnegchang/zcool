/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-9下午3:30:21
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

/**
 ***************************************************************************************************************************************************************************** 
 * 
 * @author :fengguangjing
 * @createTime:2017-2-9下午3:30:21
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 ***************************************************************************************************************************************************************************** 
 */
public class SearchHotJson extends CommonJson {
	private List<String> hotlist = new ArrayList<String>();
	private List<String> designerlist= new ArrayList<String>();
	private List<String> managerlist= new ArrayList<String>();

	public List<String> getHotlist() {
		return hotlist;
	}

	public void setHotlist(List<String> hotlist) {
		this.hotlist = hotlist;
	}

	public List<String> getDesignerlist() {
		return designerlist;
	}

	public void setDesignerlist(List<String> designerlist) {
		this.designerlist = designerlist;
	}

	public List<String> getManagerlist() {
		return managerlist;
	}

	public void setManagerlist(List<String> managerlist) {
		this.managerlist = managerlist;
	}

}
