package com.hongri.viewexplore.view;

import android.text.TextUtils;
import android.util.Log;
import com.hongri.viewexplore.utils.ConstantEnum;

/**
 *
 * @author zhongyao
 * @date 2017/12/5
 */

public class Logger {

    public static void d(String msg){
        if(!TextUtils.isEmpty(msg)){
            Log.d(ConstantEnum.YAO,msg);
        }
    }
    public static void i(String msg){
        if (!TextUtils.isEmpty(msg)){
            Log.i(ConstantEnum.YAO,msg);
        }
    }
}
