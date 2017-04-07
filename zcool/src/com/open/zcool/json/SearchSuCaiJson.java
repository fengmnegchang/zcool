/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-4-7下午2:20:03
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.zcool.json;

import java.util.ArrayList;
import java.util.List;

import com.open.android.json.CommonJson;
import com.open.zcool.bean.ToolsSearchKeysBean;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-4-7下午2:20:03
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class SearchSuCaiJson extends CommonJson {
	private List<ToolsSearchKeysBean> indexnavlist = new ArrayList<ToolsSearchKeysBean>();
	private List<ToolsSearchKeysBean> hotWordsLeftlist = new ArrayList<ToolsSearchKeysBean>();
	private List<ToolsSearchKeysBean> hotWordsRightlist = new ArrayList<ToolsSearchKeysBean>();
	public List<ToolsSearchKeysBean> getIndexnavlist() {
		return indexnavlist;
	}
	public void setIndexnavlist(List<ToolsSearchKeysBean> indexnavlist) {
		this.indexnavlist = indexnavlist;
	}
	public List<ToolsSearchKeysBean> getHotWordsLeftlist() {
		return hotWordsLeftlist;
	}
	public void setHotWordsLeftlist(List<ToolsSearchKeysBean> hotWordsLeftlist) {
		this.hotWordsLeftlist = hotWordsLeftlist;
	}
	public List<ToolsSearchKeysBean> getHotWordsRightlist() {
		return hotWordsRightlist;
	}
	public void setHotWordsRightlist(List<ToolsSearchKeysBean> hotWordsRightlist) {
		this.hotWordsRightlist = hotWordsRightlist;
	}

}
