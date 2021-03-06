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

public class SearchWorksHeadService extends CommonService {
	public static final String TAG = SearchWorksHeadService.class.getSimpleName();

	 
	
	public static List<DropItemBean> parseSearchPost(String href) {
		List<DropItemBean> items = new ArrayList<DropItemBean>();
		try {
			Log.i(TAG, "url = " + href);
			Document doc = Jsoup.connect(href).userAgent(UrlUtils.enrzAgent).timeout(10000).get();
			// System.out.println(doc.toString());
			try {
				Element moduleElement = doc.select("ul.camNavBigUl").first();
				Elements moduleElements = moduleElement.children();
				if (moduleElements != null && moduleElements.size() > 0) {
					DropItemBean dropbean;
					for (int i = 0; i < moduleElements.size(); i++) {
						try {
							try {
								Element spanElement = moduleElements.get(i).select("a").first();
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
									
									Element ulElement = moduleElements.get(i).select("div.cnpopCon").first();
									if(ulElement!=null){
										Elements liElements = ulElement.child(0).child(0).children();
										for(int j=0;j<liElements.size();j++){
											menubean = new MenuBean();
											try {
												Element aElement = liElements.get(j).select("a").first();
												String menuname = aElement.text();
												String menuhref = aElement.attr("href");
												Log.i(TAG, "i==" + i + ";j==" + j + ";menuname==" + menuname+";menuhref = "+menuhref);
												menubean.setMenuname(menuname);
												dropbean.setTypehref(menuhref);
												menubean.setHref(menuhref);
											} catch (Exception e) {
												 e.printStackTrace();
											}
											menulist.add(menubean);
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
