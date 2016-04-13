package com.yt.android.activity.detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.yt.android.R;
import com.yt.android.base.BaseActivity;
import com.yt.android.entity.Attachment;
import com.yt.android.help.DataBaseHelper;
import com.yt.android.util.IntentUtil;

/**
 * 查看详情activity,学校概况
 *
 * @author zhangsan
 * @version 1.0
 * @package com.yt.android.activity.detail
 * @date 2016/4/12 0012 10:33
 * @descption: 疯狂的王麻子团队!
 */
public class DetailActivity extends BaseActivity implements View.OnClickListener {

    private Button returnButton;
    private TextView desc;          //内容
    private ImageView image;        //图片
    private TextView biaoti;        //顶部标题


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();
    }

    public void initView() {
        returnButton = (Button) findViewById(R.id.returnbutton);
        image = (ImageView) findViewById(R.id.image);
        desc = (TextView) findViewById(R.id.desc);
        biaoti = (TextView) findViewById(R.id.biaoti);
        returnButton.setOnClickListener(this);
        initIntent();
    }

    /**
     * 获取传递过来的参数方法
     */
    public void initIntent() {
        Intent intent = this.getIntent();
        if (intent != null) {
            //获取从那个activity传递过来的参数
            String activityParams = intent.getStringExtra(IntentUtil.Intent_Activity_Params);
            if (activityParams != null && !activityParams.equals("")) {
                //学校概况
                if (activityParams.equalsIgnoreCase(IntentUtil.school)) {
                }
            } else {
                //其他5个view在里面
                String id = IntentUtil.getIntentParams(getIntent(), "id");
                //标题
                String actions = IntentUtil.getIntentParams(getIntent(), "actions");
                biaoti.setText(actions);
                if (id != null && !id.equals("")) {
                    Attachment attachment = DataBaseHelper.findAttachmentById(getApplicationContext(), DataBaseHelper.getAttachmentById, id);
                    if (attachment != null) {
                        image.setBackgroundResource(attachment.getImage());
                        desc.setText(attachment.getContent());
                    }
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
