package com.open.zcool.jsoup;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.util.Log;

import com.open.android.jsoup.CommonService;
import com.open.zcool.bean.PageSpinnerBean;
import com.open.zcool.json.PageSpinnerJson;
import com.open.zcool.utils.UrlUtils;

public class ToSearchPageService extends CommonService {
	public static final String TAG = ToSearchPageService.class.getSimpleName();

	public static PageSpinnerJson parsePage(String href) {
		PageSpinnerJson mPageSpinnerJson =new PageSpinnerJson();
		try {
			Log.i(TAG, "url = " + href);
			Document doc = Jsoup.connect(href).userAgent(UrlUtils.enrzAgent).timeout(10000).get();
			// System.out.println(doc.toString());
			try {
				Element globalnavElement = doc.select("input.isTxtBig").first();
				Elements moduleElements = globalnavElement.parent().select("a");
				if (moduleElements != null && moduleElements.size() > 0) {
					for (int i = 0; i < moduleElements.size()-1; i++) {
						try {
							/**
							 * <div class="borderTop" style="margin-top:-1px;">
							 * <div class='bigPage pt20 pb30 vm center'>
							 * <a class='pagePrev' href='/tosearch.do?page=0&world=&cateType=0&subcateType=0&channel=0&other=0&sort=0&uid=0&time=0&limit=10&recommend=0&p=98' btnmode='true' hideFocus><b></b></a>
							 * <a href='/tosearch.do?page=0&world=&cateType=0&subcateType=0&channel=0&other=0&sort=0&uid=0&time=0&limit=10&recommend=0&p=1' btnmode='true' hideFocus>1</a>...
							 * <a href='/tosearch.do?page=0&world=&cateType=0&subcateType=0&channel=0&other=0&sort=0&uid=0&time=0&limit=10&recommend=0&p=95' btnmode='true' hideFocus>95</a> 
								<a href='/tosearch.do?page=0&world=&cateType=0&subcateType=0&channel=0&other=0&sort=0&uid=0&time=0&limit=10&recommend=0&p=96' btnmode='true' hideFocus>96</a> 
								<a href='/tosearch.do?page=0&world=&cateType=0&subcateType=0&channel=0&other=0&sort=0&uid=0&time=0&limit=10&recommend=0&p=97' btnmode='true' hideFocus>97</a> 
								<a href='/tosearch.do?page=0&world=&cateType=0&subcateType=0&channel=0&other=0&sort=0&uid=0&time=0&limit=10&recommend=0&p=98' btnmode='true' hideFocus>98</a> 
								<a href='/tosearch.do?page=0&world=&cateType=0&subcateType=0&channel=0&other=0&sort=0&uid=0&time=0&limit=10&recommend=0&p=99' btnmode='true' hideFocus class='selected'>99</a> 
								<a href='/tosearch.do?page=0&world=&cateType=0&subcateType=0&channel=0&other=0&sort=0&uid=0&time=0&limit=10&recommend=0&p=100' btnmode='true' hideFocus>100</a> 
								<a href='/tosearch.do?page=0&world=&cateType=0&subcateType=0&channel=0&other=0&sort=0&uid=0&time=0&limit=10&recommend=0&p=100' btnmode='true' hideFocus class='pageNext'><b></b></a>
								<span class='pl30 f14 c999'>跳转到:</span>
								<input class='isTxtBig w30' type='text' value='' />
								<a href='javascript:void(0);' 
								 onclick="javascript:if ($.trim($(this).prev().val())!=''
								  && !isNaN($(this).prev().val()))location.href='/tosearch.do?page=0&world=&cateType=0&subcateType=0&channel=0&other=0&sort=0&uid=0&time=0&limit=10&recommend=0&p='+$.trim($(this).prev().val())+''" 
								   btnmode='true' hideFocus>GO</a></div></div>
									</div>
							 */
							try {
								Element aElement = moduleElements.get(i).select("a").first();
								if (aElement != null) {
									String title = aElement.text();
									String hrefa =  aElement.attr("href");
									Log.i(TAG, "i==" + i + ";title==" + title+";hrefa==" + hrefa);
									
									
									int maxpage=0;
									try {
									  maxpage = Integer.parseInt(title);
									} catch (Exception e) {
										e.printStackTrace();
									}
									try {
										if(aElement.attr("class")!=null){
											if("selected".equals(aElement.attr("class"))){
												mPageSpinnerJson.setCurrentpage(maxpage);
												mPageSpinnerJson.setHref(aElement.attr("href"));
											}
										}
									} catch (Exception e) {
										e.printStackTrace();
									}
									if(maxpage>mPageSpinnerJson.getMaxpage()){
										mPageSpinnerJson.setMaxpage(maxpage);
									}
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
		
		List<PageSpinnerBean> list = new ArrayList<PageSpinnerBean>();
		PageSpinnerBean bean;
		for(int i=1;i<=mPageSpinnerJson.getMaxpage();i++){
			bean = new PageSpinnerBean();
			bean.setName("第"+i+"页");
			bean.setHref(mPageSpinnerJson.getHref().replace(""+mPageSpinnerJson.getCurrentpage(), "")+i);
			list.add(bean);
		}
		mPageSpinnerJson.setList(list);
		return mPageSpinnerJson;
	}
}
