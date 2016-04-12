package com.yt.android.util;

import android.app.Activity;
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

    //传递参数
    public static String Intent_Activity_Params = "activity";
    //学校概况
    public static String school = "xuexiaogaikuang";

    public static String news = "news";

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


    /**
     * 跳转activity并且传递参数
     *
     * @param activity
     * @param clazz
     * @param params   传递参数的key
     * @param values   传递参数的值
     */
    public static void clickButtonActivity(Activity activity, Class clazz, String params, String values) {
        Intent intent = new Intent(activity, clazz);
        intent.putExtra(params, values);
        activity.startActivity(intent);
    }


    /**
     * 跳转activity并且传递参数
     *
     * @param activity
     * @param clazz
     * @param params   传递参数的key
     * @param values   传递参数的值
     * @param idKey    sqlLite 主键名称
     * @param idValue  主键的值
     */
    public static void clickButtonActivity(Activity activity, Class clazz, String params, String values, String idKey, String idValue) {
        Intent intent = new Intent(activity, clazz);
        intent.putExtra(params, values);
        intent.putExtra(idKey, idValue);
        activity.startActivity(intent);
    }

    /**
     * 获取传递参数的方法
     *
     * @param intent
     * @param params 要获取的key
     * @return
     */
    public static String getIntentParams(Intent intent, String params) {
        String values = null;
        if (intent != null) {
            values = intent.getStringExtra(params);
        }
        return values;
    }


}
