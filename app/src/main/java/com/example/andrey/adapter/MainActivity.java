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
    List<Example> exampleListView;
    MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        poisk = (EditText) findViewById(R.id.poisk);

        initList();


        adapter = new MyAdapter(exampleListView, this);

        listView.setAdapter(adapter);


        poisk.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

//                if (s.toString().equals("")) {
//                    initList();

//                }
//                searchItem(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {
                adapter.getFilter().filter(s.toString());

            }
        });


    }

    public void initList() {

        exampleListView = new ArrayList<>();
        exampleListView.add(new Example("first", "1"));
        exampleListView.add(new Example("second", "2"));
        exampleListView.add(new Example("third", "3"));
        exampleListView.add(new Example("fourth", "4"));
        exampleListView.add(new Example("fifth", "5"));
        exampleListView.add(new Example("sixth", "6"));
        exampleListView.add(new Example("seventh", "7"));
        exampleListView.add(new Example("eighth", "8"));


    }

//    public void searchItem(String textSearch){
//        for(Example item: exampleListView){
//            if(!item.equals(textSearch)){
//                exampleListView.remove(item);
//            }
//            adapter.notifyDataSetChanged();
//
//        }
//    }


}
