package com.hongri.viewexplore.view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * @author zhongyao
 * @date 2017/12/7
 */

public class CustomTextView extends android.support.v7.widget.AppCompatTextView{
    private static final String TAG = CustomTextView.class.getSimpleName() + ":";

    public CustomTextView(Context context,
                          @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //子元素中干预父控件的事件分发过程（但ACTION_DOWN事件除外）。
                getParent().requestDisallowInterceptTouchEvent(true);
                Logger.d(TAG + "ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Logger.d(TAG + "ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Logger.d(TAG + "ACTION_UP");
                break;
            default:
                break;
        }
        return true;
    }
}
