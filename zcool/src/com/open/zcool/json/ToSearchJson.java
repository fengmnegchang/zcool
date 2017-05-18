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
import com.open.zcool.bean.HellorfSearchBean;

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
public class ToSearchJson extends CommonJson {
	private List<String> olist = new ArrayList<String>();//推荐您搜原创
	private List<String> mlist= new ArrayList<String>();//推荐您搜素材
	private List<String> plist= new ArrayList<String>();//page条件
	private List<HellorfSearchBean> pagerlist = new ArrayList<HellorfSearchBean>();
	
	public List<String> getOlist() {
		return olist;
	}
	public void setOlist(List<String> olist) {
		this.olist = olist;
	}
	public List<String> getMlist() {
		return mlist;
	}
	public void setMlist(List<String> mlist) {
		this.mlist = mlist;
	}
	public List<String> getPlist() {
		return plist;
	}
	public void setPlist(List<String> plist) {
		this.plist = plist;
	}
	public List<HellorfSearchBean> getPagerlist() {
		return pagerlist;
	}
	public void setPagerlist(List<HellorfSearchBean> pagerlist) {
		this.pagerlist = pagerlist;
	}

	 

}
