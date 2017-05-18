package com.open.zcool.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * *****************************************************************************
 * *****************************************************************************
 * ******************
 * 
 * @author :fengguangjing
 * @createTime: 16/11/16
 * @version:
 * @modifyTime:
 * @modifyAuthor:
 * @description: 
 *               ****************************************************************
 *               ***************************************************************
 *               *********************************************
 */
public class UrlUtils {
   /** 浏览器代理 **/
	public static final String userAgent = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31";
	public static final String tencentAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.75 Safari/537.36 QQBrowser/4.1.4132.400";
	public static final String enrzAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.75 Safari/537.36 QQBrowser/4.1.4132.400";
	public static final String COOKIE = "__cfduid=df0a47eed3d6f56b0ce2b54928ced11051483189834; CNZZDATA1000003418=380336421-1483185838-%7C1483852222";
	/** pc 站酷HTTP**/
	public static final String ZCOOL_HTTP = "http://www.zcool.com.cn";
	/** pc 站酷首页**/
	public static final String ZCOOL = "http://www.zcool.com.cn/";
	/** pc 站酷Job**/
	public static final String ZCOOL_JOB = "http://www.zcool.com.cn/job/";
	/**搜索demo**/
	public static final String ZCOOL_SEARCH_POST = "http://www.zcool.com.cn/job/searchpost.do?keys=%E8%A7%86%E8%A7%89&search_cityid=66&search_districtid=0&search_experienceid=0&search_diplomaid=-1&search_stageid=0&search_industryid=0&search_workstatus=0&search_salaryid=0&orderflag=undefined";
	/** 企业**/
	public static final String ZCOOL_SEARCH_POST_QIYE = "http://www.zcool.com.cn/job/qiye?pagesize=10&search_cityid=66&search_districtid=0&search_stageid=0&search_industryid=0";
	/**搜索keys**/
	public static final String ZCOOL_SEARCH_POST_KEYS = "http://www.zcool.com.cn/job/searchpost.do?search_cityid=66&search_districtid=0&search_experienceid=0&search_diplomaid=-1&search_stageid=0&search_industryid=0&search_workstatus=0&search_salaryid=0&orderflag=undefined&keys=";
	/**常驻企业**/
	public static final String ZCOOL_LIST_VIP_COMPANY = "http://www.zcool.com.cn/job/listVipCompany.do?position=companyindex&pageNo=1&pageSize=10";
	/** pc 作品**/
	public static final String ZCOOL_WORKS = "http://www.zcool.com.cn/works/";
	/**您也许会对以下作品感兴趣换一换***/
	public static final String ZCOOL_GUESS = "http://www.zcool.com.cn/works/guess";
	/**搜索***/
	public static final String ZCOOL_TO_SEARCH = "http://www.zcool.com.cn/tosearch.do?";
	/** pc 文章**/
	public static final String ZCOOL_ARTICLES = "http://www.zcool.com.cn/articles/";
	/** pc 工具搜素材**/
	public static final String ZCOOL_SUCAI = "http://sucai.zcool.com.cn/";
	/** 赛事列表**/
	public static final String ZCOOL_EVENT = "http://www.zcool.com.cn/event/eventlist.do";
	/** 活动列表**/
	public static final String ZCOOL_ACTIVITIES = "http://www.zcool.com.cn/activities/";
	/** 酷友/设计师列表**/
	public static final String ZCOOL_TO_DESIGNERS ="http://www.zcool.com.cn/toDesigners.do?flag=1";
	/**  酷友精彩评论列表**/
	public static final String ZCOOL_NEWEST_COMMENT ="http://www.zcool.com.cn/newestComment.do";
	/** 专题 列表**/
	public static final String ZCOOL_SPECIAL ="http://www.zcool.com.cn/special/speciallist.do?type=0";
	/**海洛搜索***/
	public static final String HELLO_RF_SEARCH = "http://www.hellorf.com/";
	/**海洛搜索列表***/
	public static final String HELLO_RF_SEARCH_GRID = "http://www.hellorf.com/image/search?category=0";
	/**海洛搜索图片地址***/
	public static final String HELLO_RF_SEARCH_IMAGE = "http://www.hellorf.com/image/search/";
	/**海洛搜索视频地址***/
	public static final String HELLO_RF_SEARCH_VIDEO = "http://www.hellorf.com/video/search/";
	
