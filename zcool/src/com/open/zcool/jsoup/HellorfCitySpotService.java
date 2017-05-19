package com.open.zcool.jsoup;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.util.Log;

import com.open.android.jsoup.CommonService;
import com.open.zcool.bean.CitySpotBean;
import com.open.zcool.bean.HellorfSearchBean;
import com.open.zcool.utils.UrlUtils;

public class HellorfCitySpotService extends CommonService {
	public static final String TAG = HellorfCitySpotService.class.getSimpleName();
	
	public static List<CitySpotBean> parseCitySpot(String href,int pageNo) {
		List<CitySpotBean> list = new ArrayList<CitySpotBean>();
		try {
			if(pageNo>1){
				href = href +"?page="+pageNo;
			}
			Log.i(TAG, "url = " + href);
			Document doc = Jsoup.connect(href).userAgent(UrlUtils.enrzAgent).timeout(10000).get();
			// System.out.println(doc.toString());
			/**
			 * <li>
                <a href="http://www.hellorf.com/image/travel/44" target="_blank">
                                            <b class="c_f64c2e"><i>hot!&nbsp;</i></b>
                                        南京路 <span class="c-919190">（ 510 ）</span>
                </a>
            </li>
			 */
			try {
				Element moduleElement = doc.select("ul.jingdian-name-list").first();
				Elements moduleElements = moduleElement.select("li");
				if (moduleElements != null && moduleElements.size() > 0) {
					for (int i = 0; i < moduleElements.size(); i++) {
						try {
							CitySpotBean bean = new CitySpotBean();
							try {
								Element aElement = moduleElements.get(i).select("a").first();
								if (aElement != null) {
									String title = aElement.text();
									Log.i(TAG, "i==" + i + ";title==" + title);
									bean.setName(title);
									
									String hrefa = aElement.attr("href");
									Log.i(TAG, "i==" + i + ";hrefa==" + hrefa);
									bean.setHref(hrefa);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
							 
							list.add(bean);
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
		 
		return list;
	}
	
	 
}
