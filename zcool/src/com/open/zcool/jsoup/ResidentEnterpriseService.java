/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-17下午3:49:41
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.zcool.jsoup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.util.Log;

import com.open.android.jsoup.CommonService;
import com.open.zcool.bean.ResidentEnterpriseBean;
import com.open.zcool.utils.UrlUtils;

/**
 ***************************************************************************************************************************************************************************** 
 * <div class="panel-header" id="vip_corps">常驻企业</div>
				<div class="panel-body" style="padding-top:10px">
					<ul class="aside-company-list">
					
						<li class="item">
							<div class="pic-box radius opacity"> <a href="http://www.zcool.com.cn/u/15252437?from=vipcorps&position=companyindex" onClick="clickbutton_log('corpclick','companyindex','',15252437,'image')" target="_blank"><img src="http://img.zcool.cn/community/04538758a2b7c1a801219c779ef3a3.jpg" /></a> </div>
							<div class="company-name text-overflow"> <a href="http://www.zcool.com.cn/u/15252437?from=vipcorps&position=companyindex" onClick="clickbutton_log('corpclick','companyindex','',15252437,'name')" target="_blank" class="f-18 c-282828">智度亦复</a> </div>
							<div class="f-14 c-666" style="margin-top:10px">
								<a href="http://www.zcool.com.cn/u/15252437" onClick="clickbutton_log('corpclick','companyindex','',15252437,'vipcorppost')" target="_blank" style="color:#666"><strong class="c-ff8600">0</strong><span>职位正在招聘</span></a>
							</div
						></li>
						
						<li class="item">
							<div class="pic-box radius opacity"> <a href="http://www.zcool.com.cn/u/2103590?from=vipcorps&position=companyindex" onClick="clickbutton_log('corpclick','companyindex','',2103590,'image')" target="_blank"><img src="http://img.zcool.cn/job/f_receipt_ask/38215577ce0f0000014f34669a10.jpg" /></a> </div>
							<div class="company-name text-overflow"> <a href="http://www.zcool.com.cn/u/2103590?from=vipcorps&position=companyindex" onClick="clickbutton_log('corpclick','companyindex','',2103590,'name')" target="_blank" class="f-18 c-282828">鲸梦文化</a> </div>
							<div class="f-14 c-666" style="margin-top:10px">
								<a href="http://www.zcool.com.cn/u/2103590" onClick="clickbutton_log('corpclick','companyindex','',2103590,'vipcorppost')" target="_blank" style="color:#666"><strong class="c-ff8600">6</strong><span>职位正在招聘</span></a>
							</div
						></li>
						
						<li class="item">
							<div class="pic-box radius opacity"> <a href="http://www.zcool.com.cn/u/15244689?from=vipcorps&position=companyindex" onClick="clickbutton_log('corpclick','companyindex','',15244689,'image')" target="_blank"><img src="http://img.zcool.cn/community/04f1f3589d8841a8012060c8ff0e82.jpg" /></a> </div>
							<div class="company-name text-overflow"> <a href="http://www.zcool.com.cn/u/15244689?from=vipcorps&position=companyindex" onClick="clickbutton_log('corpclick','companyindex','',15244689,'name')" target="_blank" class="f-18 c-282828">沃美智业AD</a> </div>
							<div class="f-14 c-666" style="margin-top:10px">
								<a href="http://www.zcool.com.cn/u/15244689" onClick="clickbutton_log('corpclick','companyindex','',15244689,'vipcorppost')" target="_blank" style="color:#666"><strong class="c-ff8600">2</strong><span>职位正在招聘</span></a>
							</div
						></li>
						
						<li class="item">
							<div class="pic-box radius opacity"> <a href="http://www.zcool.com.cn/u/13644428?from=vipcorps&position=companyindex" onClick="clickbutton_log('corpclick','companyindex','',13644428,'image')" target="_blank"><img src="http://img.zcool.cn/job/corp/c95a575e14370000016cd1cbc675" /></a> </div>
							<div class="company-name text-overflow"> <a href="http://www.zcool.com.cn/u/13644428?from=vipcorps&position=companyindex" onClick="clickbutton_log('corpclick','companyindex','',13644428,'name')" target="_blank" class="f-18 c-282828">冇心良品</a> </div>
							<div class="f-14 c-666" style="margin-top:10px">
								<a href="http://www.zcool.com.cn/u/13644428" onClick="clickbutton_log('corpclick','companyindex','',13644428,'vipcorppost')" target="_blank" style="color:#666"><strong class="c-ff8600">9</strong><span>职位正在招聘</span></a>
							</div
						></li>
						
						<li class="item">
							<div class="pic-box radius opacity"> <a href="http://www.zcool.com.cn/u/583548?from=vipcorps&position=companyindex" onClick="clickbutton_log('corpclick','companyindex','',583548,'image')" target="_blank"><img src="http://img.zcool.cn/community/047bab555ecc29000001fbab3d0d8e.jpg" /></a> </div>
							<div class="company-name text-overflow"> <a href="http://www.zcool.com.cn/u/583548?from=vipcorps&position=companyindex" onClick="clickbutton_log('corpclick','companyindex','',583548,'name')" target="_blank" class="f-18 c-282828">新艺联</a> </div>
							<div class="f-14 c-666" style="margin-top:10px">
								<a href="http://www.zcool.com.cn/u/583548" onClick="clickbutton_log('corpclick','companyindex','',583548,'vipcorppost')" target="_blank" style="color:#666"><strong class="c-ff8600">4</strong><span>职位正在招聘</span></a>
							</div
						></li>
						
						<li class="item">
							<div class="pic-box radius opacity"> <a href="http://www.zcool.com.cn/u/262738?from=vipcorps&position=companyindex" onClick="clickbutton_log('corpclick','companyindex','',262738,'image')" target="_blank"><img src="http://img.zcool.cn/community/04315d5847f178a801219c77a10f39.jpg" /></a> </div>
							<div class="company-name text-overflow"> <a href="http://www.zcool.com.cn/u/262738?from=vipcorps&position=companyindex" onClick="clickbutton_log('corpclick','companyindex','',262738,'name')" target="_blank" class="f-18 c-282828">UIDWORKS</a> </div>
							<div class="f-14 c-666" style="margin-top:10px">
								<a href="http://www.zcool.com.cn/u/262738" onClick="clickbutton_log('corpclick','companyindex','',262738,'vipcorppost')" target="_blank" style="color:#666"><strong class="c-ff8600">8</strong><span>职位正在招聘</span></a>
							</div
						></li>
						
						<li class="item">
							<div class="pic-box radius opacity"> <a href="http://www.zcool.com.cn/u/1334213?from=vipcorps&position=companyindex" onClick="clickbutton_log('corpclick','companyindex','',1334213,'image')" target="_blank"><img src="http://img.zcool.cn/community/0424cf554957510000019ae93e3f90.jpg" /></a> </div>
							<div class="company-name text-overflow"> <a href="http://www.zcool.com.cn/u/1334213?from=vipcorps&position=companyindex" onClick="clickbutton_log('corpclick','companyindex','',1334213,'name')" target="_blank" class="f-18 c-282828">lizhifm</a> </div>
							<div class="f-14 c-666" style="margin-top:10px">
								<a href="http://www.zcool.com.cn/u/1334213" onClick="clickbutton_log('corpclick','companyindex','',1334213,'vipcorppost')" target="_blank" style="color:#666"><strong class="c-ff8600">2</strong><span>职位正在招聘</span></a>
							</div
						></li>
						
						<li class="item">
							<div class="pic-box radius opacity"> <a href="http://www.zcool.com.cn/u/14510698?from=vipcorps&position=companyindex" onClick="clickbutton_log('corpclick','companyindex','',14510698,'image')" target="_blank"><img src="http://img.zcool.cn/job/corp/e79e57a9562c00000156c5fc6d83" /></a> </div>
							<div class="company-name text-overflow"> <a href="http://www.zcool.com.cn/u/14510698?from=vipcorps&position=companyindex" onClick="clickbutton_log('corpclick','companyindex','',14510698,'name')" target="_blank" class="f-18 c-282828">珀莱雅</a> </div>
							<div class="f-14 c-666" style="margin-top:10px">
								<a href="http://www.zcool.com.cn/u/14510698" onClick="clickbutton_log('corpclick','companyindex','',14510698,'vipcorppost')" target="_blank" style="color:#666"><strong class="c-ff8600">4</strong><span>职位正在招聘</span></a>
							</div
						></li>
						
						<li class="item">
							<div class="pic-box radius opacity"> <a href="http://www.zcool.com.cn/u/13141791?from=vipcorps&position=companyindex" onClick="clickbutton_log('corpclick','companyindex','',13141791,'image')" target="_blank"><img src="http://img.zcool.cn/community/04c851589ae764a801219c77923106.jpg" /></a> </div>
							<div class="company-name text-overflow"> <a href="http://www.zcool.com.cn/u/13141791?from=vipcorps&position=companyindex" onClick="clickbutton_log('corpclick','companyindex','',13141791,'name')" target="_blank" class="f-18 c-282828">环时互动</a> </div>
							<div class="f-14 c-666" style="margin-top:10px">
								<a href="http://www.zcool.com.cn/u/13141791" onClick="clickbutton_log('corpclick','companyindex','',13141791,'vipcorppost')" target="_blank" style="color:#666"><strong class="c-ff8600">2</strong><span>职位正在招聘</span></a>
							</div
						></li>
						
						<li class="item">
							<div class="pic-box radius opacity"> <a href="http://www.zcool.com.cn/u/13135358?from=vipcorps&position=companyindex" onClick="clickbutton_log('corpclick','companyindex','',13135358,'image')" target="_blank"><img src="http://img.zcool.cn/community/0424db589abe99a8012060c8416eed.jpg" /></a> </div>
							<div class="company-name text-overflow"> <a href="http://www.zcool.com.cn/u/13135358?from=vipcorps&position=companyindex" onClick="clickbutton_log('corpclick','companyindex','',13135358,'name')" target="_blank" class="f-18 c-282828">楚域设计有限公司</a> </div>
							<div class="f-14 c-666" style="margin-top:10px">
								<a href="http://www.zcool.com.cn/u/13135358" onClick="clickbutton_log('corpclick','companyindex','',13135358,'vipcorppost')" target="_blank" style="color:#666"><strong class="c-ff8600">8</strong><span>职位正在招聘</span></a>
							</div
						></li>
						
					</ul>
				</div>

 * @author :fengguangjing
 * @createTime:2017-2-17下午3:49:41
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 ***************************************************************************************************************************************************************************** 
 */
