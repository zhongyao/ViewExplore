package com.hongri.viewexplore.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.hongri.viewexplore.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnEvent;
    private Button btnTheory;

    private String uriEvent = "hongri://view/viewevent";
    private String eventAction = "android.intent.action.VIEWEVENTACTIVITY";
    private String uriTheory = "hongri://view/viewtheory";
    private String theoryAction = "android.intent.action.VIEWTHEORYACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEvent = (Button)findViewById(R.id.btnEvent);
        btnTheory = (Button)findViewById(R.id.btnTheory);

        btnEvent.setOnClickListener(this);
        btnTheory.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnEvent:

                Intent intentEvent = new Intent();
                intentEvent.setAction(eventAction);
                intentEvent.setData(Uri.parse(uriEvent));
                startActivity(intentEvent);
                break;

            case R.id.btnTheory:
                Intent intentTheory = new Intent();
                intentTheory.setAction(theoryAction);
                intentTheory.setData(Uri.parse(uriTheory));
                startActivity(intentTheory);

                break;

            default:
                break;
        }
    }
}
