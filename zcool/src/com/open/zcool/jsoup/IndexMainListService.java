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
	
	public static List<IndexMainBean> parseEventMain(String href, int pagerno) {
		List<IndexMainBean> list = new ArrayList<IndexMainBean>();
		try {
			  
			 //http://www.zcool.com.cn/articles
			if (pagerno > 1) {
				if(href.contains("?status")){
					href = href + "&p=" + pagerno ;
				}else{
					href = href + "?p=" + pagerno ;
				}
				
			}
			 
			Log.i(TAG, "url = " + href);
			Document doc = Jsoup.connect(href).userAgent(UrlUtils.enrzAgent).timeout(10000).get();
			// System.out.println(doc.toString());

			/**
			 *  <li>
		          <span class="tongjiBar">
		          <i class="iconpic iconpic-view"></i> 297121&nbsp;&nbsp;&nbsp;
		          <i class="iconpic iconpic-user2"></i> 1044 &nbsp;&nbsp;&nbsp;
		          <i class="iconpic iconpic-pic"></i> 764</span>
		          <p class="f16"><b>
		          <a href="http://www.zcool.com.cn/event/MXD2/"
		           title="冒险造型师 - 冒险岛2&Paul Frank联名款服装图案设计征集" target="_blank">冒险造型师 - 冒险岛2&Paul Frank联名款服装图案设计征集</a></b>（进行中）</p>
		          <p class="c999 mb10">投稿时间：<span class="cf30">2017-04-06</span> – <span class="cf30">2017-05-05</span></p>
		          <p style="position:relative">
			  	<span class="closing-date">距离截稿<br>日期还有<br><b>2</b>天</span>
			  <a href="http://www.zcool.com.cn/event/MXD2/" title="冒险造型师 - 冒险岛2&Paul Frank联名款服装图案设计征集" target="_blank"><img src="http://img.zcool.cn/community/index/a1e858e49f5b0000017330072f5f.jpg" width="965" /></a></p>
		        </li>
			 */
			try {
				Element globalnavElement = doc.select("ul.activeList").first();
				Elements moduleElements = globalnavElement.select("li");
				if (moduleElements != null && moduleElements.size() > 0) {
					for (int i = 0; i < moduleElements.size(); i++) {
						IndexMainBean tbean = new IndexMainBean();
						try {
							try {
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
								Element picElement = moduleElements.get(i).select("img").first();
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
							 
							 */
							try {
								Element camLiDesElement = moduleElements.get(i).select("p.f16").first();
								if (camLiDesElement != null) {
									String camLiDes = camLiDesElement.toString();
									Log.i(TAG, "i==" + i + ";camLiDes==" + camLiDes);
									tbean.setCamLiDes(camLiDes);
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
	
	public static List<IndexMainBean> parseActMain(String href, int pagerno) {
		List<IndexMainBean> list = new ArrayList<IndexMainBean>();
		try {
			 if(pagerno>1){
				 href = href+"0!0!"+pagerno+"/";
			 }
			Log.i(TAG, "url = " + href);
			Document doc = Jsoup.connect(href).userAgent(UrlUtils.enrzAgent).timeout(10000).get();
			// System.out.println(doc.toString());
			try {
				Elements moduleElements = doc.select("div.upJyBoxCon");
				if (moduleElements != null && moduleElements.size() > 0) {
					for (int i = 0; i < moduleElements.size(); i++) {
						IndexMainBean tbean = new IndexMainBean();
						try {
							try {
								Element stampElement = moduleElements.get(i).parent().select("a").first();
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
								Element picElement = moduleElements.get(i).parent().select("img").first();
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
							 
							 */
							try {
								Element camLiDesElement = moduleElements.get(i);
								if (camLiDesElement != null) {
									String camLiDes = camLiDesElement.toString();
									Log.i(TAG, "i==" + i + ";camLiDes==" + camLiDes);
									tbean.setCamLiDes(camLiDes);
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
	
	public static List<IndexMainBean> parseToDesignersMain(String href, int pagerno) {
		List<IndexMainBean> list = new ArrayList<IndexMainBean>();
		try {
			 if(pagerno>1){
				 href = href+"&p="+pagerno;
			 }
			Log.i(TAG, "url = " + href);
			Document doc = Jsoup.connect(href).userAgent(UrlUtils.enrzAgent).timeout(10000).get();
			// System.out.println(doc.toString());
			try {
				/**
				 * <li>
							<a href="http://www.zcool.com.cn/u/13051742" class="fLeft image-link" title="SUNRTEAM" target="_blank">
								<img src="http://img.zcool.cn/community/043c2255472c3e0000019ae99ea4aa.jpg" width="145" height="145" />
							</a>
							<div class="atPerson">
									<div class="vm">
										<b><a href="http://www.zcool.com.cn/u/13051742" class="c4095ce f14" target="_blank">SUNRTEAM</a></b>
						<a href="http://www.zcool.com.cn/toDesigners.do" class="image-link"
						   target="_blank" title="推荐设计师"><img src="http://static.zcool.cn/z/images/svg/honor_tuijian_designer.svg" width="16" height="16" /></a>
												</div> 男
								<span class="c999">/</span>  天津市 <span class="c999">/</span> 其他　<br />
								<div class="c999">
									<p class="atPersonDes">QQ：86911208</p>
								粉丝：<a href="http://www.zcool.com.cn/u/13051742/zcooler_fans.xhtml" class="c4095ce" target="_blank">449</a>　　
									作品：<a href="http://www.zcool.com.cn/u/13051742" class="c4095ce" target="_blank">2</a><br />
									</div>
								</div>
								<div class="atImg">
									<a href="http://www.zcool.com.cn/work/ZNzE4OTA2NA==.html" target="_blank" class="image-link">
										<img src="http://img.zcool.cn/community/031d38c5566c724000001cc299bb457.jpg@100w_75h_1c_1e_2o_100sh.jpg" width="100" height="75" /></a>
									<a href="http://www.zcool.com.cn/work/ZNzEyMDQyNA==.html" target="_blank" class="image-link">
										<img src="http://img.zcool.cn/community/031734a5566c765000001cc29c40946.jpg@100w_75h_1c_1e_2o_100sh.jpg" width="100" height="75" /></a>
								</div>
										<a href="javascript:void(0)"  onclick="follow(this,13051742)" title="添加关注" class="apBtn"></a>
							</li>
				 */
				Element globalnavElement = doc.select("ul.layout").first();
				Elements moduleElements = globalnavElement.select("li");
				if (moduleElements != null && moduleElements.size() > 0) {
					for (int i = 0; i < moduleElements.size(); i++) {
						IndexMainBean tbean = new IndexMainBean();
						try {
							try {
								Element stampElement = moduleElements.get(i).select("a").first();
								if (stampElement != null) {
									Element aElement = stampElement.select("a").first();
									String title = aElement.attr("title");
									Log.i(TAG, "i==" + i + ";title==" + title);
									tbean.setTitle(title);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
							
							try {
								Element stampElement = moduleElements.get(i).select("div.vm").first();
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
								Element picElement = moduleElements.get(i).select("img").first();
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
							 
							 */
							try {
								Element camLiDesElement = moduleElements.get(i).select("div.atPerson").first();
								if (camLiDesElement != null) {
									String camLiDes = camLiDesElement.toString();
									Log.i(TAG, "i==" + i + ";camLiDes==" + camLiDes);
									tbean.setCamLiDes(camLiDes);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
							 
							 
							
							try {
								Element rightElement = moduleElements.get(i).select("div.atImg").first();
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
