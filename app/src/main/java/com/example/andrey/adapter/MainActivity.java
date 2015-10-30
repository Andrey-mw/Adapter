package com.example.andrey.adapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText poisk;
    private ListView listView;

    List<Example> exampleListView = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        poisk = (EditText) findViewById(R.id.poisk);

        exampleListView.add(new Example("Row 1", "1"));
        exampleListView.add(new Example("Row 2", "2"));
        exampleListView.add(new Example("Row 3", "3"));
        exampleListView.add(new Example("Row 4", "4"));
        exampleListView.add(new Example("Row 5", "5"));

        final MyAdapter adapter = new MyAdapter(exampleListView, this);

        listView.setAdapter(adapter);


        poisk.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                adapter.getFilter().filter(s.toString());

            }
        });


    }


}
