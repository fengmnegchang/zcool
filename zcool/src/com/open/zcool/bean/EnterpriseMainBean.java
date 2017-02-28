/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-17下午4:25:48
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.zcool.bean;

import java.util.ArrayList;
import java.util.List;

import com.open.android.bean.CommonBean;

/**
 *****************************************************************************************************************************************************************************
 <div class="item bg-fff box-shadow radius">
	<div class="item-body clearfix">
		<div class="pic-box radius opacity"> <a href="http://www.zcool.com.cn/u/245614" onClick="clickbutton_log('corpclick','corplist','',245614,'image')" target="_blank"><img src="http://img.zcool.cn/job/company/300756ea5b0b00000122770bb7a4"></a> </div>
		<div class="text-box">
			<div style="margin-top: -5px;"> <a class="f-18 c-282828" href="http://www.zcool.com.cn/u/245614" onClick="clickbutton_log('corpclick','corplist','',245614,'name')" target="_blank">表情云</a> 
			<span class="f-14 c-666 ml-10">集结全国表情达人，共建表情云平台</span> 
			</div>
			<div class="mt-5 f-14 c-666" style="margin-top: 8px;"> 
			<i class="iconpic iconpic-com-address"></i> 
			<span>上海市</span>
			 	<i class="iconpic iconpic-com-bao ml-30"></i> 
				<span> 互联网</span> 
			<i class="iconpic iconpic-com-price ml-30"></i> <span>1-50人</span>
				<div class="dropDown ml-30 dropDown_hover" style="display:inline-block">
				 <a style="cursor:pointer; text-decoration: none;" target="_blank" href="http://www.zcool.com.cn/u/245614"><i class="iconpic iconpic-com-user"></i> <strong class="c-ff8600">6</strong><span>职位正在招聘</span></a>
				</div>
			</div>
		</div>
		<a href="http://www.zcool.com.cn/u/245614" onClick="clickbutton_log('corpclick','corplist','',245614,'indexbutton')" target="_blank" class="btn btn-default3 radius btn-team-home">企业主页</a> </div>
	<div class="item-footer">
		<div class="job-tags"> 
     <span>赴日培训 </span>  <span>大大指导 </span>  <span>项目奖金 </span>  <span>半年涨薪 </span>  <span>旅游福利 </span>  <span>五险一金 </span>  <span>节日福利 </span>  <span>带薪年假 </span>   
		 </div>
	</div>
</div>
 * @author :fengguangjing
 * @createTime:2017-2-17下午4:25:48
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class EnterpriseMainBean extends CommonBean {
	private String href;
	private String src;
	private String title;
	private String mt;
	private String tags;
	private List<EnterpriseDropDownBean> dropDownitemllist = new ArrayList<EnterpriseDropDownBean>();
	
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMt() {
		return mt;
	}
	public void setMt(String mt) {
		this.mt = mt;
	}
	 
	public List<EnterpriseDropDownBean> getDropDownitemllist() {
		return dropDownitemllist;
	}
	public void setDropDownitemllist(List<EnterpriseDropDownBean> dropDownitemllist) {
		this.dropDownitemllist = dropDownitemllist;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}

}
