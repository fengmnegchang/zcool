package com.open.zcool.jsoup;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.util.Log;

import com.open.android.jsoup.CommonService;
import com.open.zcool.bean.HotAuthorsBean;
import com.open.zcool.utils.UrlUtils;

public class MonthHotAuthorsListService extends CommonService {
	public static final String TAG = MonthHotAuthorsListService.class.getSimpleName();

	public static List<HotAuthorsBean> parseIndexMain(String href, int pagerno) {
		List<HotAuthorsBean> list = new ArrayList<HotAuthorsBean>();
		try {
			Log.i(TAG, "url = " + href);
			Document doc = Jsoup.connect(href).userAgent(UrlUtils.enrzAgent).timeout(10000).get();
			// System.out.println(doc.toString());

			/**
			 * <li>
				<span class='hasFlagSpan yellow '>1</span>
				<a href="http://zhongenhui.zcool.com.cn" title="zhongenhui" class="fLeft mr10 image-link" target="_blank">
					<img src="http://img.zcool.cn/community/0480e1587c3163a8010ec63c004193.jpg@64w_64h_2o_100sh.jpg" alt="zhongenhui" width="64" height="64"/>
				</a>
				<div><a href="http://zhongenhui.zcool.com.cn" title="zhongenhui" target="_blank" class="f14 c666">zhongenhui</a>
					<p class="c666">美国 / 学生</p>
				</div>
				</li>
			 */
			try {
				Element globalnavElement = doc.select("ul.rolList").get(1);
				Elements moduleElements = globalnavElement.select("li");
				if (moduleElements != null && moduleElements.size() > 0) {
					for (int i = 0; i < moduleElements.size(); i++) {
						HotAuthorsBean tbean = new HotAuthorsBean();
						try {
							try {
								Element stampElement = moduleElements.get(i).select("a").first();
								if (stampElement != null) {
									Element aElement = stampElement.select("a").first();
									String hrefa = aElement.attr("href");
									Log.i(TAG, "i==" + i +  ";hrefa==" + hrefa);
									tbean.setHref(hrefa);
									tbean.setTitle(aElement.attr("title"));
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
							 
							try {
								Element picElement = moduleElements.get(i).select("a").first();
								if (picElement != null) {
									Element imgElement = picElement.select("img").first();
									String src = imgElement.attr("src");
									Log.i(TAG, "i==" + i + ";src==" + src);
									tbean.setSrc(src);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
							
							try {
								Element picElement = moduleElements.get(i).select("div").first();
								if (picElement != null) {
									String div = picElement.toString();
									Log.i(TAG, "i==" + i + ";div==" + div);
									tbean.setDivp(div);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}

						} catch (Exception e) {
							e.printStackTrace();
						}
						list.add(tbean);

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
