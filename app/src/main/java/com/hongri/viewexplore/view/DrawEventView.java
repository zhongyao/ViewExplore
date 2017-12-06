package com.hongri.viewexplore.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * @author zhongyao
 * @date 2017/12/6
 */

public class DrawEventView extends View {
    private Paint linePaint;
    private Paint circlePaint;
    private float x,y;
    private float scrollX,scrollY;
    private float mLastX,mLastY;

    public DrawEventView(Context context) {
        super(context);
    }

    public DrawEventView(Context context,
                         @Nullable AttributeSet attrs) {
        super(context, attrs);

        linePaint = new Paint();
        linePaint.setColor(Color.RED);
        linePaint.setStrokeWidth(6);

        circlePaint = new Paint();
        circlePaint.setColor(Color.BLUE);
        circlePaint.setStrokeWidth(10);
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
        canvas.drawLine(0, 200, 1440, 200, linePaint);
        canvas.drawCircle(200, 200, 15, circlePaint);
        canvas.drawCircle(400, 200, 15, circlePaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                x = event.getX();
                y = event.getY();
                mLastX = x;
                mLastY = y;

                break;
            case MotionEvent.ACTION_MOVE:

                /**
                 * 相对于View左上角的x和y的坐标
                 */
                x = event.getX();
                y = event.getY();

                scrollX = getScaleX();
                scrollY = getScaleY();

                Logger.d("scrollX:"+scrollX+"scrollY:"+scrollY);
                float deltaX = x - mLastX;
                Logger.d("deltaX:"+deltaX);
                //float deltaY = y - mLastY;
                //表示"移动了..."
                scrollBy((int)(-deltaX),0);
                break;
            case MotionEvent.ACTION_UP:
                //表示"移动到..."
                //scrollTo((int)x,(int)20);
                break;
            default:

                break;
        }

        mLastX = x;
        mLastY = y;
        return true;
    }


}
