package com.open.zcool.jsoup;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.util.Log;

import com.open.android.jsoup.CommonService;
import com.open.zcool.bean.IndexMainBean;
import com.open.zcool.utils.UrlUtils;

public class RightHotArticlesListService extends CommonService {
	public static final String TAG = RightHotArticlesListService.class.getSimpleName();

	public static List<IndexMainBean> parseIndexMain(String href, int pagerno) {
		List<IndexMainBean> list = new ArrayList<IndexMainBean>();
		try {
			Log.i(TAG, "url = " + href);
			Document doc = Jsoup.connect(href).userAgent(UrlUtils.enrzAgent).timeout(10000).get();
			// System.out.println(doc.toString());

			try {
				Element globalnavElement = doc.select("ul.rolList").first();
				Elements moduleElements = globalnavElement.select("li");
				if (moduleElements != null && moduleElements.size() > 0) {
					for (int i = 0; i < moduleElements.size(); i++) {
						IndexMainBean tbean = new IndexMainBean();
						try {
							/**
							 <li>
								<a href="http://www.zcool.com.cn/article/ZNDc1MDQ0.html" title="图叠字的四种常用技法 by IMART" class="fLeft mr10 image-link" target="_blank">
									<img src="http://img.zcool.cn/community/0323f4958bcc1a2a801219c779d006e.jpg@100w_75h_1c_1e_2o_100sh.jpg" width="100" height="75" alt="图叠字的四种常用技法 by IMART"/>
								</a>
								<div>
									<p style="height:55px;" class="ofHidden">
										<a href="http://www.zcool.com.cn/article/ZNDc1MDQ0.html" target="_blank" title="图叠字的四种常用技法 by IMART" class="f12 c999">图叠字的四种常用技法</a>
									</p>
									<p class="c999 pt5">人气：<span class="cf30">58025</span></p>
								</div>
							</li>
						


							 */
							try {
								 
								Element stampElement = moduleElements.get(i).select("a").first();
								if (stampElement != null) {
									Element aElement = stampElement.select("a").first();
									String hrefa = aElement.attr("href");
									Log.i(TAG, "i==" + i +  ";hrefa==" + hrefa);
									tbean.setHref(hrefa);
									String titlea = aElement.attr("title");
									Log.i(TAG, "i==" + i + ";titlea==" + titlea);
									tbean.setTitle(titlea);
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
								Element camLiDesElement = moduleElements.get(i).select("div").first();
								if (camLiDesElement != null) {
									String camLiDes = camLiDesElement.toString();
									Log.i(TAG, "i==" + i + ";camLiDes==" + camLiDes);
									tbean.setCamLiDes(camLiDes);
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
