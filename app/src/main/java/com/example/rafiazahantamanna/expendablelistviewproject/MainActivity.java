package com.example.rafiazahantamanna.expendablelistviewproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ExpandableListView expandableListView;

    private List<String> title = new ArrayList<>();
    private Map<String, List<String>> child = new HashMap<>();
    int lastPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        preparedData();
        initFunctonality();
    }

    private void initFunctonality() {
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int i) {

                if (lastPosition != -1 && lastPosition != i) {

                    expandableListView.collapseGroup(lastPosition);
                }

                lastPosition = i;
            }
        });
    }

    private void preparedData() {
        //add title;
        title.add("Mashrafi");
        title.add("Afridi");
        title.add("Tamim");
        title.add("Sakib");
        title.add("Mostafiz");
        //add Child;
        List<String> mashrafi = new ArrayList<>();
        mashrafi.add("Best Captain");
        mashrafi.add("Sixer");
        child.put(title.get(0), mashrafi ) ;

        List<String> afridi = new ArrayList<>();
        afridi.add("Boom Boom");
        afridi.add("Sixer");
        child.put(title.get(1), afridi );

        List<String> tamim = new ArrayList<>();
        tamim.add("Tamim");
        tamim.add("Sixer");
        child.put(title.get(2), tamim ) ;

        List<String> sakib = new ArrayList<>();
        sakib.add("sakib");
        sakib.add("Sixer");
        child.put(title.get(3), sakib ) ;

        List<String> mostafiz = new ArrayList<>();
        mostafiz.add("mostafiz");
        mostafiz.add("Sixer");
        child.put(title.get(4), mostafiz ) ;

        ExLvAdapter adapter = new ExLvAdapter(this,title,child);
        expandableListView.setAdapter(adapter);
    }

    private void initView() {
        expandableListView = findViewById(R.id.exLvId);
    }
}
