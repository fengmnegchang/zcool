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
import com.open.zcool.bean.IndexFocusBean;
import com.open.zcool.utils.UrlUtils;

public class IndexFocusService extends CommonService {
	public static final String TAG = IndexFocusService.class.getSimpleName();

	public static List<IndexFocusBean> parseIndexFocus(String href) {
		List<IndexFocusBean> list = new ArrayList<IndexFocusBean>();
		try {
			href = makeURL(href, new HashMap<String, Object>() {
				{
				}
			});
			Log.i(TAG, "url = " + href);

			Document doc = Jsoup.connect(href).userAgent(UrlUtils.enrzAgent).timeout(10000).get();
			// System.out.println(doc.toString());
			try {
				Element globalnavElement = doc.select("div.indexShowBox").first();
				Elements moduleElements = globalnavElement.select("li");
				if (moduleElements != null && moduleElements.size() > 0) {
					for (int i = 0; i < moduleElements.size(); i++) {
						IndexFocusBean sbean = new IndexFocusBean();
						try {
							/**
							 * <li>
							 * <a st_t="click" st_n="index_focus_1" href=
							 * "http://www.hellorf.com/inspiration/unplugged?source=unplugged&term=zcool "
							 * target="_blank" class="image-link"> <img src=
							 * "http://img.zcool.cn/community/focus/ce7d5893e5b000000174c8302998.jpg"
							 * width="1083" height="350" alt="站酷精选图片"/> </a></li>
							 */
							try {
								Element aElement = moduleElements.get(i).select("a").first();
								if (aElement != null) {
									String hrefa = aElement.attr("href");
									Log.i(TAG, "i==" + i + ";hrefa==" + hrefa);
									sbean.setHref(hrefa);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}

							try {
								Element imgElement = moduleElements.get(i).select("img").first();
								if (imgElement != null) {
									String src = imgElement.attr("src");
									Log.i(TAG, "i==" + i + ";src==" + src);
									sbean.setSrc(src);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}

							try {
								Element imgElement = moduleElements.get(i).select("img").first();
								if (imgElement != null) {
									String alt = imgElement.attr("alt");
									Log.i(TAG, "i==" + i + ";alt==" + alt);
									sbean.setAlt(alt);
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
	
	
	public static List<IndexFocusBean> parseMIndex(String href) {
		List<IndexFocusBean> list = new ArrayList<IndexFocusBean>();
		try {
			href = makeURL(href, new HashMap<String, Object>() {
				{
				}
			});
			Log.i(TAG, "url = " + href);

			Document doc = Jsoup.connect(href).userAgent(UrlUtils.enrzAgent).timeout(10000).get();
			// System.out.println(doc.toString());
			try {
				Element globalnavElement = doc.select("div.banner").first();
				Elements moduleElements = globalnavElement.select("li");
				if (moduleElements != null && moduleElements.size() > 0) {
					for (int i = 0; i < moduleElements.size(); i++) {
						IndexFocusBean sbean = new IndexFocusBean();
						try {
							/**
                    <li><span onclick="location.href='http://www.zcool.com.cn/event/wonderwoman/wap/'">
                    <img _src="http://img.zcool.cn/community/focus/e376591e5250000001109664e343.jpg" 
                    src="http://static.zcool.cn/v3.5.170516.4/zcool/client/image/blank.png"></span></li>
                    <li>
							 */
							try {
								Element aElement = moduleElements.get(i).select("span").first();
								if (aElement != null) {
									String hrefa = aElement.attr("onclick");
									Log.i(TAG, "i==" + i + ";hrefa==" + hrefa);
									sbean.setHref(hrefa);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}

							try {
								Element imgElement = moduleElements.get(i).select("img").first();
								if (imgElement != null) {
									String src = imgElement.attr("_src");
									Log.i(TAG, "i==" + i + ";src==" + src);
									sbean.setSrc(src);
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
