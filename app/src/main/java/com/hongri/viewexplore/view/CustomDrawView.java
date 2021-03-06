package com.hongri.viewexplore.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.hongri.viewexplore.R;

/**
 * @author zhongyao
 * @date 2017/12/14
 *
 * View的工作流程主要是：
 * 1、onMeasure() 测量：确定测量的宽高
 * 2、onLayout() 布局：确定最终宽高及四个顶点的位置
 * 3、onDraw() 绘制：将View绘制到屏幕上
 *
 *
 * attention:
 *
 * 1、继承自View或ViewGroup的控件，padding是默认无法生效的
 * 解决方案：需要自己在代码中处理
 * 2、直接继承自View的控件，如果不对View做特殊处理，那么使用wrap_content与match_parent的效果是一样的
 * 解决方案：将宽、高设置一个默认的值
 */

public class CustomDrawView extends View {
    private Paint mPaint;
    private int mXPoint, mYPoint;
    private int mRadius;
    private int mViewWidth, mViewHeight;
    private static final String TAG = CustomDrawView.class.getSimpleName() + " ";
    private int mColor;

    /**
     * 自定义宽高
     */

    private int mWidth = 400;
    private int mHeight = 400;

    public CustomDrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.DrawCircleView);
        mColor = typedArray.getColor(R.styleable.DrawCircleView_circle_color,Color.RED);
        typedArray.recycle();

        init();
    }

    private void init() {
        mPaint = new Paint();
        //mPaint.setColor(Color.RED);
        mPaint.setColor(mColor);
    }

    /**
     * 直接继承View的自定义控件需要重写onMeasure中的方法并设置wrap_content的自身的大小，否则在布局的时候
     * 使用wrap_content就相当于使用match_parent.
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);

        if (widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(mWidth, mHeight);
        } else if (widthSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(mWidth, heightSpecSize);
        } else if (widthSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthSpecSize, mHeight);
        }

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mXPoint = getWidth() / 2;
        mYPoint = getHeight() / 2;

        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();

        mViewWidth = getWidth() - paddingLeft - paddingRight;
        mViewHeight = getHeight() - paddingTop - paddingBottom;

        Logger.d("getWidth:" + getWidth() + " getHeight:" + getHeight());
        Logger.d("mViewWidth:" + mViewWidth + " mViewHeight:" + mViewHeight);

        //        mRadius = Math.min(mXPoint,mYPoint);
        //        Logger.d("mXPoint:"+mXPoint + " mYPoint:" + mYPoint);
        //        canvas.drawCircle(mXPoint,mYPoint,100,mPaint);
        mRadius = Math.min(mViewWidth, mViewHeight) / 2;

        canvas.drawCircle(paddingLeft + mViewWidth / 2, paddingTop + mViewHeight / 2, mRadius, mPaint);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        Logger.d(TAG + "onAttachedToWindow:");
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();

        Logger.d(TAG + "onDetachedFromWindow:");
    }

}
