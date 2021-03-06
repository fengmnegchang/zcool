package com.open.zcool.jsoup;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.util.Log;

import com.open.android.jsoup.CommonService;
import com.open.zcool.bean.ToSearchMainBean;
import com.open.zcool.utils.UrlUtils;

public class ToSearchMainListService extends CommonService {
	public static final String TAG = ToSearchMainListService.class.getSimpleName();

	public static List<ToSearchMainBean> parseIndexMain(String href, int pagerno) {
		List<ToSearchMainBean> list = new ArrayList<ToSearchMainBean>();
		try {
			//http://www.zcool.com.cn/tosearch.do?page=0&world=
			//http://www.zcool.com.cn/tosearch.do?
			//http://www.zcool.com.cn/tosearch.do?page=0&world=&cateType=0&subcateType=0&channel=0&other=0&sort=0&uid=0&time=0&limit=10&recommend=0&p=2
			if (pagerno > 1) {
				href = href + "&cateType=0&subcateType=0&channel=0&other=0&sort=0&uid=0&time=0&limit=10&recommend=0&p=" + pagerno;
			}
			Log.i(TAG, "url = " + href);
			Document doc = Jsoup.connect(href).userAgent(UrlUtils.enrzAgent).timeout(10000).get();
			// System.out.println(doc.toString());
			try {
				/**
				 * <div class="upJyBoxImg">
                            	<a href="http://www.zcool.com.cn/work/ZMjA1NDIyMTI=.html" target="_blank" class="image-link">
									<img src="http://img.zcool.cn/community/03192b258b63ba7a801219c776c99ca.jpg@250w_188h_1c_1e_2o_100sh.jpg"/>
								</a>
                            </div>
                            <div class="upJyBoxCon">
                                <div class="ujTitle" style="display: block;width:440px;overflow: hidden;white-space: nowrap;text-overflow: ellipsis;">
                                	<b><a href="http://www.zcool.com.cn/work/ZMjA1NDIyMTI=.html" target="_blank" title="">校园大厅形象墙</a></b> 
                                </div>
                                <div class="blackLink">
                                	<a href="http://www.zcool.com.cn/u/0" class="c009cff" target="_blank"></a> 
                                	<span class="c999">2分钟前上传</span><br/>
                                		<b><a href="http://www.zcool.com.cn/works/"
											  style="color:#ff0084;">
												原创作品</a></b> -
                                	<a href="http://www.zcool.com.cn/works/8!0!0!0!0!200!1!1!!!/">平面</a>- 
                                	<a href="http://www.zcool.com.cn/works/8!11!0!0!0!200!1!1!!!/">其他平面</a>
                                </div>
                                <div class="caaa">0 人气 / 0 推荐 / 0 评论 / 0 收藏</div>
                                <div class="caaa ujCon">
								
                               	 	某学校初中部的三楼大厅和四楼大厅形象墙（分别取名：博学源/博雅源）平面上作图，最后交接空间部，由空同事帮忙渲染，博雅源的平面方案被pass掉，后来总监又提了修改建议，几经折腾，最后定稿方案，就是效果图
                                </div>
                                <div class="right">
                                </div>
                            </div>

				 */
				Elements moduleElements = doc.select("div.upJyBoxImg");
				if (moduleElements != null && moduleElements.size() > 0) {
					for (int i = 0; i < moduleElements.size(); i++) {
						ToSearchMainBean tbean = new ToSearchMainBean();
						try {
							/**
							 * <a href="http://www.zcool.com.cn/work/ZMjA1NDIyMTI=.html" target="_blank" class="image-link">
									<img src="http://img.zcool.cn/community/03192b258b63ba7a801219c776c99ca.jpg@250w_188h_1c_1e_2o_100sh.jpg"/>
								</a>
							 */
							try {
								Element stampElement = moduleElements.get(i).select("a").first();
								if (stampElement != null) {
									Element aElement = stampElement.select("a").first();
									String hrefa = aElement.attr("href");
									Log.i(TAG, "i==" + i + ";hrefa==" + hrefa);
									tbean.setHref(hrefa);
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

							/**
							 * <div class="upJyBoxCon">
                                <div class="ujTitle" style="display: block;width:440px;overflow: hidden;white-space: nowrap;text-overflow: ellipsis;">
                                	<b><a href="http://www.zcool.com.cn/work/ZMjA1NDIyMTI=.html" target="_blank" title="">校园大厅形象墙</a></b> 
                                </div>
							 */
							try {
								Element camLiDesElement = moduleElements.get(i).nextElementSibling().select("div.ujTitle").first();
								if (camLiDesElement != null) {
									String title = camLiDesElement.select("a").first().text();
									Log.i(TAG, "i==" + i + ";title==" + title);
									tbean.setTitle(title);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
							/**
							 * <div class="blackLink">
                                	<a href="http://www.zcool.com.cn/u/0" class="c009cff" target="_blank"></a> 
                                	<span class="c999">2分钟前上传</span><br/>
                                		<b><a href="http://www.zcool.com.cn/works/"
											  style="color:#ff0084;">
												原创作品</a></b> -
                                	<a href="http://www.zcool.com.cn/works/8!0!0!0!0!200!1!1!!!/">平面</a>- 
                                	<a href="http://www.zcool.com.cn/works/8!11!0!0!0!200!1!1!!!/">其他平面</a>
                                </div>

							 */
							try {
								Element camLiTitleCElement = moduleElements.get(i).nextElementSibling().select("div.blackLink").first();
								if (camLiTitleCElement != null) {
									String blackLink = camLiTitleCElement.toString();
									Log.i(TAG, "i==" + i + ";blackLink==" + blackLink);
									tbean.setBlackLink(blackLink);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}


							/**
							 *  <div class="caaa">0 人气 / 0 推荐 / 0 评论 / 0 收藏</div>
                                <div class="caaa ujCon">
                               	 	某学校初中部的三楼大厅和四楼大厅形象墙（分别取名：博学源/博雅源）平面上作图，最后交接空间部，由空同事帮忙渲染，博雅源的平面方案被pass掉，后来总监又提了修改建议，几经折腾，最后定稿方案，就是效果图
                                </div>

							 */
							try {
								Element caaaElement = moduleElements.get(i).nextElementSibling().select("div.caaa").first();
								Element caaaElement1 = moduleElements.get(i).nextElementSibling().select("div.caaa").get(1);
								if (caaaElement != null) {
									String caaa = caaaElement.text()+" "+caaaElement1.text();
									Log.i(TAG, "i==" + i + ";caaa==" + caaa);
									tbean.setCaaa(caaa);
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

	public static List<ToSearchMainBean> parseDesignerMain(String href, int pagerno) {
		List<ToSearchMainBean> list = new ArrayList<ToSearchMainBean>();
		try {
			//http://www.zcool.com.cn/tosearch.do?page=0&world=
			//http://www.zcool.com.cn/tosearch.do?
			//http://www.zcool.com.cn/tosearch.do?page=0&world=&cateType=0&subcateType=0&channel=0&other=0&sort=0&uid=0&time=0&limit=10&recommend=0&p=2
			if (pagerno > 1) {
				href = href + "&cateType=0&subcateType=0&channel=0&other=0&sort=0&uid=0&time=0&limit=10&recommend=0&p=" + pagerno;
			}
			Log.i(TAG, "url = " + href);
			Document doc = Jsoup.connect(href).userAgent(UrlUtils.enrzAgent).timeout(10000).get();
			// System.out.println(doc.toString());
			try {
				/**
 				<li ot="" oi="">
            	<a href="http://www.zcool.com.cn/u/562875" target="_blank" class="fLeft image-link">
            		<img src="http://img.zcool.cn/community/04ffbc56a82f8b0000014dcf80aedd.jpg" 
            		width="145" height="145" />
            	</a>
                <div class="atPersonS">
                    <div>
                    	<b><a href="http://www.zcool.com.cn/u/562875" target="_blank" 
                    	class="c009cff f14">卓设电子商务</a></b>
                    </div>
							男
                    	 <span class="c999">/</span> 泉州 <span class="c666">/</span> 平面设计师　粉丝：1690 原创：4140<br />
                    <div class="c999">标签：</div>
                    <div class="c999">简介：</div>
                </div>
                <a href="javascript:void(0)" onclick="follow(this,562875)"  title="添加关注"  class="apBtn  "></a>
            </li>
				 */
				Element moduleElement = doc.select("ul.layout").first();
				Elements moduleElements = moduleElement.select("li");
				if (moduleElements != null && moduleElements.size() > 0) {
					for (int i = 0; i < moduleElements.size(); i++) {
						ToSearchMainBean tbean = new ToSearchMainBean();
						try {
							try {
								Element stampElement = moduleElements.get(i).select("a").first();
								if (stampElement != null) {
									Element aElement = stampElement.select("a").first();
									String hrefa = aElement.attr("href");
									Log.i(TAG, "i==" + i + ";hrefa==" + hrefa);
									tbean.setHref(hrefa);
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
								Element camLiTitleCElement = moduleElements.get(i).nextElementSibling().select("div.atPersonS").first();
								if (camLiTitleCElement != null) {
									String blackLink = camLiTitleCElement.toString();
									Log.i(TAG, "i==" + i + ";blackLink==" + blackLink);
									tbean.setBlackLink(blackLink);
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
	
	public static List<ToSearchMainBean> parseMSearch(String href, int pagerno) {
		List<ToSearchMainBean> list = new ArrayList<ToSearchMainBean>();
		try {
			Document doc;
			if(pagerno==1){
				 doc = Jsoup.connect(href).userAgent(UrlUtils.enrzAgent).timeout(10000).get();
			}else{
				 doc = Jsoup.parse(href);
			}
			Log.i(TAG, "url = " + href);
			 
			// System.out.println(doc.toString());
			try {
				/**
				 *  
				 */
//				Element moduleElement = doc.select("div.pd-10").first();
				Elements moduleElements = doc.select("li.item");
				if (moduleElements != null && moduleElements.size() > 0) {
					for (int i = 0; i < moduleElements.size(); i++) {
						ToSearchMainBean tbean = new ToSearchMainBean();
						try {
							/**
							 * <li class="cl item" onclick="location.href='http://m.zcool.com.cn/work/ZMjE5OTk3Njg=.html'">
			    <div class="picbox"><img src="http://img.zcool.cn/community/0310821592505ffb5b3086ed46ee552.jpg@250w_188h_1c_1e_2o_100sh.jpg"></div>
			    <div class="textbox">
						<h2>
							神奇女侠的100种美
						</h2>
			    </div>
			    <p class="time">月岛_糖</p>
			    <p class="toolbar">
			    	<span><i class="iconpic iconpic-view"></i> <span>81</span></span>
			    	<span style="margin-left:20px"><i class="iconpic iconpic-zan"></i> <span>0</span></span>
			    </p>
			</li>
							 */
							try {
								Element stampElement = moduleElements.get(i).select("li.item").first();
								if (stampElement != null) {
									String hrefa = stampElement.attr("onclick");
									Log.i(TAG, "i==" + i + ";hrefa==" + hrefa);
									tbean.setHref(hrefa.replace("location.href='", "").replace("'", ""));
								}
							} catch (Exception e) {
								e.printStackTrace();
							}

							try {
								Element picElement = moduleElements.get(i).select("div.picbox").first();
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
								Element camLiDesElement = moduleElements.get(i).select("p.time").first();
								if (camLiDesElement != null) {
									String title = camLiDesElement.text();
									Log.i(TAG, "i==" + i + ";title==" + title);
									tbean.setTitle(title);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
							 
							try {
								Element camLiTitleCElement = moduleElements.get(i).select("p.toolbar").first();
								if (camLiTitleCElement != null) {
									String blackLink = camLiTitleCElement.toString();
									Log.i(TAG, "i==" + i + ";blackLink==" + blackLink);
									tbean.setBlackLink(blackLink);
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
