package com.home.labellinkdemo.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.home.labellinkdemo.R;
import com.home.labellinkdemo.ToastUtils;
import com.home.labellinkdemo.bean.LinkLabelBean;

import java.util.List;

/**
 * Created by wangtao on 2018/4/18.
 */

public class LinkLabelAdapter extends RecyclerView.Adapter {

    private Context context;
    private final int TITLE = 99;
    private final int CONTENT = 100;
    private int Zeng = 0;
    private List<LinkLabelBean> list;

    public LinkLabelAdapter(Context context, List<LinkLabelBean> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        if (viewType == TITLE) {
            holder = new TitleHolder(LayoutInflater.from(context).inflate(R.layout.adapter_activity_label_title, null));
        } else {
            holder = new LabelHolder(LayoutInflater.from(context).inflate(R.layout.adapter_activity_label_content, null));
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TITLE) {
            ((TitleHolder) holder).setData(position);
        } else {
            ((LabelHolder) holder).setData(position);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).getStr().contains("标题")) {
            return TITLE;
        } else {
            return CONTENT;
        }
    }

    class TitleHolder extends RecyclerView.ViewHolder {

        private final TextView adapterTitle;
        private final ImageView adapterTitleIv;

        public TitleHolder(View inflate) {
            super(inflate);
            adapterTitle = (TextView) inflate.findViewById(R.id.adater_title);
            adapterTitleIv = (ImageView) inflate.findViewById(R.id.adapter_iv);
        }

        @SuppressLint("WrongConstant")
        public void setData(int position) {
            switch (list.get(position).getStr()) {
                case "标题1":
                    adapterTitleIv.setImageResource(R.drawable.circle);
                    adapterTitle.setText("以下推荐男生选择");
                    break;
                case "标题2":
                    adapterTitleIv.setImageResource(R.drawable.circle_fen);
                    adapterTitle.setText("以下推荐女生选择");
                    break;
                case "标题3":
                    adapterTitleIv.setImageResource(R.drawable.circle_bule);
                    adapterTitle.setText("以下推荐二次元选择");
                    break;
                default:
                    adapterTitleIv.setVisibility(View.GONE);
                    adapterTitle.setVisibility(View.GONE);
                    break;
            }
        }
    }

    private class LabelHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private final LinearLayout llContent;

        public LabelHolder(View inflate) {
            super(inflate);
            textView = (TextView) inflate.findViewById(R.id.textViewContent);
            llContent = (LinearLayout) inflate.findViewById(R.id.llContent);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.leftMargin = 50;
            llContent.setLayoutParams(layoutParams);
        }

        public void setData(final int position) {
            textView.setText(list.get(position).getStr());
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (list.get(position).isSelect()) {
                        Zeng--;
                    }
                    if (Zeng < 4) {
                        if (textView.isSelected()) {
                            textView.setSelected(false);
                            list.get(position).setSelect(false);
                        } else {
                            ++Zeng;
                            textView.setSelected(true);
                            list.get(position).setSelect(true);
                        }
                    } else {
                        ToastUtils.showSingleToast("最多只能选择4个标签");
                    }
                }
            });
        }
    }
}
