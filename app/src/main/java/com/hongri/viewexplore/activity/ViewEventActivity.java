package com.hongri.viewexplore.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.hongri.viewexplore.R;
import com.hongri.viewexplore.view.EventView;

/**
 * @author hongri
 * 回顾View的事件体系
 */
public class ViewEventActivity extends AppCompatActivity implements View.OnClickListener{

    private EventView eventView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_event);

        eventView = (EventView)findViewById(R.id.eventView);
        //eventView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