public class ResidentEnterpriseService extends CommonService {
	public static final String TAG = DesignerService.class.getSimpleName();

	public static List<ResidentEnterpriseBean> parseResidentEnterprise(String href) {
		List<ResidentEnterpriseBean> list = new ArrayList<ResidentEnterpriseBean>();
		try {
			 
			Log.i(TAG, "url = " + href);

			Document doc = Jsoup.parse(href);
			// System.out.println(doc.toString());
			try {
				Element globalnavElement = doc.select("ul.aside-company-list").first();
				Elements moduleElements = globalnavElement.select("li");
				if (moduleElements != null && moduleElements.size() > 0) {
					for (int i = 0; i < moduleElements.size(); i++) {
						ResidentEnterpriseBean sbean = new ResidentEnterpriseBean();
						try {
							/**
<li class="item">
							<div class="pic-box radius opacity">
							 <a href="http://www.zcool.com.cn/u/13135358?from=vipcorps&position=companyindex"
							  onClick="clickbutton_log('corpclick','companyindex','',13135358,'image')" 
							  target="_blank">
							  <img src="http://img.zcool.cn/community/0424db589abe99a8012060c8416eed.jpg" 
							  /></a> </div>
							<div class="company-name text-overflow"> 
							<a href="http://www.zcool.com.cn/u/13135358?from=vipcorps&position=companyindex" 
							onClick="clickbutton_log('corpclick','companyindex','',13135358,'name')" 
							target="_blank" class="f-18 c-282828">楚域设计有限公司</a> 
							</div>
							<div class="f-14 c-666" style="margin-top:10px">
								<a href="http://www.zcool.com.cn/u/13135358"
								 onClick="clickbutton_log('corpclick'
								 ,'companyindex','',13135358,'vipcorppost')" target="_blank" style="color:#666">
								 <strong class="c-ff8600">8</strong><span>职位正在招聘</span></a>
							</div
						></li>
							 */
							try {
								Element aElement = moduleElements.get(i).select("a").first();
								if (aElement != null) {
									String hrefa = aElement.attr("href");
									Log.i(TAG, "i==" + i + ";hrefa==" + hrefa);
									sbean.setHref(hrefa);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}

							try {
								Element imgElement = moduleElements.get(i).select("img").first();
								if (imgElement != null) {
									String src = imgElement.attr("src");
									Log.i(TAG, "i==" + i + ";src==" + src);
									sbean.setSrc(src);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
							try {
								Element pElement = moduleElements.get(i).select("div.company-name").first();
								if (pElement != null) {
									String name = pElement.select("a").first().text();
									Log.i(TAG, "i==" + i + ";name==" + name);
									sbean.setName(name);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
							
							try {
								Element pElement = moduleElements.get(i).select("div.f-14").first();
								if (pElement != null) {
									String companyindex = pElement.select("a").first().text();
									Log.i(TAG, "i==" + i + ";companyindex==" + companyindex);
									sbean.setCompanyindex(companyindex);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
							try {
								Element pElement = moduleElements.get(i).select("div.f-14").first();
								if (pElement != null) {
									String indexhref = pElement.select("a").first().attr("href");
									Log.i(TAG, "i==" + i + ";indexhref==" + indexhref);
									sbean.setIndexhref(indexhref);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}

						} catch (Exception e) {
							e.printStackTrace();
						}

						list.add(sbean);
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
