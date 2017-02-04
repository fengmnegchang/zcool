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
import com.open.zcool.bean.OpenTabBean;
import com.open.zcool.utils.UrlUtils;

public class RecommendJobTabService extends CommonService {
	public static final String TAG = RecommendJobTabService.class.getSimpleName();

	public static List<OpenTabBean> parseOpenTab(String href) {
		List<OpenTabBean> list = new ArrayList<OpenTabBean>();
		try {
			href = makeURL(href, new HashMap<String, Object>() {
				{
				}
			});
			Log.i(TAG, "url = " + href);

			Document doc = Jsoup.connect(href).userAgent(UrlUtils.enrzAgent).timeout(10000).get();
			// System.out.println(doc.toString());
			try {
				Element globalnavElement = doc.select("div.tab-category2").first();
				Elements moduleElements = globalnavElement.select("a");
				if (moduleElements != null && moduleElements.size() > 0) {
					for (int i = 0; i < moduleElements.size(); i++) {
						OpenTabBean sbean = new OpenTabBean();
						try {
							/**
							 * <div class="tab-category2">
					<a href="http://www.zcool.com.cn/job/index.do" class="current">推荐</a>
					<a href="http://www.zcool.com.cn/job/indexnew.do">最新</a>
				</div>

							 */
							try {
								Element divElement = moduleElements.get(i).select("a").first();
								if (divElement != null) {
									String hrefa = divElement.attr("href");
									Log.i(TAG, "i==" + i + ";hrefa==" + hrefa);
									sbean.setHref(hrefa);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
							
							try {
								Element divElement = moduleElements.get(i).select("a").first();
								if (divElement != null) {
									String title = divElement.text();
									Log.i(TAG, "i==" + i + ";title==" + title);
									sbean.setTitle(title);
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
