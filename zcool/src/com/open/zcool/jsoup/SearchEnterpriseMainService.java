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

public class SearchEnterpriseMainService extends CommonService {
	public static final String TAG = SearchEnterpriseMainService.class.getSimpleName();

	 
	
	public static List<DropItemBean> parseSearchPost(String href) {
		List<DropItemBean> items = new ArrayList<DropItemBean>();
		try {
			Log.i(TAG, "url = " + href);
			Document doc = Jsoup.connect(href).userAgent(UrlUtils.enrzAgent).timeout(10000).get();
			// System.out.println(doc.toString());
			try {
				Element moduleElement = doc.select("div.select-category").first();
				Elements moduleElements = moduleElement.select("div.clearfix");
				if (moduleElements != null && moduleElements.size() > 0) {
					DropItemBean dropbean;
					for (int i = 0; i < moduleElements.size(); i++) {
						try {
							try {
								/**
								 * <div id="search_cityid" class="item clearfix">
						<dl>
							<dt class="dt">工作地点：</dt>
							<dd class="dd">
								<a href="javascript:cityclick(0,47);"  class="city-one-text" data-id="47">北京</a>
								<a href="javascript:cityclick(0,66);"  class="city-one-text" data-id="66">上海</a>
								<a href="javascript:cityclick(0,452);"  class="city-one-text" data-id="452">广州</a>
								<a href="javascript:cityclick(0,454);"  class="city-one-text" data-id="454">深圳</a>
								<a href="javascript:cityclick(0,438);"  class="city-one-text" data-id="438">杭州</a>
								<a href="javascript:cityclick(0,0)"  data-id="0">其他城市</a>
								<a href="javascript:cityclick(0,-1)" data-id="-1">全国</a>
							</dd>
						</dl>
					</div>

								 */
								Element spanElement = moduleElements.get(i).select("dt.dt").first();
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
									
									Element ulElement = moduleElements.get(i).select("dd.dd").first();
									if(ulElement!=null){
										Elements liElements = ulElement.select("a");
										for(int j=0;j<liElements.size();j++){
											menubean = new MenuBean();
											Element aElement = liElements.get(j).select("a").first();
											String menuname = aElement.text();
											String menuhref = aElement.attr("href");
											Log.i(TAG, "i==" + i + ";j==" + j + ";menuname==" + menuname+";menuhref = "+menuhref);
											menubean.setMenuname(menuname);
											if(menuhref.contains("javascript:cityclick(")){
												menuhref = "data-id"+aElement.attr("data-id");
												if(href.contains("search_cityid="+aElement.attr("data-id"))){
													dropbean.setTypehref(menuhref);
												}
											}else if(menuhref.contains("javascript:industryclick(")){
												if(href.contains("search_industryid="+aElement.attr("data-id"))){
													dropbean.setTypehref(menuhref);
												}
											}else if(menuhref.contains("javascript:stageclick(")){
												if(href.contains("search_stageid="+aElement.attr("data-id"))){
													dropbean.setTypehref(menuhref);
												}
											}
											menubean.setHref(menuhref);
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
	
	
	public static List<DropItemBean> parseMSearchWorks(String href) {
		List<DropItemBean> items = new ArrayList<DropItemBean>();
		try {
			Log.i(TAG, "url = " + href);
			Document doc = Jsoup.connect(href).userAgent(UrlUtils.enrzAgent).timeout(10000).get();
			// System.out.println(doc.toString());
			try {
				Element moduleElement = doc.select("div.dropnav").first();
				Elements moduleElements = moduleElement.select("div.dropnav");
				if (moduleElements != null && moduleElements.size() > 0) {
					DropItemBean dropbean;
					for (int i = 0; i < moduleElements.size(); i++) {
						try {
							try {
								Element spanElement = moduleElements.get(i).select("div.dropnav").first();
								if (spanElement != null) {
									dropbean = new DropItemBean();
									dropbean.setLabel("作品");
									
									List<MenuBean> menulist = new ArrayList<MenuBean>();
									MenuBean menubean;
									menubean = new MenuBean();
									menubean.setMenuname("作品");
									menulist.add(menubean);
									
									Element ulElement = moduleElements.get(i).select("div.dropnav").first();
									if(ulElement!=null){
										Elements liElements = ulElement.select("a");
										for(int j=0;j<liElements.size();j++){
											menubean = new MenuBean();
											Element aElement = liElements.get(j).select("a").first();
											String menuname = aElement.text();
											String menuhref = aElement.attr("href");
											Log.i(TAG, "i==" + i + ";j==" + j + ";menuname==" + menuname+";menuhref = "+menuhref);
											menubean.setMenuname(menuname);
											menubean.setHref(menuhref);
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
