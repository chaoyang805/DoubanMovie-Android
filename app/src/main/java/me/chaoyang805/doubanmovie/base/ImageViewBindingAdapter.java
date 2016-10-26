package me.chaoyang805.doubanmovie.base;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by chaoyang805 on 16/10/17.
 */

public class ImageViewBindingAdapter {

    @BindingAdapter("android:imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }
}
