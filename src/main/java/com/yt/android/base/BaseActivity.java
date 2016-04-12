package com.yt.android.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import com.yt.android.R;

/**
 * baseActivity以后用来做扩展
 *
 * @author zhangsan
 * @version 1.0
 * @package com.yt.android.base
 * @date 2016/4/6 0006 10:59
 * @descption: 疯狂的王麻子团队!
 */
public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);// 填充标题栏
        super.onCreate(savedInstanceState);
    }
}
