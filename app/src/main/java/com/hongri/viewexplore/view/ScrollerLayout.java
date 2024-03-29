package com.hongri.viewexplore.view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v4.view.ViewConfigurationCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;

/**
 * @author zhongyao
 * @date 2017/12/7
 *
 * 在继承自 ViewGroup 的子类中重写除 dispatchDraw() 以外的绘制方法时，可能需要调用 setWillNotDraw(false)；
 */

public class ScrollerLayout extends ViewGroup {
    private int leftBorder;
    private int rightBorder;
    private int mTouchSlop;
    private Scroller mScroller;
    private int mXDown;
    private int mXMove, mLastMove;

    public ScrollerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        mScroller = new Scroller(context);
        //获取TouchSlop值
        mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(context));
        //当明确知道一个ViewGroup需要通过onDraw来绘制内容时，我们需要显式地关闭，即设置为false。
        setWillNotDraw(false);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Logger.d("ScrollerLayout ---> onMeasure");
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            //为ScrollerView中的每个子控件测量大小
            measureChild(childView, widthMeasureSpec, heightMeasureSpec);
        }

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        Logger.d("ScrollerLayout ---> onLayout");
        if (changed) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childView = getChildAt(i);
                childView.layout(i * childView.getMeasuredWidth(), 0, (i + 1) * childView.getMeasuredWidth(),
                    childView.getMeasuredHeight());
            }
            leftBorder = getChildAt(0).getLeft();
            rightBorder = getChildAt(childCount - 1).getRight();
        }
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        Logger.d("ScrollerLayout ---> dispatchDraw");
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Logger.d("ScrollerLayout ---> draw");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Logger.d("ScrollerLayout ---> onDraw");
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Logger.d("onInterceptTouchEvent--ACTION_DOWN");
                mXDown = (int)ev.getRawX();
                mLastMove = mXDown;
                break;
            case MotionEvent.ACTION_MOVE:
                //                    Logger.d("onInterceptTouchEvent--ACTION_MOVE");
                mXMove = (int)ev.getRawX();
                mLastMove = mXMove;
                if (Math.abs(mXMove - mXDown) > mTouchSlop) {
                    return true;
                }

                break;
            case MotionEvent.ACTION_UP:
                Logger.d("onInterceptTouchEvent--ACTION_UP");
                break;
            default:
                break;
        }

        return super.onInterceptTouchEvent(ev);
    }

    /**
     * mScrollX：表示当前View的左边缘与View的内容左边缘在水平方向的距离
     * 从左向右滑，mScrollX为负值，从右向左滑，mScrollY为正值。
     * 从上向下滑，mScrollY为负值，从下向上滑，mScrollY为正值。
     *
     * 关于getScrollX()可参考：
     * https://blog.csdn.net/bigconvience/article/details/26697645?utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7Edefault-9.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7Edefault-9.control
     * https://blog.csdn.net/znouy/article/details/51338256?utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-1.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-1.control
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Logger.d("onTouchEvent--ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                mXMove = (int)event.getRawX();
                int mScrollX = mLastMove - mXMove;
                Logger.d("mXMove:" + mXMove + " mLastMove:" + mLastMove + " getScrollX:" + getScrollX());
                if (getScrollX() + mScrollX < leftBorder) {
                    scrollTo(leftBorder, 0);
                    Logger.d("leftBorder:" + leftBorder);
                    return true;
                } else if (getScrollX() + mScrollX + getWidth() > rightBorder) {
                    scrollTo(rightBorder - getWidth(), 0);
                    Logger.d("rightBorder:" + rightBorder);
                    return true;
                }

                scrollBy(mScrollX, 0);
                mLastMove = mXMove;
                break;
            case MotionEvent.ACTION_UP:
                Logger.d("onTouchEvent--ACTION_UP");
                // 当手指抬起时，根据当前的滚动值来判定应该滚动到哪个子控件的界面
                int targetIndex = (getScrollX() + getWidth() / 2) / getWidth();
                int dx = targetIndex * getWidth() - getScrollX();
                // 第二步，调用startScroll()方法来初始化滚动数据并刷新界面
                mScroller.startScroll(getScrollX(), 0, dx, 0);
                invalidate();
                break;

            default:
                break;
        }
        return true;
    }

    @Override
    public void computeScroll() {
        //        super.computeScroll();
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            postInvalidate();
        }
    }
}
