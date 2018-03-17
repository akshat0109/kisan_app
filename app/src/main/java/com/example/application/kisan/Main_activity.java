package com.example.application.kisan;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by HP on 21-01-2018.
 */

public class Main_activity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }

    public void news(View view) {
        Intent intent = new Intent("android.intent.action.NEWSACTIVITY");
        startActivity(intent);
    }
    public void helpdesk (View view) {
        Intent intent = new Intent("android.intent.action.HELPDESKACTIVITY");
        startActivity(intent);
    }
}
