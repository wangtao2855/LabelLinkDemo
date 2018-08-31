package com.baidu.tts.sample;

import com.baidu.tts.client.SpeechSynthesizerListener;
import com.baidu.tts.sample.control.InitConfig;
import com.baidu.tts.sample.control.MySyntherizer;
import com.baidu.tts.sample.listener.FileSaveListener;
import com.baidu.tts.sample.util.FileUtil;

import java.util.Map;

/**
 * 点击合成按钮，保存录音文件
 * <p>
 * Created by fujiayi on 2017/9/15.
 */

public class SaveFileActivity extends SynthActivity {
    {
        DESC = "本示例展示如何保存合成文件。 点击第一行的前三个按钮都会触发保存文件。\n"
                + "您也可以自行对用于保存文件的音频流实时实时处理。\n"
                + "其它功能请参见“语音合成”Activity。 \n";
    }

    /**
     * 与SynthActivity相比，修改listener为FileSaveListener 可实现保存录音功能。
     * 获取的音频内容同speak方法播出的声音
     * FileSaveListener 在UiMessageListener的基础上，使用 onSynthesizeDataArrived回调，获取音频流
     */
    protected void initialTts() {
        String tmpDir = FileUtil.createTmpDir(this);
        // 设置初始化参数
        // 此处可以改为 含有您业务逻辑的SpeechSynthesizerListener的实现类
        SpeechSynthesizerListener listener = new FileSaveListener(mainHandler, tmpDir);
        Map<String, String> params = getParams();

        // appId appKey secretKey 网站上您申请的应用获取。注意使用离线合成功能的话，需要应用中填写您app的包名。包名在build.gradle中获取。
        InitConfig initConfig = new InitConfig(appId, appKey, secretKey, ttsMode,  params, listener);
        synthesizer = new MySyntherizer(this, initConfig, mainHandler); // 此处可以改为MySyntherizer 了解调用过程
    }
}
