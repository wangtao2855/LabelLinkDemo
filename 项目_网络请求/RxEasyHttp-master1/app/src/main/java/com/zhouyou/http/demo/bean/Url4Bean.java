/*
 * Copyright (C) 2018 zhouyou(478319399@qq.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.zhouyou.http.demo.bean;

import java.util.List;

/**
 * Created by wangtao on 2018/8/13.
 */

public class Url1Bean {


    /**
     * code : 200
     * msg : ok
     * data : [{"link":"https://www.didiyd.com/topic/15/app/activity/rewardDial","title":"顶部banner（旧） 1","coverimg":"https://imgs.didiyd.com/zt/4073c60b73c7f0ef3881ca09bed984c5.jpeg","articleid":"0"},{"link":"https://www.didiyd.com/topic/11/app/activity/rewardDial","title":"顶部banner（旧） 2","coverimg":"https://imgs.didiyd.com/zt/821f4ec49fa9b2c92da46a91080aaffa.jpeg","articleid":"0"},{"link":"https://www.didiyd.com/topic/16/app/activity/rewardDial","title":"顶部banner（旧） 3","coverimg":"https://imgs.didiyd.com/zt/3476add190dd8e2299d806f21351e1a4.jpeg","articleid":"0"}]
     */

    private int code;
    private String msg;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * link : https://www.didiyd.com/topic/15/app/activity/rewardDial
         * title : 顶部banner（旧） 1
         * coverimg : https://imgs.didiyd.com/zt/4073c60b73c7f0ef3881ca09bed984c5.jpeg
         * articleid : 0
         */

        private String link;
        private String title;
        private String coverimg;
        private String articleid;

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCoverimg() {
            return coverimg;
        }

        public void setCoverimg(String coverimg) {
            this.coverimg = coverimg;
        }

        public String getArticleid() {
            return articleid;
        }

        public void setArticleid(String articleid) {
            this.articleid = articleid;
        }
    }
}
