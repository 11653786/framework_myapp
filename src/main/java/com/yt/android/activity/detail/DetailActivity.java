package com.yt.android.activity.detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.yt.android.R;
import com.yt.android.base.BaseActivity;
import com.yt.android.info.SchoolInfo;
import com.yt.android.util.IntentUtil;

/**
 * 查看详情activity
 *
 * @author zhangsan
 * @version 1.0
 * @package com.yt.android.activity.detail
 * @date 2016/4/12 0012 10:33
 * @descption: 疯狂的王麻子团队!
 */
public class DetailActivity extends BaseActivity implements View.OnClickListener {

    private Button returnButton;
    private TextView desc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();
    }

    public void initView() {
        returnButton = (Button) findViewById(R.id.returnbutton);
        desc = (Button) findViewById(R.id.desc);
        returnButton.setOnClickListener(this);
        initIntent();
    }

    public void initIntent() {
        Intent intent = this.getIntent();
        if (intent != null) {
            //获取从那个activity传递过来的参数
            String activityParams = intent.getStringExtra(IntentUtil.Intent_Activity_Params);
            if (activityParams != null && !activityParams.equals("")) {
                //学校概况
                if (activityParams.equalsIgnoreCase(IntentUtil.school)) {
                    desc.setText(SchoolInfo.School_Introduce);
                }
            }
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.returnbutton:
                this.finish();
                break;
        }
    }
}
