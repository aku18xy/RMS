package com.example.nas.rms;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ViewPager vp;
    TabLayout tabs;
    TabAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadTabs();
    }

    private void loadTabs() {
        vp = findViewById(R.id.viewpager);
        tabs = findViewById(R.id.tabs);
        adapter = new TabAdapter(getSupportFragmentManager());
        vp.setAdapter(adapter);
        tabs.setupWithViewPager(vp);

    }
}
