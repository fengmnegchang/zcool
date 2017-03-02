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

public class ArticleMainHeadDropService extends CommonService {
	public static final String TAG = ArticleMainHeadDropService.class.getSimpleName();

	 
	
	public static List<DropItemBean> parseSearchPost(String href) {
		List<DropItemBean> items = new ArrayList<DropItemBean>();
		try {
			Log.i(TAG, "url = " + href);
			Document doc = Jsoup.connect(href).userAgent(UrlUtils.enrzAgent).timeout(10000).get();
			// System.out.println(doc.toString());
			try {
				Element moduleElement = doc.select("div.camZpBoxC").first();
				Elements moduleElements = moduleElement.select("dl");
				if (moduleElements != null && moduleElements.size() > 0) {
					DropItemBean dropbean;
					for (int i = 0; i < moduleElements.size(); i++) {
						try {
							try {
								/**
<dl>
								<dt>类别：</dt>
								<dd> <a href="/articles/0!0!0!0!0!200!1!1/" 
		                    			class="selected"> 全部 </a>
									 <a href="/articles/695!0!0!0!0!200!1!1/" 
		                    			> 原创/自译教程 </a>  <a href="/articles/707!0!0!0!0!200!1!1/" 
		                    			> 酷友观点/经验 </a>  <a href="/articles/712!0!0!0!0!200!1!1/" 
		                    			> 设计资讯/资料 </a>  <a href="/articles/720!0!0!0!0!200!1!1/" 
		                    			> 站酷专访 </a>  <a href="/articles/735!0!0!0!0!200!1!1/" 
		                    			> 站酷设计公开课 </a>  <a href="/articles/758!0!0!0!0!200!1!1/" 
		                    			> 设计书籍 </a> 
								</dd>
								
							</dl>

								 */
								Element spanElement = moduleElements.get(i).select("dt").first();
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
									
									Element ulElement = moduleElements.get(i).select("dd").first();
									if(ulElement!=null){
										Elements liElements = ulElement.select("a");
										for(int j=0;j<liElements.size();j++){
											menubean = new MenuBean();
											Element aElement = liElements.get(j).select("a").first();
											String menuname = aElement.text();
											String menuhref = aElement.attr("href");
											Log.i(TAG, "i==" + i + ";j==" + j + ";menuname==" + menuname+";menuhref = "+menuhref);
											menubean.setMenuname(menuname);
											if(aElement.attr("class")!=null && "selected".equals(aElement.attr("class"))){
												 dropbean.setTypehref(menuhref);
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
}
