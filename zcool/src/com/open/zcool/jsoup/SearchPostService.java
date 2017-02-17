package com.open.zcool.jsoup;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.util.Log;

import com.jayfang.dropdownmenu.DropItemBean;
import com.jayfang.dropdownmenu.MenuBean;
import com.open.android.jsoup.CommonService;
import com.open.zcool.utils.UrlUtils;

public class SearchPostService extends CommonService {
	public static final String TAG = SearchPostService.class.getSimpleName();

	public static List<DropItemBean> parseSearchPostMore(String href) {
		List<DropItemBean> items = new ArrayList<DropItemBean>();
		DropItemBean dropbean =  new DropItemBean();
		try {
			Log.i(TAG, "url = " + href);
			Document doc = Jsoup.connect(href).userAgent(UrlUtils.enrzAgent).timeout(10000).get();
			// System.out.println(doc.toString());
			try {
				Element divElement = doc.select("div.select-category").get(0);
				Elements moduleElements = divElement.select("div.item");
				if (moduleElements != null && moduleElements.size() > 0) {
					List<MenuBean> leftmenulist = new ArrayList<MenuBean>();
					MenuBean leftmenubean;
					for (int i = 0; i < moduleElements.size(); i++) {
						try {
							try {
								/**
								 * <dl>
							<dt class="dt">工作经验：</dt>
							<dd class="dd"> <a href="javascript:expclick(0)" data-id="0">全部</a> 
							<a href="javascript:expclick(2)" data-id="2">应届毕业生</a>
							<a href="javascript:expclick(3)" data-id="3">1-3年</a>
							<a href="javascript:expclick(4)" data-id="4">3-5年</a>
							<a href="javascript:expclick(5)" data-id="5">5-10年</a>
							<a href="javascript:expclick(7)" data-id="7">10年以上</a>
							<a href="javascript:expclick(1)" data-id="1">不限</a>
							</dd>
						</dl>
								 */
								Element spanElement = moduleElements.get(i).select("dt.dt").first();
								if (spanElement != null) {
									String title = spanElement.text();
									Log.i(TAG, "i==" + i + ";title==" + title);
									leftmenubean = new MenuBean();
									leftmenubean.setMenuname(title);
									
									
									List<MenuBean> rightmenulist = new ArrayList<MenuBean>();
									MenuBean rightmenubean;
									
									rightmenubean= new MenuBean();
									rightmenubean.setMenuname(title);
									rightmenulist.add(rightmenubean);
									
									Element ulElement = moduleElements.get(i).select("dd.dd").first();
									if(ulElement!=null){
										Elements liElements = ulElement.select("a");
										for(int j=0;j<liElements.size();j++){
											rightmenubean = new MenuBean();
											Element aElement = liElements.get(j).select("a").first();
											String menuname = aElement.text();
											Log.i(TAG, "i==" + i + ";j==" + j + ";menuname==" + menuname);
											rightmenubean.setMenuname(menuname);
											rightmenulist.add(rightmenubean);
										}
									}
									leftmenubean.setRightlist(rightmenulist);
									leftmenulist.add(leftmenubean);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					dropbean.setMenulist(leftmenulist);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		items.add(dropbean);
		return items;
	}
	
	public static List<DropItemBean> parseSearchPost(String href) {
		List<DropItemBean> items = new ArrayList<DropItemBean>();
		try {
			Log.i(TAG, "url = " + href);
			Document doc = Jsoup.connect(href).userAgent(UrlUtils.enrzAgent).timeout(10000).get();
			// System.out.println(doc.toString());
			try {
				Elements moduleElements = doc.select("div.dropDown_hover");
				if (moduleElements != null && moduleElements.size() > 0) {
					DropItemBean dropbean;
					for (int i = 0; i < moduleElements.size(); i++) {
						try {
							try {
								/**
								 * <div id="dropDown-xingzhi" class="dropDown dropDown_hover">
									<span> 按职业性质 <i class="iconpic iconpic-arrow-down2"></i></span>
									<ul class="dropDown-menu box-shadow">
										<li><a href="javascript:workstatusclick(0)">不限</a></li>
										
										<li><a href="javascript:workstatusclick(1)">全职</a></li>
										
										<li><a href="javascript:workstatusclick(2)">兼职</a></li>
										
										<li><a href="javascript:workstatusclick(3)">实习</a></li>
										
									</ul>
								</div>

								 */
								Element spanElement = moduleElements.get(i).select("span").first();
								if (spanElement != null) {
									dropbean = new DropItemBean();
									String title = spanElement.text();
									Log.i(TAG, "i==" + i + ";title==" + title);
									dropbean.setLabel(title.replace(" ", ""));
									
									List<MenuBean> menulist = new ArrayList<MenuBean>();
									MenuBean menubean;
									menubean = new MenuBean();
									menubean.setMenuname(title);
									menulist.add(menubean);
									
									Element ulElement = moduleElements.get(i).select("ul.dropDown-menu").first();
									if(ulElement!=null){
										Elements liElements = ulElement.select("li");
										for(int j=0;j<liElements.size();j++){
											menubean = new MenuBean();
											Element aElement = liElements.get(j).select("a").first();
											String menuname = aElement.text();
											String menuhref = aElement.attr("href");
											Log.i(TAG, "i==" + i + ";j==" + j + ";menuname==" + menuname+";menuhref = "+menuhref);
											menubean.setMenuname(menuname);
											menubean.setHref(menuhref);
											menulist.add(menubean);
											if(dropbean.getLabel().equals(menuname.replace(" ", ""))){
												dropbean.setTypehref(menuhref);
											}
										}
									}
									if(dropbean.getTypehref()==null){
										dropbean.setTypehref(menulist.get(1).getHref());
									}
									menulist.get(0).setHref(menulist.get(1).getHref());
									dropbean.setMenulist(menulist);
									items.add(dropbean);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}
}
