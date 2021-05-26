package com.hongri.viewexplore.view;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Create by zhongyao on 2021/5/20
 * Description:跑马灯文字
 * Attention：该TextView中的xml文件需设置android:textIsSelectable="false" 或不设置该属性
 */
public class MarqueTextView extends AppCompatTextView {
    public MarqueTextView(Context context) {
        super(context);
    }

    public MarqueTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MarqueTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean isFocused() {
        return true;
    }
}
