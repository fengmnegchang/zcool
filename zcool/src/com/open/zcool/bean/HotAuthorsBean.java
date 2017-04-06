/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-4-6下午4:34:40
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
 * <li>
	<span class='hasFlagSpan yellow '>1</span>
	<a href="http://zhongenhui.zcool.com.cn" title="zhongenhui" class="fLeft mr10 image-link" target="_blank">
		<img src="http://img.zcool.cn/community/0480e1587c3163a8010ec63c004193.jpg@64w_64h_2o_100sh.jpg" alt="zhongenhui" width="64" height="64"/>
	</a>
	<div><a href="http://zhongenhui.zcool.com.cn" title="zhongenhui" target="_blank" class="f14 c666">zhongenhui</a>
		<p class="c666">美国 / 学生</p>
	</div>
</li>
 * @author :fengguangjing
 * @createTime:2017-4-6下午4:34:40
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class HotAuthorsBean extends CommonBean{
	private String href;
	private String title;
	private String src;
	private String divp;
	
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getDivp() {
		return divp;
	}
	public void setDivp(String divp) {
		this.divp = divp;
	}

}
