package com.open.zcool.jsoup;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.util.Log;

import com.open.android.jsoup.CommonService;
import com.open.zcool.bean.ToolsSearchKeysBean;
import com.open.zcool.json.SearchSuCaiJson;
import com.open.zcool.utils.UrlUtils;

public class ToolsSearchSuCaiService extends CommonService {
	public static final String TAG = ToolsSearchSuCaiService.class.getSimpleName();

	public static SearchSuCaiJson parseSearchHot(String href) {
		SearchSuCaiJson hotjson = new SearchSuCaiJson();
		List<ToolsSearchKeysBean> indexnavlist = new ArrayList<ToolsSearchKeysBean>();
		List<ToolsSearchKeysBean> hotWordsLeftlist = new ArrayList<ToolsSearchKeysBean>();
		List<ToolsSearchKeysBean> hotWordsRightlist = new ArrayList<ToolsSearchKeysBean>();
		try {
			Log.i(TAG, "url = " + href);
			Document doc = Jsoup.connect(href).userAgent(UrlUtils.enrzAgent).timeout(10000).get();
			// System.out.println(doc.toString());
			try {
				Element globalnavElement = doc.select("div.index-nav-list").first();
				Elements moduleElements = globalnavElement.select("a");
				if (moduleElements != null && moduleElements.size() > 0) {
					for (int i = 0; i < moduleElements.size(); i++) {
						try {
							try {
								Element aElement = moduleElements.get(i).select("a").first();
								if (aElement != null) {
									ToolsSearchKeysBean bean = new ToolsSearchKeysBean();
									String title = aElement.text();
									Log.i(TAG, "i==" + i + ";title==" + title);
									bean.setTitle(title);
									bean.setHref(UrlUtils.ZCOOL_SUCAI+aElement.attr("href"));
									indexnavlist.add(bean);
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
				Element globalnavElement = doc.select("div.searchHotWords-left").first();
				Elements moduleElements = globalnavElement.select("a");
				if (moduleElements != null && moduleElements.size() > 0) {
					for (int i = 0; i < moduleElements.size(); i++) {
						try {
							try {
								Element aElement = moduleElements.get(i).select("a").first();
								if (aElement != null) {
									ToolsSearchKeysBean bean = new ToolsSearchKeysBean();
									String title = aElement.text();
									Log.i(TAG, "i==" + i + ";title==" + title);
									bean.setTitle(title);
									bean.setHref(UrlUtils.ZCOOL_SUCAI+aElement.attr("href"));
									hotWordsLeftlist.add(bean);
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
				Element globalnavElement = doc.select("div.searchHotWords-right").first();
				Elements moduleElements = globalnavElement.select("a");
				if (moduleElements != null && moduleElements.size() > 0) {
					for (int i = 0; i < moduleElements.size(); i++) {
						try {
							try {
								Element aElement = moduleElements.get(i).select("a").first();
								if (aElement != null) {
									ToolsSearchKeysBean bean = new ToolsSearchKeysBean();
									String title = aElement.text();
									Log.i(TAG, "i==" + i + ";title==" + title);
									bean.setTitle(title);
									bean.setHref(UrlUtils.ZCOOL_SUCAI+aElement.attr("href"));
									hotWordsRightlist.add(bean);
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
		hotjson.setIndexnavlist(indexnavlist);
		hotjson.setHotWordsLeftlist(hotWordsLeftlist);
		hotjson.setHotWordsRightlist(hotWordsRightlist);
		return hotjson;
	}
}
