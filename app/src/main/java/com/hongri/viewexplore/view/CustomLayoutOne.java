package com.hongri.viewexplore.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * @author zhongyao
 * @date 2017/12/7
 */

public class CustomLayoutOne extends LinearLayout{
    private static final String TAG = CustomLayoutOne.class.getSimpleName() + ":";

    public CustomLayoutOne(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Logger.d(TAG+"dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Logger.d(TAG+"onInterceptTouchEvent");
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:

                return false;
            case MotionEvent.ACTION_MOVE:

                return true;
            case MotionEvent.ACTION_UP:

                return true;
            default:
                break;
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
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
