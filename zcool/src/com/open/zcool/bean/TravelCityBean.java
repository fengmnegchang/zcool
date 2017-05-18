/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-5-18下午4:30:07
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.zcool.bean;

import com.open.android.bean.CommonBean;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-5-18下午4:30:07
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class TravelCityBean extends CommonBean {
	private String name;
	private String href;
	private int sectiontype;
	private int typecolor;
	
	public int getTypecolor() {
		return typecolor;
	}
	public void setTypecolor(int typecolor) {
		this.typecolor = typecolor;
	}
	public int getSectiontype() {
		return sectiontype;
	}
	public void setSectiontype(int sectiontype) {
		this.sectiontype = sectiontype;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	

}
