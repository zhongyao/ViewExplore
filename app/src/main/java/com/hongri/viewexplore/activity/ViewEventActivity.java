package com.hongri.viewexplore.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.hongri.viewexplore.R;
import com.hongri.viewexplore.view.CustomLayoutOne;
import com.hongri.viewexplore.view.CustomTextView;
import com.hongri.viewexplore.view.CustomViewGroup;
import com.hongri.viewexplore.view.DrawEventView;
import com.hongri.viewexplore.view.EventView;
import com.hongri.viewexplore.view.Logger;

/**
 * @author hongri
 * 回顾View的事件体系
 */
public class ViewEventActivity extends AppCompatActivity implements View.OnClickListener,OnGestureListener,OnDoubleTapListener,OnTouchListener {

    private EventView eventView;
    private DrawEventView drawEventView;
    //private ScrollerLayout scrollerLayout;
    private View gestureView;
    private GestureDetector gestureDetector;
    private CustomViewGroup viewGroup;
    private CustomLayoutOne layoutOne;
    private CustomTextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_event);

        eventView = (EventView)findViewById(R.id.eventView);
        drawEventView = (DrawEventView)findViewById(R.id.drawEventView);
        //scrollerLayout = (ScrollerLayout) findViewById(R.id.scrollerLayout);
        gestureView = findViewById(R.id.gestureView);
        viewGroup = (CustomViewGroup)findViewById(R.id.viewGroup);
        layoutOne = (CustomLayoutOne)findViewById(R.id.layoutOne);
        tv = (CustomTextView)findViewById(R.id.tv);
        //eventView.setOnClickListener(this);

        /**
         * 如果该View的onTouch返回false，则会调用该View的OnTouchEvent方法。
         * 否则不调用。
         * 可以得知OnTouchListener的优先级比OnTouchEvent的要高
         */
        //eventView.setOnTouchListener(new OnTouchListener() {
        //    @Override
        //    public boolean onTouch(View v, MotionEvent event) {
        //        return true;
        //    }
        //});

        //可以用SimpleOnGestureListener自定义重写所需要的方法
        gestureDetector = new GestureDetector(this,this);
        gestureDetector.setIsLongpressEnabled(true);
        gestureDetector.setOnDoubleTapListener(this);
        //eventView.setOnTouchListener(this);
        gestureView.setOnTouchListener(this);
        gestureView.setFocusable(true);
        gestureView.setClickable(true);
        gestureView.setLongClickable(true);

    }

    @Override
    public void onClick(View v) {

    }

    /**
     * 用户按下屏幕就会触发
     * 由一个MotionEvent ACTION_DOWN触发
     * @param e
     * @return
     */
    @Override
    public boolean onDown(MotionEvent e) {
        Logger.d("onDown");
        return false;
    }

    /**
     * 手指按下屏幕，尚未松开或拖动
     * @param e
     */
    @Override
    public void onShowPress(MotionEvent e) {
        Logger.d("onShowPress");
    }

    /**
     * 一次单独的点击动作（不包含滑动等操作）
     * 由一个MotionEvent ACTION_UP触发
     * @param e
     * @return
     */
    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Logger.d("onSingleTapUp");
        return true;
    }

    /**
     * 拖动事件
     * 由1个MotionEvent ACTION_DOWN, 多个ACTION_MOVE触发
     * @param e1
     * @param e2
     * @param distanceX
     * @param distanceY
     * @return
     */
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Logger.d("onScroll");
        return true;
    }

    /**
     * 用户长按触摸屏，由多个MotionEvent ACTION_DOWN触发
     * @param e
     */
    @Override
    public void onLongPress(MotionEvent e) {
        Logger.d("onLongPress:"+e);
    }

    /**
     * 滑屏:
     * 用户按下触摸屏、快速移动后松开，由1个MotionEvent ACTION_DOWN, 多个ACTION_MOVE, 1个ACTION_UP触发
     * @param e1 第一个 ACTION_DOWN MotionEvent
     * @param e2 最后一个ACTION_MOVE MotionEvent
     * @param velocityX x轴上的移动速度
     * @param velocityY y轴上的移动速度
     * @return
     */
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Logger.d("onFling");
        return true;
    }

    //@Override
    //public boolean onTouch(View v, MotionEvent event) {
    //    boolean consume = gestureDetector.onTouchEvent(event);
    //    return consume;
    //}

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    /**
     * 一次严格的单击行为：
     * 如果触发了onSingleTapConfirmed那么只能是一次单击行为。
     * @param e
     * @return
     */
    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        Logger.d("onSingleTapConfirmed");
        return true;
    }

    /**
     * 双击事件
     * @param e
     * @return
     */
    @Override
    public boolean onDoubleTap(MotionEvent e) {
        Logger.d("onDoubleTap");
        return true;
    }

    /**
     * 双击间隔中发生的动作:
     * 指触发onDoubleTap以后，在双击之间发生的其它动作，包含down、up和move事件
     * @param e
     * @return
     */
    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        Logger.d("onDoubleTapEvent:"+e);
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Logger.d("onTouchEvent");
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:

                break;
            case MotionEvent.ACTION_MOVE:

                break;
            case MotionEvent.ACTION_UP:

                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }
}
