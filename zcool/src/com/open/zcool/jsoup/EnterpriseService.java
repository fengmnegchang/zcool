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

public class EnterpriseService extends CommonService {
	public static final String TAG = EnterpriseService.class.getSimpleName();

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
				Element globalnavElement = doc.select("div.rollpicshow").first();
				Elements moduleElements = globalnavElement.select("li");
				if (moduleElements != null && moduleElements.size() > 0) {
					for (int i = 0; i < moduleElements.size(); i++) {
						IndexFocusBean sbean = new IndexFocusBean();
						try {
							/**
							<li class="radius"> 
							<a href="http://www.zcool.com.cn/job/qiye/614027.html?from=job_focus" 
							target="_blank" onClick="updateCnt_clicks(123)"> 
							<span class="pic-box">
							<img src="http://img.zcool.cn//job/f_focus/2d5f58089fd4a84a1a6be8b58c02" 
							title=""></span> </a> </li>
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
									String alt = imgElement.attr("title");
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
}
