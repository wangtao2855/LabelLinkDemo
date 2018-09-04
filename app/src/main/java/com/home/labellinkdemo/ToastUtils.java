/**
 * Copyright 2016 JustWayward Team
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.home.labellinkdemo;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * Toast工具类，解决多个Toast同时出现的问题
 *
 * @author yuyh.
 * @date 16/4/9.
 */
public class ToastUtils {

    private static Toast mToast;
    private static Context context = MyApplication.sInstance;

    public static void showSingleToast(String text) {
        if (!TextUtils.isEmpty(text)) {
            getSingleToast(text, Toast.LENGTH_SHORT).show();
        }
    }

    public static Toast getSingleToast(String text, int duration) {
        if (mToast == null && !TextUtils.isEmpty(text)) {
            mToast = Toast.makeText(context, text, duration);
        } else {
            if (!TextUtils.isEmpty(text)) {
                mToast.setText(text);
            }
        }
        return mToast;
    }
}
