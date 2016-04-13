package com.yt.android.util;

import android.database.Cursor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 格式化时间的工具类
 *
 * @author zhangsan
 * @version 1.0
 * @package com.yt.android.util
 * @date 2016/4/13 0013 10:00
 * @descption: 疯狂的王麻子团队!
 */
public class DateUtil {

    public static final String formatter = "yyyy-MM-dd HH:mm:ss";

    /**
     * 格式化时间的工具类
     *
     * @param date
     * @param formatter
     * @return
     */
    public static String DateFormatter(Date date, String formatter) {
        return new SimpleDateFormat(formatter).format(date);
    }

    public static Date DateFormatter(Cursor c, String columnName) {
        String myDate = c.getString(c.getColumnIndex(columnName));
        return new Date(myDate);
    }
}
