package com.hongri.viewexplore.view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;

/**
 * @author zhongyao
 * @date 2017/12/5
 */

public class EventView extends View {

    private int left;
    private int right;
    private int top;
    private int bottom;
    private int width;
    private int height;

    private float x;
    private float y;

    private float translationX;
    private float translationY;

    private float rawX;
    private float rawY;

    private float xVelocity;
    private float yVelocity;

    private VelocityTracker velocityTracker;
    private Context context;

    public EventView(Context context) {
        super(context);
        this.context = context;
        Logger.d("构造方法1");
    }

    public EventView(Context context,
                     @Nullable AttributeSet attrs) {
        super(context, attrs);
        Logger.d("构造方法2");
        Logger.d("context:" + context + " attrs:" + attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Logger.d("onMeasure");
        Logger.d("widthMeasureSpec:" + widthMeasureSpec + " heightMeasureSpec:" + heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Logger.d("onLayout");
        Logger.d("changed:" + changed + " left:" + left + " top:" + top + " right:" + right + " bottom:" + bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Logger.d("onDraw");

        /**
         * （View平移过程中left、top表示原始左上角的位置信息，其值并不会发生改变）
         * left：左上角横坐标
         * top：左上角纵坐标
         * right：右下角横坐标
         * bottom：右下角纵坐标
         */
        left = getLeft();
        top = getTop();
        right = getRight();
        bottom = getBottom();

        width = right - left;
        height = bottom - top;

        Logger.d("left:" + left + " top:" + top + " right:" + right + " bottom:" + bottom);
        Logger.d("width:" + width + " height:" + height);

        /**
         * (x,y)表示View左上角的坐标
         */
        x = getX();
        y = getY();

        Logger.d("x:" + x + " y:" + y);

        /**
         *translationX与translationY表示View左上角相对于父容器的偏移量(默认为0)
         */
        translationX = getTranslationX();
        translationY = getTranslationY();

        Logger.d("translationX:" + translationX + " translationY:" + translationY);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Logger.d("ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Logger.d("ACTION_MOVE");

                /**
                 * 相对于View左上角的x和y的坐标
                 */
                x = event.getX();
                y = event.getY();

                /**
                 * 相对于屏幕左上角的x和y的坐标
                 */
                rawX = event.getRawX();
                rawY = event.getRawY();
                //Logger.d("x:" + x + " y:" + y + " awX:" + rawX + " rawY:" + rawY);

                /**
                 * 速度追踪:从左向右速度为正值，从右向左速度为负值。
                 */
                velocityTracker = VelocityTracker.obtain();
                velocityTracker.addMovement(event);
                velocityTracker.computeCurrentVelocity(2000);
                xVelocity = velocityTracker.getXVelocity();
                yVelocity = velocityTracker.getYVelocity();

                Logger.d("xVelocity:" + xVelocity + "yVelocity:" + yVelocity);

                break;
            case MotionEvent.ACTION_UP:
                Logger.d("ACTION_UP");

                velocityTracker.clear();
                velocityTracker.recycle();
                break;
            default:
                break;
        }
        return true;
    }
}
