package com.open.zcool.jsoup;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.util.Log;

import com.open.android.jsoup.CommonService;
import com.open.zcool.bean.DesignerTabBean;
import com.open.zcool.utils.UrlUtils;

public class ToSearchMainTabService extends CommonService {
	public static final String TAG = ToSearchMainTabService.class.getSimpleName();
	
	public static List<DesignerTabBean> parseDesignerTab(String href) {
		List<DesignerTabBean> list = new ArrayList<DesignerTabBean>();
		try {
			Log.i(TAG, "url = " + href);
			Document doc = Jsoup.connect(href).userAgent(UrlUtils.enrzAgent).timeout(10000).get();
			// System.out.println(doc.toString());
			try {
				Element globalnavElement = doc.select("div.camNavC").first();
				Elements moduleElements = globalnavElement.select("a");
				if (moduleElements != null && moduleElements.size() > 0) {
					for (int i = 0; i < moduleElements.size(); i++) {
						DesignerTabBean sbean = new DesignerTabBean();
						try {
							/**
							<div class="camNavC">
					    	<a href="tosearch.do?page=0&world="  class="selected">全站</a>
					    	<a href="tosearch.do?page=1&world=" >原创作品</a>
					    	<a href="tosearch.do?page=2&world=" >设计文章</a>
					    	<a href="tosearch.do?page=3&world=" >佳作欣赏</a>
					    	<a href="tosearch.do?page=4&world=" >设计素材</a>
					    	<a href="tosearch.do?page=5&world=" >设计师</a>
					    	<a href="http://www.hellorf.com/hellorf/search/all/.html" target="_blank">正版图片</a>
				    	</div>
							 */
							try {
								Element aElement = moduleElements.get(i).select("a").first();
								if (aElement != null) {
									String title = aElement.text();
									String hrefa = aElement.attr("href");
									Log.i(TAG, "i==" + i + ";title==" + title);
									if(!title.contains("正版图片")){
										hrefa = UrlUtils.ZCOOL+hrefa;
									} 
									sbean.setHref(hrefa);
									sbean.setTitle(title);
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
	
	public static List<DesignerTabBean> parseArticleTab(String href) {
		List<DesignerTabBean> list = new ArrayList<DesignerTabBean>();
		try {
			Log.i(TAG, "url = " + href);
			Document doc = Jsoup.connect(href).userAgent(UrlUtils.enrzAgent).timeout(10000).get();
			// System.out.println(doc.toString());
			try {
				Element globalnavElement = doc.select("div.camNavC").first();
				Elements moduleElements = globalnavElement.select("a");
				if (moduleElements != null && moduleElements.size() > 0) {
					for (int i = 0; i < moduleElements.size(); i++) {
						DesignerTabBean sbean = new DesignerTabBean();
						try {
							/**
							 <div class="camTitle">
							<div class="camNavC"> <a href="/articles/"  class="selected">编辑精选文章</a>
							<a href="/articles/0!0!0!1!3!100!2!1/" >近期热门推荐</a>
							<a href="/articles/0!0!0!0!0!0!4!1/" >全部文章</a> 
							</div>
						</div>
							 */
							try {
								Element aElement = moduleElements.get(i).select("a").first();
								if (aElement != null) {
									String title = aElement.text();
									String hrefa = aElement.attr("href");
									Log.i(TAG, "i==" + i + ";title==" + title);
									 hrefa = UrlUtils.ZCOOL_HTTP+hrefa;
									sbean.setHref(hrefa);
									sbean.setTitle(title);
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
	
	public static List<DesignerTabBean> parseEventTab(String href) {
		List<DesignerTabBean> list = new ArrayList<DesignerTabBean>();
		try {
			Log.i(TAG, "url = " + href);
			Document doc = Jsoup.connect(href).userAgent(UrlUtils.enrzAgent).timeout(10000).get();
			// System.out.println(doc.toString());
			try {
				Element globalnavElement = doc.select("div.camNavC").first();
				Elements moduleElements = globalnavElement.select("a");
				if (moduleElements != null && moduleElements.size() > 0) {
					for (int i = 0; i < moduleElements.size(); i++) {
						DesignerTabBean sbean = new DesignerTabBean();
						try {
							/**<div class="camNavC"><a href="/event/eventlist.do" >全部赛事</a><a href="/event/eventlist.do?status=1" class="selected">进行中的赛事</a><a href="/event/eventlist.do?status=3" >已结束的赛事</a><span class="jubansaishi"><i class="iconpic iconpic-jiangbei"></i><a class="" href="#findMe"> 我要举办赛事</a></span></div>
  </div>

							 */
							try {
								Element aElement = moduleElements.get(i).select("a").first();
								if (aElement != null) {
									String title = aElement.text();
									String hrefa = aElement.attr("href");
									Log.i(TAG, "i==" + i + ";title==" + title);
									 hrefa = UrlUtils.ZCOOL_HTTP+hrefa;
									sbean.setHref(hrefa);
									sbean.setTitle(title);
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
