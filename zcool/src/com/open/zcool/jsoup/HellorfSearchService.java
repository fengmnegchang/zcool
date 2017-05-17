package com.open.zcool.jsoup;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.util.Log;

import com.open.android.jsoup.CommonService;
import com.open.zcool.bean.HellorfSearchBean;
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
	
	public static List<HellorfSearchBean> parseSearchGrid(String href,int pageNo) {
		List<HellorfSearchBean> list = new ArrayList<HellorfSearchBean>();
		try {
			if(pageNo>1){
				href = href +"&page="+pageNo;
			}
			Log.i(TAG, "url = " + href);
			Document doc = Jsoup.connect(href).userAgent(UrlUtils.enrzAgent).timeout(10000).get();
			// System.out.println(doc.toString());
			/**
			 * /***
				 * <div class="imgItem maskWraper" style="background-color:#EEEEEE;display:none">
    <div id="rect" style="overflow:hidden;">
        <a title="" 
            data-id = "589267616";
            data-index="0"
            data-title="empty cockpit of vehicle, HUD(Head Up Display) and digital speedometer, autonomous car" 
            class="preview lazy" 
            target="_blank" 
            data-preview="http://hellorfimg.zcool.cn/preview/589267616.jpg" 
            data-width="450" data-height="253" href="http://www.hellorf.com/image/589267616?keyword=&source=search">
        <img data-original="http://hellorfimg.zcool.cn/preview/589267616.jpg" onerror="this.onerror='';this.src='http://hellorfimg.zcool.cn/preview/589267616.jpg'" alt="empty cockpit of vehicle, HUD(Head Up Display) and digital speedometer, autonomous car">
        </a>
    </div>
    <div class="maskBar" style="">
        <a id="favImageId_589267616" onclick="showFavorite(589267616, 'http://thumb106.test-ss.cn/thumb_large/1369678/589267616/stock-photo-empty-cockpit-of-vehicle-hud-head-up-display-and-digital-speedometer-autonomous-car-589267616.jpg', 1)" class="icon icon-favorite" href="javascript:void(0);"></a>
    </div>
</div>

			 */
			try {
				Element moduleElement = doc.select("div.imgList").first();
				Elements moduleElements = moduleElement.select("div.imgItem");
				if (moduleElements != null && moduleElements.size() > 0) {
					for (int i = 0; i < moduleElements.size(); i++) {
						try {
							HellorfSearchBean bean = new HellorfSearchBean();
							try {
								Element aElement = moduleElements.get(i).select("a").first();
								if (aElement != null) {
									String title = aElement.attr("data-title");
									Log.i(TAG, "i==" + i + ";title==" + title);
									bean.setTitle(title);
									
									String hrefa = aElement.attr("href");
									Log.i(TAG, "i==" + i + ";hrefa==" + hrefa);
									bean.setHref(hrefa);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
							
							try {
								Element aElement = moduleElements.get(i).select("a").first();
								if (aElement != null) {
									String src = aElement.attr("data-preview");
									Log.i(TAG, "i==" + i + ";src==" + src);
									bean.setSrc(src);
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
