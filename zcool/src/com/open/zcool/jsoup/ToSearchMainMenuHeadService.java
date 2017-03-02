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

public class ToSearchMainMenuHeadService extends CommonService {
	public static final String TAG = ToSearchMainMenuHeadService.class.getSimpleName();

	 
	
	public static List<DropItemBean> parseSearchPost(String href) {
		List<DropItemBean> items = new ArrayList<DropItemBean>();
		try {
			Log.i(TAG, "url = " + href);
			Document doc = Jsoup.connect(href).userAgent(UrlUtils.enrzAgent).timeout(10000).get();
			// System.out.println(doc.toString());
			try {
				Element moduleElement = doc.select("div.camZpBox").first();
				Elements moduleElements = moduleElement.select("dl");
				if (moduleElements != null && moduleElements.size() > 0) {
					DropItemBean dropbean;
					for (int i = 0; i < moduleElements.size(); i++) {
						try {
							try {
								/**
								 * <dl>
                            	<dt>类型：</dt>
                                <dd>
                                	<a href="tosearch.do?page=0&sort=0&time=0&limit=10&world=" class="selected">全部</a>
                                	<a href="tosearch.do?page=1&sort=0&time=0&limit=10&world=" >原创作品</a>
                                	<a href="tosearch.do?page=2&sort=0&time=0&limit=10&world=" >设计文章</a>
                                	<a href="tosearch.do?page=3&sort=0&time=0&limit=10&world=" >佳作欣赏</a>
                                	<a href="tosearch.do?page=4&sort=0&time=0&limit=10&world=" >设计素材</a>
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
	
	public static List<DropItemBean> parseDesigner(String href) {
		List<DropItemBean> items = new ArrayList<DropItemBean>();
		try {
			Log.i(TAG, "url = " + href);
			Document doc = Jsoup.connect(href).userAgent(UrlUtils.enrzAgent).timeout(10000).get();
			// System.out.println(doc.toString());
			try {
				Element moduleElement = doc.select("table.rechoose").first();
				Elements moduleElements = moduleElement.select("td");
				if (moduleElements != null && moduleElements.size() > 0) {
					DropItemBean dropbean;
					for (int i = 0; i < moduleElements.size(); i++) {
						try {
							try {
								/**
								 * <td>性别：
                                	<span class="selectBox">
                                		<select id="sex" onchange="subSex()">
                                			<option value="-1">不限性别</option>
                                			<option value="1" >男</option>
                                			<option value="2" >女</option>
                                		</select>
                                	</span>
                                </td>

								 */
								Element spanElement = moduleElements.get(i).select("td").first();
								if (spanElement != null) {
									dropbean = new DropItemBean();
									String title = null ;
									try {
										  title = spanElement.text().split("：")[0];
										Log.i(TAG, "i==" + i + ";title==" + title);
										dropbean.setLabel(title.replace(" ", ""));
									} catch (Exception e) {
										// TODO: handle exception
									}
									
									
									List<MenuBean> menulist = new ArrayList<MenuBean>();
									MenuBean menubean;
									menubean = new MenuBean();
									menubean.setMenuname(title);
									menulist.add(menubean);
									
									Element ulElement = moduleElements.get(i).select("select").first();
									if(ulElement!=null){
										Elements liElements = ulElement.select("option");
										for(int j=0;j<liElements.size();j++){
											menubean = new MenuBean();
											Element aElement = liElements.get(j).select("option").first();
											String menuname = aElement.text();
											String menuhref = aElement.attr("value");
											Log.i(TAG, "i==" + i + ";j==" + j + ";menuname==" + menuname+";menuhref = "+menuhref);
											menubean.setMenuname(menuname);
											if(aElement.attr("selected")!=null && "selected".equals(aElement.attr("selected"))){
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
									if(title.equals("省份")){
										/**
										 * ["北京","上海","天津","重庆","黑龙江","辽宁","吉林","河北","内蒙古","陕西","山西","甘肃","宁夏","新疆","西藏","青海","四川","云南","贵州","湖南","湖北","河南","山东","安徽","江苏","浙江","台湾","香港","澳门","广东","广西","江西","福建","海南","其它","美国","欧洲","日本","韩国","新加坡","加拿大","亚　洲","非　洲","澳　洲","南美洲","东南亚"];
										 */
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
