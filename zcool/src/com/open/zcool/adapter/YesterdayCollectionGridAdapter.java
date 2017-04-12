/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-4-12下午4:51:58
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.zcool.adapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.open.zcool.R;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

 

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-4-12下午4:51:58
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class YesterdayCollectionGridAdapter  extends RecyclerView.Adapter<YesterdayCollectionGridAdapter.BaseViewHolder> {
    private ArrayList<String> dataList = new ArrayList<String>();
    private Resources res;
    public void replaceAll(ArrayList<String> list) {
        dataList.clear();
        if (list != null && list.size() > 0) {
            dataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override
    public YesterdayCollectionGridAdapter.BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new OneViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_yesterday_collection_grid, parent, false));
    }

    @Override
    public void onBindViewHolder(YesterdayCollectionGridAdapter.BaseViewHolder holder, int position) {

        holder.setData(dataList.get(position));
    }


    @Override
    public int getItemCount() {
        return dataList != null ? dataList.size() : 0;
    }

    public class BaseViewHolder extends RecyclerView.ViewHolder {

        public BaseViewHolder(View itemView) {
            super(itemView);
        }

        void setData(Object data) {
        }
    }

    private class OneViewHolder extends BaseViewHolder {
        private ImageView ivImage;

        public OneViewHolder(View view) {
            super(view);
            ivImage = (ImageView) view.findViewById(R.id.ivImage);
            int width = ((Activity) ivImage.getContext()).getWindowManager().getDefaultDisplay().getWidth();
            ViewGroup.LayoutParams params = ivImage.getLayoutParams();
            //设置图片的相对于屏幕的宽高比
            params.width = width/3;
            params.height =  (int) (200 + Math.random() * 400) ;
            ivImage.setLayoutParams(params);
            res = itemView.getContext().getResources();
        }

        @Override
        void setData(Object data) {
            if (data != null) {
                String text = (String) data;
                if (text != null && text.length()  > 0) {
    				DisplayImageOptions options = new DisplayImageOptions.Builder().showStubImage(R.drawable.common_z).showImageForEmptyUri(R.drawable.common_z).showImageOnFail(R.drawable.common_z)
    						.cacheInMemory().cacheOnDisc().build();
    				ImageLoader.getInstance().displayImage(text, ivImage, options, getImageLoadingListener());
    			}
//                Glide.with(itemView.getContext()).load(text).diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.mipmap.ic_launcher).crossFade().into(ivImage);
//                Bitmap bitmap = BitmapFactory.decodeResource(res,R.mipmap.ic_launcher);
//                //异步获得bitmap图片颜色值
//                Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
//                    @Override
//                    public void onGenerated(Palette palette) {
//                        Palette.Swatch vibrant = palette.getVibrantSwatch();//有活力
//                        Palette.Swatch c = palette.getDarkVibrantSwatch();//有活力 暗色
//                        Palette.Swatch d = palette.getLightVibrantSwatch();//有活力 亮色
//                        Palette.Swatch f = palette.getMutedSwatch();//柔和
//                        Palette.Swatch a = palette.getDarkMutedSwatch();//柔和 暗色
//                        Palette.Swatch b = palette.getLightMutedSwatch();//柔和 亮色
//
//                        if (vibrant != null) {
//                            int color1 = vibrant.getBodyTextColor();//内容颜色
//                            int color2 = vibrant.getTitleTextColor();//标题颜色
//                            int color3 = vibrant.getRgb();//rgb颜色
//
//                            ivImage.setBackgroundColor(
//                                    vibrant.getRgb());
//
//                        }
//                    }
//                });
            }


        }
    }
    private ImageLoadingListener animateFirstListener = new AnimateFirstDisplayListener();
    protected ImageLoadingListener getImageLoadingListener() {
		return animateFirstListener;
	}

	private static class AnimateFirstDisplayListener extends SimpleImageLoadingListener {
		public static final List<String> displayedImages = Collections.synchronizedList(new LinkedList<String>());
		@Override
		public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
			if (loadedImage != null) {
				ImageView imageView = (ImageView) view;
				boolean firstDisplay = !displayedImages.contains(imageUri);
				if (firstDisplay) {
					FadeInBitmapDisplayer.animate(imageView, 500);
					displayedImages.add(imageUri);
				}
			}
		}
	}
}
