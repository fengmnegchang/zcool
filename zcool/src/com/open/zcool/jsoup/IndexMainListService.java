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

public class IndexMainListService extends CommonService {
	public static final String TAG = IndexMainListService.class.getSimpleName();

	public static List<IndexMainBean> parseIndexMain(String href, int pagerno) {
		List<IndexMainBean> list = new ArrayList<IndexMainBean>();
		try {
			if(href.contains(UrlUtils.ZCOOL_WORKS)){
				if (pagerno > 1) {
					//http://www.zcool.com.cn/works/0!0!null!0!0!200!1!1!!!
					//http://www.zcool.com.cn/works/0!0!null!0!0!200!1!2!!!
					href = href + "0!0!null!0!0!200!1!" + pagerno+"!!!";
				}
			}else{
				if (pagerno > 1) {
					//http://www.zcool.com.cn/index!3.html#mainList
					href = href + "index!" + pagerno+".html#mainList";
				}
			}
			Log.i(TAG, "url = " + href);
			Document doc = Jsoup.connect(href).userAgent(UrlUtils.enrzAgent).timeout(10000).get();
			// System.out.println(doc.toString());

			try {
				Element globalnavElement = doc.select("ul.camWholeBoxUl").first();
				Elements moduleElements = globalnavElement.select("li");
				if (moduleElements != null && moduleElements.size() > 0) {
					for (int i = 0; i < moduleElements.size(); i++) {
						IndexMainBean tbean = new IndexMainBean();
						try {
							/**
							 * <li>
                	<a href="http://www.zcool.com.cn/work/ZMjAwNzAzMTI=
.html" st_t="click" st_n="index_main_pic"
					   title="logo collection by seevisual" target="_blank" class="image-link">
                		<img src="http://img.zcool.cn/community/031c3915893f0a0a801219c77573800.jpg@250w_188h_1c_1e_2o_100sh.jpg" width="250" height="188" alt="logo collection by seevisual"
							srcset="http://img.zcool.cn/community/031c3915893f0a0a801219c77573800.jpg@500w_376h_1c_1e_1l_2o_100sh.jpg 2x, http://img.zcool.cn/community/031c3915893f0a0a801219c77573800.jpg@750w_564h_1c_1e_1l_2o_100sh.jpg 3x"/>
                	</a>
                    <div class="camLiCon">
                        <div class="camLiTitleC hot">
							<p><a href="http://www.zcool.com.cn/work/ZMjAwNzAzMTI=
.html" st_t="click" st_n="index_main_title"
								  title="logo collection by seevisual" target="_blank">logo collection</a></p>
						</div>
                        <div class="camLiDes"><b>
							<a href="http://www.zcool.com.cn/works/" st_t="click" st_n="index_main_obj"
													style="color:#ff0084;">
								原创作品</a></b>
                         
                        
                        - <a href="http://www.zcool.com.cn/works/8!0!0!0!0!200!1!1!!!/" st_t="click" st_n="index_main_cate">平面</a>
                         
                        
                         - <a href="http://www.zcool.com.cn/works/8!15!0!0!0!200!1!1!!!/" st_t="click" st_n="index_main_subcate" class="more-omitted">VI/CI</a>
                        
                         <br />4小时前上传<br /><span class="cf30">2559</span>  人气 <span>/</span> <span class="cf30">14</span> 评论 <span>/</span> 
                         <span class="cf30">102</span> 推荐
                         </div>
                        <table width="100%">
                        	<tr>
                                <td><p class="pcIcons">
								</p>
                                </td>
                            	<td class="right vm">
                                	<span class="c999">
										<a href="http://seevisual.zcool.com.cn" target="_blank"
										   title="seevisual">seevisual</a>
									</span>
									<a href="http://seevisual.zcool.com.cn" title="seevisual" target="_blank" class="image-link">
										<img src="http://img.zcool.cn/community/04b1b25874b0e0a801219c7721704a.jpg@48w_48h_2o_100sh.jpg" alt="seevisual" width="30" height="30" />
									</a>
                                </td>
                            </tr>
                        </table>
                    </div>
                </li>

							 */
							try {
								/**
								 * <a href="http://www.zcool.com.cn/work/ZMjAwNzAzMTI=
.html" st_t="click" st_n="index_main_pic"
					   title="logo collection by seevisual" target="_blank" class="image-link">
                		<img src="http://img.zcool.cn/community/031c3915893f0a0a801219c77573800.jpg@250w_188h_1c_1e_2o_100sh.jpg" width="250" height="188" alt="logo collection by seevisual"
							srcset="http://img.zcool.cn/community/031c3915893f0a0a801219c77573800.jpg@500w_376h_1c_1e_1l_2o_100sh.jpg 2x, http://img.zcool.cn/community/031c3915893f0a0a801219c77573800.jpg@750w_564h_1c_1e_1l_2o_100sh.jpg 3x"/>
                	</a>

								 */
								Element stampElement = moduleElements.get(i).select("a").first();
								if (stampElement != null) {
									Element aElement = stampElement.select("a").first();
									String hrefa = aElement.attr("href");
									Log.i(TAG, "i==" + i +  ";hrefa==" + hrefa);
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
								Element camLiDesElement = moduleElements.get(i).select("div.camLiDes").first();
								if (camLiDesElement != null) {
									String camLiDes = camLiDesElement.toString();
									Log.i(TAG, "i==" + i + ";camLiDes==" + camLiDes);
									tbean.setCamLiDes(camLiDes);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
							try {
								Element camLiTitleCElement = moduleElements.get(i).select("div.camLiTitleC").first();
								if (camLiTitleCElement != null) {
									String title = camLiTitleCElement.select("a").first().text();
									Log.i(TAG, "i==" + i + ";title==" + title);
									tbean.setTitle(title);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
							
							//<td class="right vm">
							try {
								Element rightElement = moduleElements.get(i).select("td.right").first();
								if (rightElement != null) {
									Element aElement = rightElement.select("a").first();
									String author = aElement.text();
									String authorhref = aElement.attr("href");
									Log.i(TAG, "i==" + i +  ";author==" + author+";authorhref="+authorhref);
									tbean.setAuthor(author);
									tbean.setAuthorhref(authorhref);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
							
							try {
								Element rightElement = moduleElements.get(i).select("td.right").first();
								if (rightElement != null) {
									Element aElement = rightElement.select("img").first();
									String authorIcons = aElement.attr("src");
									Log.i(TAG, "i==" + i +  ";authorIcons==" + authorIcons);
									tbean.setAuthorIcons(authorIcons);
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
	
	public static List<IndexMainBean> parseWorksFoot(String href) {
		List<IndexMainBean> list = new ArrayList<IndexMainBean>();
		try {
			Document doc = Jsoup.parse(href);
			// System.out.println(doc.toString());
			try {
				Element globalnavElement = doc.select("ul.camWholeBoxUl").first();
				Elements moduleElements = globalnavElement.select("li");
				if (moduleElements != null && moduleElements.size() > 0) {
					for (int i = 0; i < moduleElements.size(); i++) {
						IndexMainBean tbean = new IndexMainBean();
						try {
							try {
								/**
								 */
								Element stampElement = moduleElements.get(i).select("a").first();
								if (stampElement != null) {
									Element aElement = stampElement.select("a").first();
									String hrefa = aElement.attr("href");
									Log.i(TAG, "i==" + i +  ";hrefa==" + hrefa);
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
								Element camLiDesElement = moduleElements.get(i).select("div.camLiDes").first();
								if (camLiDesElement != null) {
									String camLiDes = camLiDesElement.toString();
									Log.i(TAG, "i==" + i + ";camLiDes==" + camLiDes);
									tbean.setCamLiDes(camLiDes);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
							try {
								Element camLiTitleCElement = moduleElements.get(i).select("div.camLiTitle").first();
								if (camLiTitleCElement != null) {
									String title = camLiTitleCElement.select("a").first().text();
									Log.i(TAG, "i==" + i + ";title==" + title);
									tbean.setTitle(title);
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
	
	public static List<IndexMainBean> parseArticleMain(String href, int pagerno) {
		List<IndexMainBean> list = new ArrayList<IndexMainBean>();
		try {
			 if(href.contains("!")){
				//http://www.zcool.com.cn/articles/0!0!0!1!3!100!2!1/
				 //http://www.zcool.com.cn/articles/0!0!0!1!3!100!2!2/
				//http://www.zcool.com.cn/articles/0!0!0!0!0!0!4!1/
				 //http://www.zcool.com.cn/articles/0!0!0!0!0!0!4!2/
				 href = href.replace("1/", "")  + pagerno +"/";
			 }else{
				 //http://www.zcool.com.cn/articles
				if (pagerno > 1) {
					href = href + "0!0!0!0!0!200!1!" + pagerno +"/";
				}
			 }
			Log.i(TAG, "url = " + href);
			Document doc = Jsoup.connect(href).userAgent(UrlUtils.enrzAgent).timeout(10000).get();
			// System.out.println(doc.toString());

			/**
			 * <li>
								<a href="http://www.zcool.com.cn/article/ZNDczOTk2.html"  st_t="click" st_n="articles_main_pic"
								   title="如何理性分析一个作品 by 左佐工作室" target="_blank" class="fLeft mr10 image-link">
									<img src="http://img.zcool.cn/community/0321e9358b78495a801219c7769d4c3.jpg@250w_188h_1c_1e_2o_100sh.jpg" width="250" height="188" alt="如何理性分析一个作品 by 左佐工作室"/>
								</a>
								<div class="upJyBoxCon">
									<div class="ujTitle"> <b><a href="http://www.zcool.com.cn/article/ZNDczOTk2.html"  st_t="click" st_n="articles_main_title"
																title="如何理性分析一个作品 by 左佐工作室" target="_blank">如何理性分析一个作品</a></b>
										 <span class="hotSpan lv3"></span> 
									</div>
									<div class="blackLink mt5">
										<p class="c999"> <span style="color:#a6ce38;">设计文章</span> - <a href="/articles/707!708!0!0!0!200!1!1/" st_t="click" st_n="articles_main_cate"><font color="#666666">酷友观点/经验</font></a> - <a href="/articles/707!708!0!0!0!200!1!1/" st_t="click" st_n="articles_main_subcate"><font color="#666666">设计观点</font></a> <br/>
											39分钟前上传 / <span class="cf30">1262</span> 人气 / <span class="cf30">11</span> 评论 / <span class="cf30">73</span> 推荐</p>
										<p class="c999 mt5 ofHidden" style="height:63px;"></p>
									</div>
									<div class="right mt10 vm">
										<a href="http://archerzuo.zcool.com.cn" title="左佐工作室" target="_blank" class="c999"> 左佐工作室 </a>
										<a href="http://archerzuo.zcool.com.cn" title="左佐工作室" target="_blank" class="image-link">
											<img src="http://img.zcool.cn/community/04449d553f53c300000199877a9271.jpg@48w_48h_2o_100sh.jpg" alt="左佐工作室" width="30" height="30" />
										</a>
									</div>
								</div>
							</li>
						

			 */
			try {
				Element globalnavElement = doc.select("div.upJyBox").first();
				Elements moduleElements = globalnavElement.select("li");
				if (moduleElements != null && moduleElements.size() > 0) {
					for (int i = 0; i < moduleElements.size(); i++) {
						IndexMainBean tbean = new IndexMainBean();
						try {
							try {
								/**
								 * <a href="http://www.zcool.com.cn/article/ZNDczOTk2.html"  st_t="click" st_n="articles_main_pic"
								   title="如何理性分析一个作品 by 左佐工作室" target="_blank" class="fLeft mr10 image-link">
									<img src="http://img.zcool.cn/community/0321e9358b78495a801219c7769d4c3.jpg@250w_188h_1c_1e_2o_100sh.jpg" width="250" height="188" alt="如何理性分析一个作品 by 左佐工作室"/>
								</a>
								 */
								Element stampElement = moduleElements.get(i).select("a").first();
								if (stampElement != null) {
									Element aElement = stampElement.select("a").first();
									String hrefa = aElement.attr("href");
									Log.i(TAG, "i==" + i +  ";hrefa==" + hrefa);
									tbean.setHref(hrefa);
									String title = aElement.attr("title");
									Log.i(TAG, "i==" + i + ";title==" + title);
									tbean.setTitle(title);
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
							 * <div class="blackLink mt5">
										<p class="c999"> <span style="color:#a6ce38;">设计文章</span> - <a href="/articles/707!708!0!0!0!200!1!1/" st_t="click" st_n="articles_main_cate"><font color="#666666">酷友观点/经验</font></a> - <a href="/articles/707!708!0!0!0!200!1!1/" st_t="click" st_n="articles_main_subcate"><font color="#666666">设计观点</font></a> <br/>
											39分钟前上传 / <span class="cf30">1262</span> 人气 / <span class="cf30">11</span> 评论 / <span class="cf30">73</span> 推荐</p>
										<p class="c999 mt5 ofHidden" style="height:63px;"></p>
									</div>
							 */
							try {
								Element camLiDesElement = moduleElements.get(i).select("div.blackLink").first();
								if (camLiDesElement != null) {
									String camLiDes = camLiDesElement.toString();
									Log.i(TAG, "i==" + i + ";camLiDes==" + camLiDes);
									tbean.setCamLiDes(camLiDes);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
							 
							/**
							 * <div class="right mt10 vm">
										<a href="http://archerzuo.zcool.com.cn" title="左佐工作室" target="_blank" class="c999"> 左佐工作室 </a>
										<a href="http://archerzuo.zcool.com.cn" title="左佐工作室" target="_blank" class="image-link">
											<img src="http://img.zcool.cn/community/04449d553f53c300000199877a9271.jpg@48w_48h_2o_100sh.jpg" alt="左佐工作室" width="30" height="30" />
										</a>
									</div>
							 */
							try {
								Element rightElement = moduleElements.get(i).select("div.right").first();
								if (rightElement != null) {
									Element aElement = rightElement.select("a").first();
									String author = aElement.text();
									String authorhref = aElement.attr("href");
									Log.i(TAG, "i==" + i +  ";author==" + author+";authorhref="+authorhref);
									tbean.setAuthor(author);
									tbean.setAuthorhref(authorhref);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
							
							try {
								Element rightElement = moduleElements.get(i).select("div.right").first();
								if (rightElement != null) {
									Element aElement = rightElement.select("img").first();
									String authorIcons = aElement.attr("src");
									Log.i(TAG, "i==" + i +  ";authorIcons==" + authorIcons);
									tbean.setAuthorIcons(authorIcons);
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
