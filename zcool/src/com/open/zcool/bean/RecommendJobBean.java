/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-4上午11:18:43
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
 * <div class="item">
								<div class="recommend-job-body layout">
									<div class="job-body-left">
										<div style="line-height:20px"><a href="http://www.zcool.com.cn/job/posts/12381.html?from=zcool_index_bottom" target="_blank">高级视觉设计师</a> <span class="c999">1天前发布</span></div>
										<div style="margin-top:10px"><span class="f14" style="color:#f30">12k-15k</span><span class="ml10 c999">经验1-3年 / 学历不限</span></div>
									</div>
									<div class="job-body-right">
										<div class="pic-box">
											<a href="http://www.zcool.com.cn/u/1556184" target="_blank"><img src="http://img.zcool.cn/job/company/dfc1574828cea84a62309bd5d9be"/></a>
										</div>
										<div style="line-height:20px"><a href="http://www.zcool.com.cn/u/1556184" target="_blank">MoreFun莫凡</a></div>
										<div class="c999" style="margin-top:12px">电子商务/不需要融资</div>
									</div>
								</div>
								<div class="recommend-job-footer">
									<div class="job-slogn text-overflow">一起牵手莫凡去挑战发现自己的未来吧！</div>
									<div class="job-tags">
										
										<span>五险一金</span>
										
										<span>年13薪</span>
										
										<span>年度旅游</span>
										
									</div>
								</div>
							</div>

 * @author :fengguangjing
 * @createTime:2017-2-4上午11:18:43
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class RecommendJobBean extends CommonBean {
	private String job_body_left;
	private String pic_box_src;
	private String pic_box;
	private String href;
	private String slogn;
	private String tags;
	public String getJob_body_left() {
		return job_body_left;
	}
	public void setJob_body_left(String job_body_left) {
		this.job_body_left = job_body_left;
	}
	public String getPic_box_src() {
		return pic_box_src;
	}
	public void setPic_box_src(String pic_box_src) {
		this.pic_box_src = pic_box_src;
	}
	public String getPic_box() {
		return pic_box;
	}
	public void setPic_box(String pic_box) {
		this.pic_box = pic_box;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getSlogn() {
		return slogn;
	}
	public void setSlogn(String slogn) {
		this.slogn = slogn;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	
	
}
