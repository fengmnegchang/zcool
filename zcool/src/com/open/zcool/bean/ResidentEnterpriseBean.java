/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-17下午3:36:07
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
 * http://www.zcool.com.cn/job/listVipCompany.do?position=companyindex&pageNo=1&
 * pageSize=10 <li class="item">
 * <div class="pic-box radius opacity"> <a href=
 * "http://www.zcool.com.cn/u/15252437?from=vipcorps&position=companyindex"
 * onClick="clickbutton_log('corpclick','companyindex','',15252437,'image')"
 * target="_blank"> <img
 * src="http://img.zcool.cn/community/04538758a2b7c1a801219c779ef3a3.jpg" /></a>
 * </div> <div class="company-name text-overflow"> <a href=
 * "http://www.zcool.com.cn/u/15252437?from=vipcorps&position=companyindex"
 * onClick="clickbutton_log('corpclick','companyindex','',15252437,'name')"
 * target="_blank" class="f-18 c-282828">智度亦复</a> </div> <div class="f-14 c-666"
 * style="margin-top:10px"> <a href="http://www.zcool.com.cn/u/15252437"
 * onClick=
 * "clickbutton_log('corpclick','companyindex','',15252437,'vipcorppost')"
 * target="_blank" style="color:#666"><strong class="c-ff8600">0</strong>
 * <span>职位正在招聘</span></a> </div ></li>
 * 
 * @author :fengguangjing
 * @createTime:2017-2-17下午3:36:07
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 ***************************************************************************************************************************************************************************** 
 */
public class ResidentEnterpriseBean extends CommonBean {
	private String href;
	private String src;
	private String name;
	private String companyindex;
	private String indexhref;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompanyindex() {
		return companyindex;
	}

	public void setCompanyindex(String companyindex) {
		this.companyindex = companyindex;
	}

	public String getIndexhref() {
		return indexhref;
	}

	public void setIndexhref(String indexhref) {
		this.indexhref = indexhref;
	}

}
