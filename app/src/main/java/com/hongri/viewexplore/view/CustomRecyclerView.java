package com.hongri.viewexplore.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * @author zhongyao
 * @date 2017/12/9
 */

public class CustomRecyclerView extends RecyclerView {
    private static final String TAG = CustomRecyclerView.class.getSimpleName() + ":";
    private int deltaX, deltaY;
    private int mLastX, mLastY;

    public CustomRecyclerView(Context context,
                              @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent e) {
        int x = (int)e.getX();
        int y = (int)e.getY();
        Logger.d("x:" + x + "y:" + y);
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Logger.d(TAG + "ACTION_DOWN");
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                Logger.d(TAG + "ACTION_MOVE");
                deltaX = x - mLastX;
                deltaY = y - mLastY;
                Logger.d(TAG + "deltax:" + deltaX + "deltaY:" + deltaY);
                if (Math.abs(deltaX) > Math.abs(deltaY)) {
                    Logger.d(TAG + "requestDisallowInterceptTouchEvent(false)" + getParent());
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                break;
            case MotionEvent.ACTION_UP:

                break;
            default:
                break;
        }

        mLastX = x;
        mLastY = y;
        return super.dispatchTouchEvent(e);
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        //int x = (int)e.getX();
        //int y = (int)e.getY();
        //Logger.d("x:" + x + "y:" + y);
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:

                break;
            default:
                break;

        }
        return super.onTouchEvent(e);
    }
}
