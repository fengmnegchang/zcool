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
import com.open.zcool.json.ToSearchJson;
import com.open.zcool.utils.UrlUtils;

public class HellorfSearchService extends CommonService {
	public static final String TAG = HellorfSearchService.class.getSimpleName();

	public static ToSearchJson parseSearchHot(String href) {
		ToSearchJson hotjson = new ToSearchJson();
		List<String> olist = new ArrayList<String>();
		List<String> plist = new ArrayList<String>();
		try {
			Log.i(TAG, "url = " + href);
			Document doc = Jsoup.connect(href).userAgent(UrlUtils.enrzAgent).timeout(10000).get();
			// System.out.println(doc.toString());
			try {
				Element moduleElement = doc.select("ul.index-fenlei-list").first();
				Elements moduleElements = moduleElement.select("li");
				if (moduleElements != null && moduleElements.size() > 0) {
					for (int i = 0; i < moduleElements.size(); i++) {
						try {
							try {
								Element aElement = moduleElements.get(i).select("a").first();
								if (aElement != null) {
									String title = aElement.text();
									Log.i(TAG, "i==" + i + ";title==" + title);
									/**
									 *   <a href="http://www.hellorf.com/image/search?category=0" target="_blank">交通运输</a>
									 */
									olist.add(title);
									plist.add(aElement.attr("href"));
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
		hotjson.setPlist(plist);
		hotjson.setOlist(olist);
		return hotjson;
	}
}
