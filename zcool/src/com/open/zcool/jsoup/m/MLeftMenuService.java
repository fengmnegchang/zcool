package com.open.zcool.jsoup.m;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.util.Log;

import com.open.android.jsoup.CommonService;
import com.open.zcool.bean.m.LeftMenuBean;
import com.open.zcool.utils.UrlUtils;

public class MLeftMenuService extends CommonService {
	public static final String TAG = MLeftMenuService.class.getSimpleName();

	public static List<LeftMenuBean> parseMenu(String href) {
		List<LeftMenuBean> list = new ArrayList<LeftMenuBean>();
		try {
			href = makeURL(href, new HashMap<String, Object>() {
				{
				}
			});
			Log.i(TAG, "url = " + href);

			Document doc = Jsoup.connect(href).userAgent(UrlUtils.enrzAgent).timeout(10000).get();
			// System.out.println(doc.toString());
			try {
				Element globalnavElement = doc.select("div.sideBox").first();
				Elements moduleElements = globalnavElement.select("a");
				if (moduleElements != null && moduleElements.size() > 0) {
					for (int i = 0; i < moduleElements.size(); i++) {
						LeftMenuBean sbean = new LeftMenuBean();
						try {
							/**
							 * <div class="c-999 sideBox">
										<!-- 登录状态 -->
										<a class="avatar-side va-m cl block" href="/u/13132490">
											<img class="block l radius" src="http://img.zcool.cn/community/1noavatar.gif@48w_48h_2o_100sh.jpg" alt="头像">
											<h2 class="block l pl-10">梦昶</h2>
										</a>
								<div class="sideBox-link pos-r">
									<a href="/index" class="active">原创</a>
									<a href="/activities" class="">活动</a>
									<a href="http://m.job.zcool.com.cn">招聘</a>
									<a href="/event/eventlist.do">赛事</a>
									<a href="http://m.hellorf.com">站酷海洛创意</a>
							<!-- 		<a href="/appdown">客户端</a> -->
							<!-- 		<a href="">专题</a> -->
								</div>
										<a href="javascript: logout();" class="pos-a quit-login">退出登录</a>
							</div>
							 */
							try {
								Element aElement = moduleElements.get(i).select("a").first();
								if (aElement != null) {
									String hrefa = aElement.attr("href");
									Log.i(TAG, "i==" + i + ";hrefa==" + hrefa);
									sbean.setHref(UrlUtils.ZCOOL_M_HOST+hrefa);
									sbean.setTitle(aElement.text());
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
