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
 * <div class="item bg-fff box-shadow radius">
	<div class="item-body clearfix">
		<div class="pic-box radius opacity"> 
		<a href="http://www.zcool.com.cn/u/2645586" 
		onClick="clickbutton_log('corpclick','corplist','',2645586,'image')" target="_blank">
		<img src="http://img.zcool.cn/community/04c6eb56c9e7060000013428323731.jpg"></a> </div>
		<div class="text-box">
			<div style="margin-top: -5px;"> 
			<a class="f-18 c-282828" href="http://www.zcool.com.cn/u/2645586" 
			onClick="clickbutton_log('corpclick','corplist','',2645586,'name')" target="_blank">RIGI</a> 
			<span class="f-14 c-666 ml-10">RIGI睿集设计</span> 
			</div>
			<div class="mt-5 f-14 c-666" style="margin-top: 8px;"> 
			<i class="iconpic iconpic-com-address"></i> 
			<span>上海市</span>
			 	<i class="iconpic iconpic-com-bao ml-30"></i> 
				<span> 艺术</span> 
			<i class="iconpic iconpic-com-price ml-30"></i> <span>1-50人</span>
				<div class="dropDown ml-30 dropDown_hover" style="display:inline-block">
				 <a style="cursor:pointer; text-decoration: none;" target="_blank" href="http://www.zcool.com.cn/u/2645586"><i class="iconpic iconpic-com-user"></i> <strong class="c-ff8600">9</strong><span>职位正在招聘</span></a>
					<div class="dropDown-menu menu box-shadow">
						<div class="dropDown-item"> <a href="http://www.zcool.com.cn/job/posts/9086.html?from=corp_list" target="_blank">
							<div class="dt"><span class="f-14 c-282828 text-overflow" style="display: inline-block;width: 120px;vertical-align: middle;">空间设计师助理/实习生</span> <span class="f-12 c-999 publish-time">5小时前发布</span></div>
							<div class="dd"><strong class="f-14" style="color:#ff8600">3k-5k</strong> <span class="f-12 c-999">/ 应届毕业生 / 本科</span></div>
							</a> </div>
					</div>
				</div>
			</div>
		</div>
		<a href="http://www.zcool.com.cn/u/2645586"
		 onClick="clickbutton_log('corpclick','corplist','',2645586,'indexbutton')"
		  target="_blank" class="btn btn-default3 radius btn-team-home">企业主页</a> </div>
	<div class="item-footer">
		<div class="job-tags"> 
  
    
     <span>设计公司 </span>  <span>五险一金 </span>  <span>定期培训 </span>  <span>带薪年假 </span>  <span>团队聚餐 </span>  <span>客户优质 </span>  <span>扁平管理 </span> 
  
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
	private String teamhome;
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
	public String getTeamhome() {
		return teamhome;
	}
	public void setTeamhome(String teamhome) {
		this.teamhome = teamhome;
	}
	public List<EnterpriseDropDownBean> getDropDownitemllist() {
		return dropDownitemllist;
	}
	public void setDropDownitemllist(List<EnterpriseDropDownBean> dropDownitemllist) {
		this.dropDownitemllist = dropDownitemllist;
	}

}
