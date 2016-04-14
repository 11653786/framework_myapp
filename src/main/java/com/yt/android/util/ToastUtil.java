package com.yt.android.util;

import android.content.Context;
import android.widget.Toast;

/**
 * @author zhangsan
 * @version 1.0
 * @package com.yt.android.util
 * @date 2016/4/14 0014 10:20
 * @descption: 疯狂的王麻子团队!
 */
public class ToastUtil {

    /**
     * 语音播放的时候屏幕弹出的信息工具类
     *
     * @param context
     * @param str
     */
    public static void showTip(Context context, final String str) {
        Toast.makeText(context, str, Toast.LENGTH_SHORT).show();

    }
}
