package com.home.labellinkdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.home.labellinkdemo.R;
import com.home.labellinkdemo.ToastUtils;
import com.home.labellinkdemo.adapter.LinkLabelAdapter;
import com.home.labellinkdemo.bean.LinkLabelBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LabelLinkRecyclerActivity extends AppCompatActivity {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.email_sign_in_button)
    Button btn;

    private List<LinkLabelBean> list = new ArrayList<>();
    private List<String> list1 = new ArrayList<>();
    private List<String> list2 = new ArrayList<>();
    private List<String> list3 = new ArrayList<>();
    private Gson gson = new Gson();

    private String[] str = new String[]{"标题1", "帅哥", "校园", "军事", "悬疑", "科幻", "露露", "奇幻", "韦恩", "标题2",
            "古言", "抢女", "总裁", "网红", "穿越", "美女", "灵异", "色魔", "标题3",
            "恐怖", "红魔", "言情", "科幻", "诺克萨斯", "人妖", "荒岛", "其他"};
    private Map<String, List<String>> hashMap = new HashMap<>();
    private LinkLabelBean linkLabelBean;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_label_link_recycler);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    private void initData() {
        for (int i = 0; i < str.length; i++) {
            linkLabelBean = new LinkLabelBean();
            linkLabelBean.setStr(str[i]);
            list.add(linkLabelBean);
        }
    }


    private void initView() {
        final GridLayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 4);
        mLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int type = recyclerView.getAdapter().getItemViewType(position);//获得返回值
                if (type == 99) {
                    return mLayoutManager.getSpanCount();
                } else {
                    return 1;
                }
            }
        });
        recyclerView.setLayoutManager(mLayoutManager);
        LinkLabelAdapter linkLabelAdapter = new LinkLabelAdapter(getApplicationContext(), list);
        recyclerView.setAdapter(linkLabelAdapter);
    }

    @OnClick({R.id.email_sign_in_button})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.email_sign_in_button:
                //这边其实可以优化 但是时间不够就不再做优化。
                boolean zhishao = false;
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).isSelect()) {
                        zhishao = true;
                    }
                }
                if (!zhishao) {
                    ToastUtils.showSingleToast("至少选择一个标签。");
                    return;
                }
                hashMap.clear();
                list1.clear();
                list2.clear();
                list3.clear();
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).isSelect()) {
                        if (i > 0 && i <= 8) {
                            list1.add(list.get(i).getStr());
                        } else if (i > 8 && i <= 17) {
                            list2.add(list.get(i).getStr());
                        } else {
                            list3.add(list.get(i).getStr());
                        }
                    }
                }
                if (list1.size() > 0) {
                    hashMap.put("1", list1);
                }
                if (list2.size() > 0) {
                    hashMap.put("2", list2);
                }
                if (list3.size() > 0) {
                    hashMap.put("3", list3);
                }
                String s = gson.toJson(hashMap);
                ToastUtils.showSingleToast("选中数据--" + s);
                break;
        }
    }
}
