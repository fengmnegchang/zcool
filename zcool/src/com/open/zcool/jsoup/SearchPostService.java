package com.open.zcool.jsoup;

import java.util.ArrayList;
import java.util.HashMap;
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
									dropbean.setLabel(title);
									
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
											Log.i(TAG, "i==" + i + ";j==" + j + ";menuname==" + menuname);
											menubean.setMenuname(menuname);
											menulist.add(menubean);
										}
									}
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
