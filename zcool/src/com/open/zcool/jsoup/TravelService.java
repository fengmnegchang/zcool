package com.open.zcool.jsoup;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.util.Log;

import com.open.android.jsoup.CommonService;
import com.open.zcool.R;
import com.open.zcool.bean.TravelCityBean;
import com.open.zcool.utils.UrlUtils;

public class TravelService extends CommonService {
	public static final String TAG = TravelService.class.getSimpleName();
	 
	public static List<TravelCityBean> parseSearchHot(String href) {
//		 List<TravelGroupBean> list = new ArrayList<TravelGroupBean>();
		List<TravelCityBean> citylist = new ArrayList<TravelCityBean>();
		TravelCityBean citybean;
		try {
			Log.i(TAG, "url = " + href);
			Document doc = Jsoup.connect(href).userAgent(UrlUtils.enrzAgent).timeout(10000).get();
			// System.out.println(doc.toString());
			 
			try {
				Elements divElement = doc.select("div.jingdian-index-box");
				Elements moduleElements = divElement.select("div.item");
				if (moduleElements != null && moduleElements.size() > 0) {
					for (int i = 0; i < moduleElements.size(); i++) {
//						TravelGroupBean groupbean = new TravelGroupBean();
						try {
							 /**
							  * <div class="f-16 c_333"><strong>山西</strong></div>
                <div class="jingdian-list"> 
							  */
							try {
								Element pElement =moduleElements.get(i).select("div.f-16").first();
								String pname = pElement.text();
								citybean = new TravelCityBean();
								citybean.setName(pname);
								citybean.setSectiontype(1);
								citylist.add(citybean);
//								groupbean.setName(pname);
							} catch (Exception e) {
								// TODO: handle exception
								e.printStackTrace();
							}
							
							try {
								Element listElement =moduleElements.get(i).select("div.jingdian-list").first();
								if(listElement!=null){
									Elements aElements = listElement.select("a");
//									List<TravelCityBean> citylist = new ArrayList<TravelCityBean>();
									
									if(aElements!=null && aElements.size()>0){
										for(int j=0;j<aElements.size();j++){
											citybean = new TravelCityBean();
											citybean.setSectiontype(0);
											try {
												Element aElement = aElements.get(j).select("a").first();
												citybean.setHref(aElement.attr("href"));
												citybean.setName(aElement.text());
											} catch (Exception e) {
												e.printStackTrace();
											}
											citylist.add(citybean);
										}
									}
//									groupbean.setList(citylist);
								}
							} catch (Exception e) {
								// TODO: handle exception
								e.printStackTrace();
							}
//							list.add(groupbean);
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
		return citylist;
	}
}
