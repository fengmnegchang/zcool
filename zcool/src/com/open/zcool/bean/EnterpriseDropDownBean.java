/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-17下午4:28:11
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
 * <div class="dropDown-item"> <a href="http://www.zcool.com.cn/job/posts/9086.html?from=corp_list" 
 * target="_blank">
<div class="dt">
<span class="f-14 c-282828 text-overflow" style="display: inline-block;width: 120px;vertical-align: middle;">
空间设计师助理/实习生</span>
 <span class="f-12 c-999 publish-time">5小时前发布</span></div>
<div class="dd">
<strong class="f-14" style="color:#ff8600">3k-5k</strong> 
<span class="f-12 c-999">/ 应届毕业生 / 本科</span></div>
</a> </div>

 * @author :fengguangjing
 * @createTime:2017-2-17下午4:28:11
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class EnterpriseDropDownBean extends CommonBean{
	private String href;
	private String dt;
	private String dd;
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getDt() {
		return dt;
	}
	public void setDt(String dt) {
		this.dt = dt;
	}
	public String getDd() {
		return dd;
	}
	public void setDd(String dd) {
		this.dd = dd;
	}

}
