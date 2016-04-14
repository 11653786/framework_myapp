package com.yt.android.contains;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.yt.android.R;

import java.util.ArrayList;
import java.util.List;

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
            imageViewIDS = new int[]{R.drawable.lunbo111, R.drawable.lunbo222,
                    R.drawable.lunbo333, R.drawable.lunbo444};
            for (int i = 0; i < imageViewIDS.length; i++) {
                ImageView imageView = new ImageView(activity);
                imageView.setBackgroundResource(imageViewIDS[i]);
                imageViews.add(imageView);
            }
        }

        return imageViews;

    }


    /**
     * 添加小圆孔
     *
     * @param advPics
     * @param context
     * @param group
     */
    public static ImageView[] addRadioButton(List<ImageView> advPics, Context context, ViewGroup group) {
        //选择框
        ImageView[] radioButtons = new ImageView[advPics.size()];

        for (int i = 0; i < advPics.size(); i++) {
            ImageView imageView1 = new ImageView(context);
            imageView1.setLayoutParams(new ViewGroup.LayoutParams(20, 20));
            imageView1.setPadding(5, 5, 5, 5);
            radioButtons[i] = imageView1;
            if (i == 0) {
                radioButtons[i]
                        .setBackgroundResource(R.drawable.banner_dian_focus);
            } else {
                radioButtons[i]
                        .setBackgroundResource(R.drawable.banner_dian_blur);
            }
            group.addView(radioButtons[i]);
        }

        return radioButtons;
    }

}
