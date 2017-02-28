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
import com.open.zcool.bean.EnterpriseMainBean;
import com.open.zcool.utils.UrlUtils;

public class EnterPriseMainService extends CommonService {
	public static final String TAG = EnterPriseMainService.class.getSimpleName();

	public static List<EnterpriseMainBean> parseEnterPriseMain(String href,int pagerno) {
		List<EnterpriseMainBean> list = new ArrayList<EnterpriseMainBean>();
		try {
			 
			href = href +"&pageNo="+pagerno;
			Log.i(TAG, "url = " + href);

			Document doc = Jsoup.connect(href).userAgent(UrlUtils.enrzAgent).timeout(10000).get();
			// System.out.println(doc.toString());
			try {
				Element globalnavElement = doc.select("div.company-list").first();
				Elements moduleElements = globalnavElement.select("div.bg-fff");
				if (moduleElements != null && moduleElements.size() > 0) {
					for (int i = 0; i < moduleElements.size(); i++) {
						EnterpriseMainBean sbean = new EnterpriseMainBean();
						try {
							 
							try {
									String hrefa = moduleElements.get(i).select("a").first().attr("href");
									Log.i(TAG, "i==" + i + ";hrefa==" + hrefa);
									sbean.setHref(hrefa);
							} catch (Exception e) {
								e.printStackTrace();
							}
							
							try {
								Element divElement = moduleElements.get(i).select("div.text-box").first();
								if (divElement != null) {
									String title = divElement.select("div").first().toString();;
									Log.i(TAG, "i==" + i + ";title==" + title);
									sbean.setTitle(title);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}

							try {
								Element picElement = moduleElements.get(i).select("div.pic-box").first();
								if (picElement != null) {
									String src = picElement.select("img").first().attr("src");
									Log.i(TAG, "i==" + i + ";src==" + src);
									sbean.setSrc(src);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
							
							try {
								Element divElement = moduleElements.get(i).select("div.text-box").first();
								if (divElement != null) {
									Elements iElements = divElement.select("i.iconpic");
									StringBuffer mt = new StringBuffer();
									for(int j=0;j<iElements.size();j++){
										Element iElement = iElements.get(j);
										if(iElement!=null){
											Element spanElement = iElement.nextElementSibling();
											if(j==iElements.size()-1){
												mt.append("职位正在招聘");
											}
											mt.append(spanElement.text()+" ");
										}
									}
									Log.i(TAG, "i==" + i + ";mt==" + mt.toString());
									sbean.setMt(mt.toString());
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
							
							try {
								Element divElement = moduleElements.get(i).select("div.job-tags").first();
								if (divElement != null) {
									String tags = divElement.toString().replace("</span>", "").replace("<span>", "  ");
									Log.i(TAG, "i==" + i + ";tags==" + tags);
									sbean.setTags(tags);
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
