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
import com.open.zcool.json.ToSearchJson;
import com.open.zcool.utils.UrlUtils;

public class ToSearchService extends CommonService {
	public static final String TAG = ToSearchService.class.getSimpleName();

	public static ToSearchJson parseSearchHot(String href) {
		ToSearchJson hotjson = new ToSearchJson();
		List<String> olist = new ArrayList<String>();
		List<String> plist = new ArrayList<String>();
		List<String> mlist = new ArrayList<String>();
		try {
			Log.i(TAG, "url = " + href);
			Document doc = Jsoup.connect(href).userAgent(UrlUtils.enrzAgent).timeout(10000).get();
			// System.out.println(doc.toString());
			try {
				Element globalnavElement = doc.select("span.searchSelectBox").first();
				Elements moduleElements = globalnavElement.select("option");
				if (moduleElements != null && moduleElements.size() > 0) {
					for (int i = 0; i < moduleElements.size(); i++) {
						try {
							/**
							 * <select id='searchSelectBox'> <option value="0"
							 * selected="selected">全站搜索</option> <option
							 * value="1" >原创作品</option> <option value="2"
							 * >设计文章</option> <option value="3" >佳作欣赏</option>
							 * <option value="4" >设计素材</option> <option
							 * value="5" >设计师</option> </select>
							 */
							try {
								Element aElement = moduleElements.get(i).select("option").first();
								if (aElement != null) {
									String title = aElement.text() + aElement.attr("value");
									Log.i(TAG, "i==" + i + ";title==" + title);
									plist.add(title);
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

			try {
				Elements moduleElements = doc.select("div.dBoxTitleS");
				if (moduleElements != null && moduleElements.size() > 0) {
					for (int i = 0; i < moduleElements.size(); i++) {
						try {
							try {
								Element aElement = moduleElements.get(i).select("div.dBoxTitleS").first();
								if (aElement != null) {
									String title = aElement.text();
									Log.i(TAG, "i==" + i + ";title==" + title);
									/**
									 * <div class="tsListS">
									 * <a href="/tosearch.do?page=1&level=&sort=1&time=0&limit=20&world=背景">背景</a>
									 * <a href="/tosearch.do?page=1&level=&sort=1&time=0&limit=20&world=新年">新年</a>
									 * <a href="/tosearch.do?page=1&level=&sort=1&time=0&limit=20&world=花卉">花卉</a>
									 * <a href="/tosearch.do?page=1&level=&sort=1&time=0&limit=20&world=时尚">时尚</a>
									 * <a href="/tosearch.do?page=1&level=&sort=1&time=0&limit=20&world=可爱">可爱</a>
									 * <a href="/tosearch.do?page=1&level=&sort=1&time=0&limit=20&world=潮流">潮流</a>
									 * <a href="/tosearch.do?page=1&level=&sort=1&time=0&limit=20&world=心形">心形</a>
									 * <a href="/tosearch.do?page=1&level=&sort=1&time=0&limit=20&world=T恤">T恤</a>
									 * <a href="/tosearch.do?page=1&level=&sort=1&time=0&limit=20&world=网页">网页</a>
									 * <a href="/tosearch.do?page=1&level=&sort=1&time=0&limit=20&world=中国风">中国风</a>
									 * <a href="/tosearch.do?page=1&level=&sort=1&time=0&limit=20&world=音乐">音乐</a>
									 * <a href="/tosearch.do?page=1&level=&sort=1&time=0&limit=20&world=box">box</a>
									 * <a href="/tosearch.do?page=1&level=&sort=1&time=0&limit=20&world=笔刷">笔刷</a>
									 * <a href="/tosearch.do?page=1&level=&sort=1&time=0&limit=20&world=商业">商业</a>
									 * <a href="/tosearch.do?page=1&level=&sort=1&time=0&limit=20&world=卡">卡</a>
									 * <a href="/tosearch.do?page=1&level=&sort=1&time=0&limit=20&world=家居">家居</a>
									 * <a href="/tosearch.do?page=1&level=&sort=1&time=0&limit=20&world=sale">sale</a>
									 * <a href="/tosearch.do?page=1&level=&sort=1&time=0&limit=20&world=花纹">花纹</a></div>
									 */
									Elements aElements = aElement.nextElementSibling().select("a");
									for(int j=0;j<aElements.size();j++){
										Element aaElement = aElements.get(j).select("a").first();
										Log.i(TAG, "i==" + i + ";j==" + j +";titlea==" + aaElement.text()+aaElement.attr("href"));
										if(title.equals("推荐您搜原创")){
											olist.add(aaElement.text());
										}else if(title.equals("推荐您搜素材")){
											mlist.add(aaElement.text());
										}
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
		hotjson.setOlist(olist);
		hotjson.setMlist(mlist);
		hotjson.setPlist(plist);
		return hotjson;
	}
}
