package com.yt.android.util;

import android.content.Context;
import android.content.Intent;

/**
 * 跳转activity工具类
 *
 * @author zhangsan
 * @version 1.0
 * @package com.yt.android.util
 * @date 2016/4/11 0011 12:47
 * @descption: 疯狂的王麻子团队!
 */
public class IntentUtil {

    /**
     * 跳转activity
     *
     * @param context
     * @param clazz
     */
    public static void clickButtonActivity(Context context, Class clazz) {
        Intent intent = new Intent(context, clazz);  //方法1
        context.startActivity(intent);
    }
}
