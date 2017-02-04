/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-4上午10:00:39
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
 * <li class="layout borderNone" style="padding-left:20px">
                            	<a href="http://www.zcool.com.cn/u/569990" class="pLeft image-link" target="_blank">
									<img src="http://img.zcool.cn/community/04c2b355405f690000017c506fd0ba.jpg@48w_48h_2o_100sh.jpg" width="48" height="48" alt="TOO扑热稀痛"/>
								</a>
                            	<p class="pRight c999">
									<a href="http://www.zcool.com.cn/u/569990" class="c666" target="_blank">TOO扑热稀痛</a><br/>
									北京市 / 绘画/插画师<br/>粉丝：3135 / 作品：21
								</p>
							</li>

 * @author :fengguangjing
 * @createTime:2017-2-4上午10:00:39
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class DesignerBean extends CommonBean {
	private String href;
	private String src;
	private String pRight;
	
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
	public String getpRight() {
		return pRight;
	}
	public void setpRight(String pRight) {
		this.pRight = pRight;
	}
	
}
