package com.home.labellinkdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.home.labellinkdemo.R;
import com.home.labellinkdemo.ScreenUtils;
import com.home.labellinkdemo.ToastUtils;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LabelLinkFlowLayoutActivity extends AppCompatActivity {

    @BindView(R.id.tabLayout_man)
    TagFlowLayout tabLayoutMan;

    private Object[] strAll = new Object[]{"开始", "男人", "穿越", "军事", "悬疑", "还有谁", "仙侠", "奇幻", "竞技",
            "开始1", "神雕侠侣", "现言", "LOL", "婚恋", "穿越", "红尘", "灵异", "女人", "开始2",
            "恐怖", "蜜语", "言情", "吃鸡", "校园", "妹子", "荒岛", "其他"};

    private HashMap<String, List<String>> stringHashMap = new HashMap<>();
    private List<String> list = new ArrayList<>();
    private Gson gson = new Gson();
    private List<String> list1 = new ArrayList<>();
    private List<String> list2 = new ArrayList<>();
    private List<String> list3 = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_label_link_flow_layout);
        ButterKnife.bind(this);

        tabLayoutMan.setAdapter(new TagAdapter<Object>(strAll) {
            @Override
            public View getView(FlowLayout flowLayout, int i, Object s) {
                if (String.valueOf(s).contains("开始")) {
                    View inflat = LayoutInflater.from(getApplicationContext()).inflate(R.layout.adapter_activity_label_title, null);
                    ImageView adapterIv = (ImageView) inflat.findViewById(R.id.adapter_iv);
                    TextView adapterTitle = (TextView) inflat.findViewById(R.id.adater_title);
                    if (String.valueOf(s).equals("开始")) {
                        adapterIv.setImageResource(R.drawable.circle);
                        adapterTitle.setText("以下推荐男生选择");
                    } else if (String.valueOf(s).equals("开始1")) {
                        adapterIv.setImageResource(R.drawable.circle_fen);
                        adapterTitle.setText("以下推荐女生选择");
                    } else if (String.valueOf(s).equals("开始2")) {
                        adapterIv.setImageResource(R.drawable.circle_bule);
                        adapterTitle.setText("以下推荐二次元选择");
                    }
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                    layoutParams.width = ScreenUtils.getScreenWidth();
                    inflat.setLayoutParams(layoutParams);
                    return inflat;
                } else {
                    TextView tv = (TextView) LayoutInflater.from(getApplicationContext()).inflate(R.layout.dialog_view_textview,
                            tabLayoutMan, false);
                    tv.setText(String.valueOf(s));
                    return tv;
                }
            }
        });

        tabLayoutMan.setOnSelectListener(new TagFlowLayout.OnSelectListener() {
            @Override
            public void onSelected(Set<Integer> set) {
                stringHashMap.clear();
                list.clear();
                list1.clear();
                list2.clear();
                list3.clear();
                for (Integer entry : set) {
                    if (!String.valueOf(strAll[entry]).contains("开始")) {
                        list.add(String.valueOf(strAll[entry]));
                    }
                    if (entry > 0 && entry < 9) {
                        if (!String.valueOf(strAll[entry]).contains("开始")) {
                            list1.add(String.valueOf(strAll[entry]));
                        }
                    } else if (entry > 9 && entry < 18) {
                        if (!String.valueOf(strAll[entry]).contains("开始")) {
                            list2.add(String.valueOf(strAll[entry]));
                        }
                    } else {
                        if (!String.valueOf(strAll[entry]).contains("开始")) {
                            list3.add(String.valueOf(strAll[entry]));
                        }
                    }
                }
                if (list1.size() > 0) {
                    stringHashMap.put("1", list1);
                }
                if (list2.size() > 0) {
                    stringHashMap.put("2", list2);
                }
                if (list3.size() > 0) {
                    stringHashMap.put("3", list3);
                }
                String json = gson.toJson(stringHashMap);
                ToastUtils.showSingleToast("数据： " + json);
            }
        });
    }
}
