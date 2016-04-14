package com.yt.android.activity.detail;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.iflytek.cloud.*;
import com.iflytek.sunflower.FlowerCollector;
import com.yt.android.R;
import com.yt.android.activity.tts.setting.TtsSettings;
import com.yt.android.base.BaseActivity;
import com.yt.android.entity.Attachment;
import com.yt.android.help.DataBaseHelper;
import com.yt.android.util.IntentUtil;

import javax.xml.soap.Text;
import java.beans.Visibility;

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

    private Button returnButton, play, pause, goon;
    private TextView desc;          //内容
    private ImageView image;        //图片
    private TextView biaoti;        //顶部标题


    private static String TAG = DetailActivity.class.getSimpleName();
    // 语音合成对象
    private SpeechSynthesizer mTts;

    // 默认发音人
    private String voicer = "xiaoyan";
    // 缓冲进度
    private int mPercentForBuffering = 0;
    // 播放进度
    private int mPercentForPlaying = 0;

    // 云端/本地单选按钮
    private RadioGroup mRadioGroup;
    // 引擎类型
    private String mEngineType = SpeechConstant.TYPE_CLOUD;

    private Toast mToast;
    private SharedPreferences mSharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();
    }

    public void initView() {
        initTts();
        returnButton = (Button) findViewById(R.id.returnbutton);
        image = (ImageView) findViewById(R.id.image);
        desc = (TextView) findViewById(R.id.desc);
        biaoti = (TextView) findViewById(R.id.biaoti);
        returnButton.setOnClickListener(this);
        initIntent();
    }


    /**
     * 初始化语音播放的信息
     */
    public void initTts() {
        play = (Button) findViewById(R.id.play);
        pause = (Button) findViewById(R.id.pause);
        goon = (Button) findViewById(R.id.goon);
        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        goon.setOnClickListener(this);
        // 初始化合成对象
        mTts = SpeechSynthesizer.createSynthesizer(DetailActivity.this, mTtsInitListener);
        // 云端发音人名称列表

        mSharedPreferences = getSharedPreferences(TtsSettings.PREFER_NAME, MODE_PRIVATE);
        mToast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
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
            case R.id.play:
                // 移动数据分析，收集开始合成事件
                FlowerCollector.onEvent(DetailActivity.this, "tts_play");

                String text = desc.getText().toString();
                // 设置参数
                setParam();
                int code = mTts.startSpeaking(text, mTtsListener);
                if (code != ErrorCode.SUCCESS) {
                    if (code == ErrorCode.ERROR_COMPONENT_NOT_INSTALLED) {
                        //未安装则跳转到提示安装页面
                        //mInstaller.install();
                    } else {
                        showTip("语音合成失败,错误码: " + code);
                    }
                }
                pause.setVisibility(View.VISIBLE);
                play.setVisibility(View.GONE);
                break;
            case R.id.pause:
                goon.setVisibility(View.VISIBLE);
                pause.setVisibility(View.GONE);
                mTts.pauseSpeaking();
                break;
            case R.id.goon:
                mTts.resumeSpeaking();
                break;
        }
    }


    /**
     * 初始化监听。
     */
    private InitListener mTtsInitListener = new InitListener() {
        @Override
        public void onInit(int code) {
            Log.d(TAG, "InitListener init() code = " + code);
            if (code != ErrorCode.SUCCESS) {
                showTip("初始化失败,错误码：" + code);
            } else {
                // 初始化成功，之后可以调用startSpeaking方法
                // 注：有的开发者在onCreate方法中创建完合成对象之后马上就调用startSpeaking进行合成，
                // 正确的做法是将onCreate中的startSpeaking调用移至这里
            }
        }
    };


    /**
     * 合成回调监听。
     */
    private SynthesizerListener mTtsListener = new SynthesizerListener() {

        @Override
        public void onSpeakBegin() {
            showTip("开始播放");
        }

        @Override
        public void onSpeakPaused() {
            showTip("暂停播放");
        }

        @Override
        public void onSpeakResumed() {
            showTip("继续播放");
        }

        @Override
        public void onBufferProgress(int percent, int beginPos, int endPos,
                                     String info) {
            // 合成进度
            mPercentForBuffering = percent;
            showTip(String.format(getString(R.string.tts_toast_format),
                    mPercentForBuffering, mPercentForPlaying));
        }

        @Override
        public void onSpeakProgress(int percent, int beginPos, int endPos) {
            // 播放进度
            mPercentForPlaying = percent;
            showTip(String.format(getString(R.string.tts_toast_format),
                    mPercentForBuffering, mPercentForPlaying));
        }

        @Override
        public void onCompleted(SpeechError error) {
            if (error == null) {
                showTip("播放完成");
            } else if (error != null) {
                showTip(error.getPlainDescription(true));
            }
        }

        @Override
        public void onEvent(int eventType, int arg1, int arg2, Bundle obj) {
        }
    };


    private void showTip(final String str) {
        mToast.setText(str);
        mToast.show();
    }


    /**
     * 参数设置
     *
     * @param
     * @return
     */
    private void setParam() {
        // 清空参数
        mTts.setParameter(SpeechConstant.PARAMS, null);
        // 根据合成引擎设置相应参数
        if (mEngineType.equals(SpeechConstant.TYPE_CLOUD)) {
            mTts.setParameter(SpeechConstant.ENGINE_TYPE, SpeechConstant.TYPE_CLOUD);
            // 设置在线合成发音人
            mTts.setParameter(SpeechConstant.VOICE_NAME, voicer);
            //设置合成语速
            mTts.setParameter(SpeechConstant.SPEED, mSharedPreferences.getString("speed_preference", "50"));
            //设置合成音调
            mTts.setParameter(SpeechConstant.PITCH, mSharedPreferences.getString("pitch_preference", "50"));
            //设置合成音量
            mTts.setParameter(SpeechConstant.VOLUME, mSharedPreferences.getString("volume_preference", "50"));
        } else {
            mTts.setParameter(SpeechConstant.ENGINE_TYPE, SpeechConstant.TYPE_LOCAL);
            // 设置本地合成发音人 voicer为空，默认通过语记界面指定发音人。
            mTts.setParameter(SpeechConstant.VOICE_NAME, "");
            /**
             * 开发者如需自定义参数，请参考在线合成参数设置
             */
        }
        //设置播放器音频流类型
        mTts.setParameter(SpeechConstant.STREAM_TYPE, mSharedPreferences.getString("stream_preference", "3"));
        // 设置播放合成音频打断音乐播放，默认为true
        mTts.setParameter(SpeechConstant.KEY_REQUEST_FOCUS, "true");

        // 设置音频保存路径，保存音频格式支持pcm、wav，设置路径为sd卡请注意WRITE_EXTERNAL_STORAGE权限
        // 注：AUDIO_FORMAT参数语记需要更新版本才能生效
        mTts.setParameter(SpeechConstant.AUDIO_FORMAT, "wav");
        mTts.setParameter(SpeechConstant.TTS_AUDIO_PATH, Environment.getExternalStorageDirectory() + "/msc/tts.wav");
    }


}