	public static String getCookie(){
		return COOKIE;
	}
	/**
	 * JsonObjectRequest 请求设置Headers
	 */
	public static Map<String,String> getHeaders(){
	 Map<String, String> headers = new HashMap<String, String>();
	 headers.put("Cookie",
	 "3g_guest_id=-9045538589999304704; cuid=5032023480; sd_userid=27201462782213238; sd_cookie_crttime=1462782213238; eas_sid=y1i4W655K8T8X9U3N3p7C7U2x7; pac_uid=1_624926379; qq_slist_autoplay=on; tvfe_boss_uuid=e776aacde64effb9; h_uid=H01560819fdc; mobileUV=1_158907f70d3_bbd13; ts_refer=enrz.com/fhm/2016/12/02/73248.html; _as_crazy3044487=2016-12-8-2-; pgv_pvi=6908002304; pgv_si=s4405479424; ptui_loginuin=624926379@qq.com; pt2gguin=o0624926379; uin=o0624926379; skey=@4EK94rAAo; ptisp=ctc; RK=CesXfneTOj; luin=o0624926379; lskey=00010000dc8afe64b0ce27f57820dcefd38a902ab9d67698fc42f999b4d492033045767f379c6947e7546ae8; ptcz=c307e47376dee800ee4a82794866f608297b218323a8b12fd611bbd8f75f86b6; login_remember=qq; uid=33415391; _qddaz=QD.h8tbub.d2q19w.iwg3c671; _qddamta_800079372=3-0; _qdda=3-1.4ngq3; _qddab=3-zbc4bc.iwg3c675; ad_play_index=52; _as_crazy3052371=2016-12-8-1-; qv_als=xAYAySR21BA7HIk4A11481185160GHgZLw==; ptag=|v_qq_com; pgv_info=ssid=s8679421312; ts_last=v.qq.com/u/history/; pgv_pvid=6914624368; o_cookie=624926379; ts_uid=3813777356; main_login=qq; encuin=f2caf7e2c580066b6f356522325b0902|624926379; lw_nick=%E5%BE%A1%E5%AE%88|624926379|//q4.qlogo.cn/g?b=qq&k=wSLCLgsnNYsxT924yLUn3Q&s=40&t=663|1");
	 headers.put("Accept","*/*");
	 headers.put("Accept-Encoding","gzip, deflate, sdch");
	 headers.put("Accept-Language","zh-CN,zh;q=0.8");
	 headers.put("Connection","keep-alive");
//	 headers.put("Host","data.video.qq.com");
//	 headers.put("Referer","http://v.qq.com/x/search/?q=%E9%94%A6%E7%BB%A3%E6%9C%AA%E5%A4%AE&stag=101&smartbox_ab=");
//	 headers.put("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31");
	 headers.put("User-Agent",tencentAgent);
	 return headers;
	 }
	
	/**
	 * webview 请求设置Cookies
	 */
	public static String getWebCookies() {
		String cookie = "3g_guest_id=-9045538589999304704; cuid=5032023480; sd_userid=27201462782213238; sd_cookie_crttime=1462782213238; eas_sid=y1i4W655K8T8X9U3N3p7C7U2x7; pac_uid=1_624926379; qq_slist_autoplay=on; tvfe_boss_uuid=e776aacde64effb9; h_uid=H01560819fdc; mobileUV=1_158907f70d3_bbd13; ts_refer=enrz.com/fhm/2016/12/02/73248.html; RK=CesXfneTOj; ptui_loginuin=624926379@qq.com; pt2gguin=o0624926379; luin=o0624926379; lskey=000100000426cf179de687a53cb07fc9f627768a534dd985707ade55845085252bc89239dd583b28feea12e5; ptcz=c307e47376dee800ee4a82794866f608297b218323a8b12fd611bbd8f75f86b6; login_remember=qq; uid=33415391; _qddaz=QD.h8tbub.d2q19w.iwg3c671; _qddab=3-zhwcm3.iwo9s4ym; oversea_limit=0; ptag=|u; main_login=qq; encuin=f2caf7e2c580066b6f356522325b0902|624926379; lw_nick=%E5%BE%A1%E5%AE%88|624926379|//q4.qlogo.cn/g?b=qq&k=wSLCLgsnNYsxT924yLUn3Q&s=40&t=663|1; o_cookie=624926379; pgv_info=ssid=s9656053119; ts_last=v.qq.com/x/cover/avuik2dix9zqv8p.html; pgv_pvid=6914624368; ts_uid=3813777356; qv_als=5WieZfTgwMtJC/ZhA114816976900iuUPw==; ad_play_index=54";
		return cookie;
	}
}
