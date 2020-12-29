package com.android.task2.utilities;

import android.content.Context;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.android.task2.R;
import com.bumptech.glide.Glide;

public final class BindingUtils {

    private BindingUtils() {
        // This class is not publicly instantiable
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Context context = imageView.getContext();
        Glide.with(context)
                .load(url)
                .into(imageView);


    }

    @BindingAdapter("menuImages")
    public static void setMenuImage(ImageView imageView, String option) {
        Context context = imageView.getContext();
        switch (option) {

            case "1":
                imageView.setImageResource(R.drawable.home);
                break;
            case "2":
                Glide.with(context)
                        .load(R.raw.settings)
                        .into(imageView);
                break;
            case "3":
                Glide.with(context)
                        .load(R.raw.mail)
                        .into(imageView);

                break;
            case "4":
                imageView.setImageResource(R.drawable.user);
                break;

        }


    }

}


