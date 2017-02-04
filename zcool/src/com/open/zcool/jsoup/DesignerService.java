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
import com.open.zcool.bean.DesignerBean;
import com.open.zcool.utils.UrlUtils;

public class DesignerService extends CommonService {
	public static final String TAG = DesignerService.class.getSimpleName();

	public static List<DesignerBean> parseDesigner(String href) {
		List<DesignerBean> list = new ArrayList<DesignerBean>();
		try {
			href = makeURL(href, new HashMap<String, Object>() {
				{
				}
			});
			Log.i(TAG, "url = " + href);

			Document doc = Jsoup.connect(href).userAgent(UrlUtils.enrzAgent).timeout(10000).get();
			// System.out.println(doc.toString());
			try {
				Element globalnavElement = doc.select("ul.designerList").first();
				Elements moduleElements = globalnavElement.select("li");
				if (moduleElements != null && moduleElements.size() > 0) {
					for (int i = 0; i < moduleElements.size(); i++) {
						DesignerBean sbean = new DesignerBean();
						try {
							/**
							 * <li class="layout borderNone" style="padding-left:20px">
                            	<a href="http://www.zcool.com.cn/u/569990" class="pLeft image-link" target="_blank">
									<img src="http://img.zcool.cn/community/04c2b355405f690000017c506fd0ba.jpg@48w_48h_2o_100sh.jpg" width="48" height="48" alt="TOO扑热稀痛"/>
								</a>
                            	<p class="pRight c999">
									<a href="http://www.zcool.com.cn/u/569990" class="c666" target="_blank">TOO扑热稀痛</a><br/>
									北京市 / 绘画/插画师<br/>粉丝：3135 / 作品：21
								</p>
							</li>

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
								Element pElement = moduleElements.get(i).select("p.pRight").first();
								if (pElement != null) {
									String pRight = pElement.toString();
									Log.i(TAG, "i==" + i + ";pRight==" + pRight);
									sbean.setpRight(pRight);
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
