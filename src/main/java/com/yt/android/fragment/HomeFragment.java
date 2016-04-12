package com.yt.android.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.yt.android.R;
import com.yt.android.activity.detail.DetailActivity;
import com.yt.android.util.IntentUtil;

import java.util.Map;

/**
 * 首页fragment
 *
 * @author zhangsan
 * @version 1.0
 * @package com.yt.android.fragment
 * @date 2016/4/8 0008 17:43
 * @descption: 疯狂的王麻子团队!
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    //新闻,学校概况，院系介绍,校园风采,特色专业
    private Button news, xuexiaogaikuang, yuanxijieshao, xiaoyuanfengcai, tesezhuanye;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // 第一个参数是这个Fragment将要显示的界面布局,第二个参数是这个Fragment所属的Activity,第三个参数是决定此fragment是否附属于Activity
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        return view;
    }

    public void initView(View view) {
        news = (Button) view.findViewById(R.id.news);
        xuexiaogaikuang = (Button) view.findViewById(R.id.xuexiaogaikuang);
        yuanxijieshao = (Button) view.findViewById(R.id.yuanxijieshao);
        xiaoyuanfengcai = (Button) view.findViewById(R.id.xiaoyuanfengcai);
        tesezhuanye = (Button) view.findViewById(R.id.tesezhuanye);
        news.setOnClickListener(this);
        xuexiaogaikuang.setOnClickListener(this);
        yuanxijieshao.setOnClickListener(this);
        xiaoyuanfengcai.setOnClickListener(this);
        tesezhuanye.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.news:
                System.out.println("1");
                break;
            case R.id.xuexiaogaikuang:
                //学校概况直接跳转到查看activty
                IntentUtil.clickButtonActivity(getActivity(), DetailActivity.class, IntentUtil.Intent_Activity_Params, IntentUtil.school);
                break;
            case R.id.yuanxijieshao:
                System.out.println("1");
                break;
            case R.id.xiaoyuanfengcai:
                System.out.println("1");
                break;
            case R.id.tesezhuanye:
                System.out.println("1");
                break;
        }
    }
}
