package com.example.sindhu.sampleproject3;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tv=findViewById(R.id.mytext_id);
        int position=getIntent().getIntExtra(getString(R.string.pos),0);
        String[] detailsarray= getResources().getStringArray(R.array.details);
        String data=detailsarray[position];
        tv.setText(data);
        SharedPreferences sp=getSharedPreferences("mypref",MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString("mydata",data);
        editor.commit();

        Intent intent=new Intent(this,WidgetClass.class);
        intent.setAction(getString(R.string.link));
        int[] widgets= AppWidgetManager.getInstance(this).getAppWidgetIds(new ComponentName(this,WidgetClass.class));
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS,widgets);
        sendBroadcast(intent);
    }
}
