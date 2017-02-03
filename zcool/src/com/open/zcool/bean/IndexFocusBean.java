/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-3下午4:00:03
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
 * pc 导航
 *  <li>
	  <a st_t="click" st_n="index_focus_1" href="http://www.hellorf.com/inspiration/unplugged?source=unplugged&term=zcool " target="_blank" class="image-link">
	  	<img src="http://img.zcool.cn/community/focus/ce7d5893e5b000000174c8302998.jpg" width="1083" height="350" alt="站酷精选图片"/>
	  </a>
  </li>
 * @author :fengguangjing
 * @createTime:2017-2-3下午4:00:03
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 ***************************************************************************************************************************************************************************** 
 */
public class IndexFocusBean extends CommonBean {
	private String href;
	private String src;
	private String alt;
	
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getAlt() {
		return alt;
	}
	public void setAlt(String alt) {
		this.alt = alt;
	}
	
	

}
