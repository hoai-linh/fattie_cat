package com.example.twinklestar.fatiecat.view.helper;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * custom binding
 */

public class DatabindingHelper {
    /**
     * Download Image and display in view
     *
     * @param imageView
     * @param url
     * @param error     error pic
     */
    @BindingAdapter({"imageUrl", "error"})
    public static void loadImage(ImageView imageView, String url, Drawable error) {
        if (url == null || url.isEmpty()) {
            imageView.setImageDrawable(error);
            return;
        }
        Picasso.with(imageView.getContext()).load(url).error(error).into(imageView);
    }

    /**
     * loadImage (having placeholder)
     */
    @BindingAdapter({"imageUrl", "placeholder", "error"})
    public static void loadImage(ImageView view, Drawable placeholder, Drawable error, String url) {
        if (url == null || url.isEmpty()) {
            view.setImageDrawable(error);
            return;
        }
        Picasso.with(view.getContext()).load(url).placeholder(placeholder).error(error).into(view);
    }

    @BindingAdapter("isVisible")
    public static void visible(View view, boolean isVisible) {
        view.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    }


}
