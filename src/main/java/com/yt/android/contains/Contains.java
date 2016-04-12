package com.yt.android.contains;

import android.content.Context;
import android.widget.ImageView;
import com.yt.android.R;

import java.util.ArrayList;

/**
 * 代码优化轮播图的图片
 *
 * @author zhangsan
 * @version 1.0
 * @package com.yt.android.contains
 * @date 2016/4/8 0008 10:10
 * @descption: 疯狂的王麻子团队!
 */
public class Contains {
    public static ArrayList<ImageView> imageViews = new ArrayList<ImageView>();
    public static int[] imageViewIDS;


    public static ArrayList<ImageView> setImageViews(Context activity) {
        if (imageViews.isEmpty()) {
            imageViewIDS = new int[]{R.drawable.lunbo1, R.drawable.lunbo2,
                    R.drawable.lunbo3,R.drawable.lunbo4};
            for (int i = 0; i < imageViewIDS.length; i++) {
                ImageView imageView = new ImageView(activity);
                imageView.setBackgroundResource(imageViewIDS[i]);
                imageViews.add(imageView);
            }
        }

        return imageViews;

    }
}
