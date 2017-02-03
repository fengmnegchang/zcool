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
import com.open.zcool.bean.IndexMainBean;
import com.open.zcool.utils.UrlUtils;

public class IndexMainListService extends CommonService {
	public static final String TAG = IndexMainListService.class.getSimpleName();

	public static List<IndexMainBean> parseIndexMain(String href, int pagerno) {
		List<IndexMainBean> list = new ArrayList<IndexMainBean>();
		try {
			if (pagerno > 1) {
				//http://www.zcool.com.cn/index!3.html#mainList
				href = href + "index!" + pagerno+".html#mainList";
			}
			href = makeURL(href, new HashMap<String, Object>() {
				{
				}
			});
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
}
