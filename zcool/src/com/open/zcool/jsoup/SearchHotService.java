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
import com.open.zcool.json.SearchHotJson;
import com.open.zcool.utils.UrlUtils;

public class SearchHotService extends CommonService {
	public static final String TAG = SearchHotService.class.getSimpleName();

	public static SearchHotJson parseSearchHot(String href) {
		SearchHotJson hotjson = new SearchHotJson();

		List<String> hotlist = new ArrayList<String>();
		List<String> designerlist = new ArrayList<String>();
		List<String> managerlist = new ArrayList<String>();
		try {
			href = makeURL(href, new HashMap<String, Object>() {
				{
				}
			});
			Log.i(TAG, "url = " + href);

			Document doc = Jsoup.connect(href).userAgent(UrlUtils.enrzAgent).timeout(10000).get();
			// System.out.println(doc.toString());
			try {
				Element globalnavElement = doc.select("div.index-search-hot").first();
				Elements moduleElements = globalnavElement.select("a");
				if (moduleElements != null && moduleElements.size() > 0) {
					for (int i = 0; i < moduleElements.size(); i++) {
						try {
							try {
								Element aElement = moduleElements.get(i).select("a").first();
								if (aElement != null) {
									String title = aElement.text();
									Log.i(TAG, "i==" + i + ";title==" + title);
									hotlist.add(title);
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
			
			try {
				Element globalnavElement = doc.select("div.index-aside-menu").first();
				Elements moduleElements = globalnavElement.select("div.item");
				if (moduleElements != null && moduleElements.size() > 0) {
					for (int i = 0; i < moduleElements.size(); i++) {
						try {
							try {
								Element dtElement = moduleElements.get(i).select("div.dt").first();
								if (dtElement != null) {
									String title = dtElement.text();
									Log.i(TAG, "i==" + i + ";title==" + title);
									Elements aElements = moduleElements.get(i).select("a");
									for (int j = 0; j < aElements.size(); j++) {
										try {
											try {
												Element aElement = aElements.get(j).select("a").first();
												if (aElement != null) {
													String titlea = aElement.text();
													Log.i(TAG, "j==" + j + ";titlea==" + titlea);
													if(title.equals("设计方向")){
														designerlist.add(titlea);
													}else if(title.equals("管理职位")){
														managerlist.add(titlea);
													}
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
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		hotjson.setHotlist(hotlist);
		hotjson.setDesignerlist(designerlist);
		hotjson.setManagerlist(managerlist);
		return hotjson;
	}
}
