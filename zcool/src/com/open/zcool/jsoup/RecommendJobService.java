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
import com.open.zcool.bean.DesignerBean;
import com.open.zcool.bean.RecommendJobBean;
import com.open.zcool.utils.UrlUtils;

public class RecommendJobService extends CommonService {
	public static final String TAG = RecommendJobService.class.getSimpleName();

	public static List<RecommendJobBean> parseRecommendJob(String href) {
		List<RecommendJobBean> list = new ArrayList<RecommendJobBean>();
		try {
			href = makeURL(href, new HashMap<String, Object>() {
				{
				}
			});
			Log.i(TAG, "url = " + href);

			Document doc = Jsoup.connect(href).userAgent(UrlUtils.enrzAgent).timeout(10000).get();
			// System.out.println(doc.toString());
			try {
				Element globalnavElement = doc.select("div.recommend-jobs").first();
				Elements moduleElements = globalnavElement.select("div.item");
				if (moduleElements != null && moduleElements.size() > 0) {
					for (int i = 0; i < moduleElements.size(); i++) {
						RecommendJobBean sbean = new RecommendJobBean();
						try {
							/**
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

							 */
							
							/**
							 * <div class="job-body-left">
										<div style="line-height:20px"><a href="http://www.zcool.com.cn/job/posts/12381.html?from=zcool_index_bottom" target="_blank">高级视觉设计师</a> <span class="c999">1天前发布</span></div>
										<div style="margin-top:10px"><span class="f14" style="color:#f30">12k-15k</span><span class="ml10 c999">经验1-3年 / 学历不限</span></div>
									</div>
							 */
							try {
								Element divElement = moduleElements.get(i).select("div.job-body-left").first();
								if (divElement != null) {
									String hrefa = divElement.select("a").first().attr("href");
									Log.i(TAG, "i==" + i + ";hrefa==" + hrefa);
									sbean.setHref(hrefa);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
							
							try {
								Element divElement = moduleElements.get(i).select("div.job-body-left").first();
								if (divElement != null) {
									String job_body_left = divElement.toString();
									Log.i(TAG, "i==" + i + ";job_body_left==" + job_body_left);
									sbean.setJob_body_left(job_body_left);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}

							try {
								Element picElement = moduleElements.get(i).select("div.pic-box").first();
								if (picElement != null) {
									String src = picElement.select("img").first().attr("src");
									Log.i(TAG, "i==" + i + ";src==" + src);
									sbean.setPic_box_src(src);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
							
							try {
								Element picElement = moduleElements.get(i).select("div.pic-box").first();
								if (picElement != null) {
									String pic_box_href = picElement.select("a").first().attr("href");
									Log.i(TAG, "i==" + i + ";pic_box_href==" + pic_box_href);
									sbean.setPic_box_href(pic_box_href);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
							
							try {
								Element picElement = moduleElements.get(i).select("div.pic-box").first();
								if (picElement != null) {
									Element nElement = picElement.nextElementSibling();
									Element nnElement = picElement.nextElementSibling().nextElementSibling();
									
									String pic_box = nElement.text()+"</br>"+nnElement.text();
									Log.i(TAG, "i==" + i + ";pic_box==" + pic_box);
									sbean.setPic_box(pic_box);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
							
							try {
								Element divElement = moduleElements.get(i).select("div.job-slogn").first();
								if (divElement != null) {
									String slogn = divElement.text();
									Log.i(TAG, "i==" + i + ";slogn==" + slogn);
									sbean.setSlogn(slogn);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
							
							try {
								Element divElement = moduleElements.get(i).select("div.job-tags").first();
								if (divElement != null) {
									String tags = divElement.toString().replace("</span>", "").replace("<span>", "  ");
									Log.i(TAG, "i==" + i + ";tags==" + tags);
									sbean.setTags(tags);
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
	
	public static List<RecommendJobBean> parseRecommendJob(String href,int pagerno) {
		List<RecommendJobBean> list = new ArrayList<RecommendJobBean>();
		try {
//			href = makeURL(href, new HashMap<String, Object>() {
//				{
//				}
//			});
			Document doc;
			if(pagerno>1){
				doc = Jsoup.parse(href);
			}else{
				doc = Jsoup.connect(href).userAgent(UrlUtils.enrzAgent).timeout(10000).get();
				Log.i(TAG, "url = " + href);
			}
//			Document doc = Jsoup.connect(href).userAgent(UrlUtils.enrzAgent).timeout(10000).get();
			// System.out.println(doc.toString());
			try {
//				Element globalnavElement = doc.select("div.job-list").first();
				Elements moduleElements = doc.select("div.item-body");
				if (moduleElements != null && moduleElements.size() > 0) {
					for (int i = 0; i < moduleElements.size(); i++) {
						RecommendJobBean sbean = new RecommendJobBean();
						try {
							/**
							 <div class="item-body clearfix">
		<div class="job-body-left">
			<div class="job-name">
				<a href="http://www.zcool.com.cn/job/posts/29128.html?from=index_post_hot&post_type=&position=" target="_blank" class="f-18 c-282828 text-overflow" style="display:inline-block; max-width:370px; vertical-align:sub">资深平面设计师(上海) </a> <span
					class="f-14 c-999">1天前发布</span>
			</div>
			<div style="margin-top: 6px">
				<strong class="f-18 jobs-price" style="color: #ff8600">10k-15k</strong><span
					class="ml-10 f-14 c-666">经验3-5年 / 本科</span>
			</div>
		</div>

		<div class="job-body-right">
			<div class="pic-box opacity">
				<a href="http://www.zcool.com.cn/u/1393654" onClick="clickbutton_log('corpclick','hotpost','',1393654,'image')" target="_blank"><img src="http://img.zcool.cn/job/corp/8dab57c7d21b00000147b865fbdd" /></a>
			</div>
			<div class="company-name">
				<a href="http://www.zcool.com.cn/u/1393654" onClick="clickbutton_log('corpclick','hotpost','',1393654,'name')" target="_blank" class="f-18 c-282828">饿了么</a>
			</div>
			<div class="f-14 c-666 text-overflow" style="margin-top: 10px">互联网/成熟型(D轮及以上)</div>
		</div>
	</div>
	<div class="item-footer">
		<div class="job-slogn text-overflow">饿了么和你一起拼！</div>
		<div class="job-tags">
			
			
			
			<span>外卖平台</span>
			
		</div>
	</div>

							 */
							try {
								Element divElement = moduleElements.get(i).select("div.job-body-left").first();
								if (divElement != null) {
									String hrefa = divElement.select("a").first().attr("href");
									Log.i(TAG, "i==" + i + ";hrefa==" + hrefa);
									sbean.setHref(hrefa);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
							
							try {
								Element divElement = moduleElements.get(i).select("div.job-body-left").first();
								if (divElement != null) {
									String job_body_left = divElement.toString();
									Log.i(TAG, "i==" + i + ";job_body_left==" + job_body_left);
									sbean.setJob_body_left(job_body_left);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}

							try {
								Element picElement = moduleElements.get(i).select("div.pic-box").first();
								if (picElement != null) {
									String src = picElement.select("img").first().attr("src");
									Log.i(TAG, "i==" + i + ";src==" + src);
									sbean.setPic_box_src(src);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
							
							try {
								Element picElement = moduleElements.get(i).select("div.pic-box").first();
								if (picElement != null) {
									String pic_box_href = picElement.select("a").first().attr("href");
									Log.i(TAG, "i==" + i + ";pic_box_href==" + pic_box_href);
									sbean.setPic_box_href(pic_box_href);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
							
							try {
								Element picElement = moduleElements.get(i).select("div.pic-box").first();
								if (picElement != null) {
									Element nElement = picElement.nextElementSibling();
									Element nnElement = picElement.nextElementSibling().nextElementSibling();
									
									String pic_box = nElement.text()+"</br>"+nnElement.text();
									Log.i(TAG, "i==" + i + ";pic_box==" + pic_box);
									sbean.setPic_box(pic_box);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
							
							try {
								Element divElement = moduleElements.get(i).nextElementSibling().select("div.job-slogn").first();
								if (divElement != null) {
									String slogn = divElement.text();
									Log.i(TAG, "i==" + i + ";slogn==" + slogn);
									sbean.setSlogn(slogn);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
							
							try {
								Element divElement = moduleElements.get(i).nextElementSibling().select("div.job-tags").first();
								if (divElement != null) {
									String tags = divElement.toString().replace("</span>", "").replace("<span>", "  ");
									Log.i(TAG, "i==" + i + ";tags==" + tags);
									sbean.setTags(tags);
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
