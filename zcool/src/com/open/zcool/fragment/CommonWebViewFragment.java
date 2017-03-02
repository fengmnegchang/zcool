/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-2-3下午4:37:08
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.zcool.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.open.android.fragment.BaseV4Fragment;
import com.open.android.json.CommonJson;
import com.open.android.utils.DownLoadAsyncTask;
import com.open.zcool.R;
import com.open.zcool.utils.UrlUtils;

/**
 ***************************************************************************************************************************************************************************** 
 * 
 * @author :fengguangjing
 * @createTime:2017-2-3下午4:37:08
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 ***************************************************************************************************************************************************************************** 
 */
public class CommonWebViewFragment extends BaseV4Fragment<CommonJson, CommonWebViewFragment> {
	public WebView webview;
	public String url = UrlUtils.ZCOOL;

	public static CommonWebViewFragment newInstance(String url, boolean isVisibleToUser) {
		CommonWebViewFragment fragment = new CommonWebViewFragment();
		fragment.setFragment(fragment);
		fragment.setUserVisibleHint(isVisibleToUser);
		fragment.url = url;
		return fragment;
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_common_web, container, false);
		webview = (WebView) view.findViewById(R.id.webview);
		return view;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.enrz.activity.CommonFragmentActivity#bindEvent()
	 */
	@Override
	public void bindEvent() {
		// TODO Auto-generated method stub
		super.bindEvent();
		webview.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				WebView.HitTestResult result = ((WebView) v).getHitTestResult();
				int type = result.getType();
				switch (type) {
				case WebView.HitTestResult.IMAGE_TYPE:
					final String imgurl = result.getExtra();
					AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
					builder.setItems(new String[] { getActivity().getResources().getString(R.string.save_picture) }, new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							new DownLoadAsyncTask(getActivity(), imgurl).execute();
						}
					});
					builder.show();
					break;
				default:
					break;
				}
				return false;
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.newsinfo.CommonActivity#initValue()
	 */
	@Override
	public void initValues() {
		// TODO Auto-generated method stub
		WebSettings webSettings = webview.getSettings();
		webSettings.setJavaScriptEnabled(true);
		webSettings.setSupportZoom(true);
		webview.setWebViewClient(mWebViewClientBase);
		webview.setWebChromeClient(mWebChromeClientBase);
		// 设置出现缩放工具
		webSettings.setBuiltInZoomControls(true);
		// 扩大比例的缩放
		webSettings.setUseWideViewPort(true);
		webSettings.setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
		webSettings.setLoadWithOverviewMode(true);
		Log.i("WebViewActivity", "url==" + url);
		loadUrl();
	}

	public void loadUrl() {
		webview.loadUrl(url);
	}

	public WebViewClientBase mWebViewClientBase = new WebViewClientBase();

	public class WebViewClientBase extends WebViewClient {

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			// TODO Auto-generated method stub
			Log.i("WebViewClientBase", "url==" + url);
			// if(url.contains("ed2k://|file") ||
			// url.contains("thunder://")
			// ||url.contains("thunder://")
			// ||url.contains("xfplay://")
			// ||url.contains("qqdl://")
			// ||url.contains("flashget://")
			// ){
			// ClipboardManager copy = (ClipboardManager)
			// getSystemService(Context.CLIPBOARD_SERVICE);
			// copy.setText(url);
			// // DownLoadUtils.downLoad(EnrzWebViewActivity.this, url);
			// return true;
			// }
			return super.shouldOverrideUrlLoading(view, url);
		}

		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon) {
			// TODO Auto-generated method stub
			super.onPageStarted(view, url, favicon);
		}

		@Override
		public void onPageFinished(WebView view, String url) {
			// TODO Auto-generated method stub
			super.onPageFinished(view, url);
		}

		@Override
		public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
			// TODO Auto-generated method stub
			super.onReceivedError(view, errorCode, description, failingUrl);
		}

		@Override
		public void doUpdateVisitedHistory(WebView view, String url, boolean isReload) {
			// TODO Auto-generated method stub
			super.doUpdateVisitedHistory(view, url, isReload);
		}
	}

	public WebChromeClientBase mWebChromeClientBase = new WebChromeClientBase();

	private class WebChromeClientBase extends WebChromeClient {
		@Override
		public void onProgressChanged(WebView view, int newProgress) {
		}

		@Override
		public void onReceivedTitle(WebView view, String title) {
			// TODO Auto-generated method stub
			super.onReceivedTitle(view, title);
		}

		@Override
		public void onReceivedTouchIconUrl(WebView view, String url, boolean precomposed) {
			// TODO Auto-generated method stub
			super.onReceivedTouchIconUrl(view, url, precomposed);
		}

		@Override
		public boolean onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture, Message resultMsg) {
			// TODO Auto-generated method stub
			return super.onCreateWindow(view, isDialog, isUserGesture, resultMsg);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.open.enrz.fragment.BaseV4Fragment#handlerMessage(android.os.Message)
	 */
	@Override
	public void handlerMessage(Message msg) {
		// TODO Auto-generated method stub
		switch (msg.what) {
		case MESSAGE_HANDLER:
			break;
		default:
			break;
		}
	}
}