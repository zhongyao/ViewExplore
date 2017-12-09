package com.hongri.viewexplore.activity;

import java.util.ArrayList;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hongri.viewexplore.R;
import com.hongri.viewexplore.adapter.RecyclerAdapter;
import com.hongri.viewexplore.view.CustomHorizontalScrollView;
import com.hongri.viewexplore.view.CustomRecyclerView;

//import com.hongri.viewexplore.R;

//import com.hongri.viewexplore.R;

/**
 * @author hongri
 */
public class SlidingConflictActivity extends AppCompatActivity {

    private static final String TAG = SlidingConflictActivity.class.getSimpleName();
    private LayoutInflater inflater;
    private CustomHorizontalScrollView containerScrollView;
    private CustomRecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding_conflict);

        initView();
    }

    private void initView() {
        inflater = getLayoutInflater();
        containerScrollView = (CustomHorizontalScrollView)findViewById(R.id.container);
        for (int i = 0; i < 3; i++) {
            ViewGroup layout = (ViewGroup)inflater.inflate(R.layout.content_layout, containerScrollView, false);
            layout.getLayoutParams().width = 1440;
            TextView tv = (TextView)layout.findViewById(R.id.tv);
            tv.setText("page" + i);
            layout.setBackgroundColor(Color.YELLOW);
            createList(layout);
            containerScrollView.addView(layout);
        }
    }

    private void createList(View layout) {
        //ListView lv = (ListView)layout.findViewById(R.id.lv);
        rv = (CustomRecyclerView)layout.findViewById(R.id.rv);
        ArrayList<String> datas = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            datas.add("android" + i);
        }
        rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        RecyclerAdapter adapter = new RecyclerAdapter(this,datas);
        rv.setAdapter(adapter);
        //ListAdapter adapter = new ListAdapter(this,datas);
        //ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item, R.id.tv, datas);
        //lv.setAdapter(adapter);
    }
}
