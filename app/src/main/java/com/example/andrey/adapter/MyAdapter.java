package com.example.andrey.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrey on 29.10.2015.
 */
public class MyAdapter extends BaseAdapter implements Filterable {

    private List<Example> examples;
    private List<Example> filter;
    private Context context;


    public MyAdapter(List<Example> examples, Context context) {
        this.context = context;
        this.examples = examples;
        this.filter = new ArrayList<>(examples);

    }


    @Override
    public int getCount() {
        return examples.size();
    }

    @Override
    public Object getItem(int position) {
        return examples.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textName;
        TextView textDescreption;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
            textName = (TextView) convertView.findViewById(R.id.row);
            textDescreption = (TextView) convertView.findViewById(R.id.number);
            convertView.setTag(new ViewHolder(textName, textDescreption));

        } else {

            ViewHolder viewHolder = (ViewHolder) convertView.getTag();
            textName = viewHolder.textView;
            textDescreption = viewHolder.textView1;
        }

        Example example = (Example) getItem(position);
        textDescreption.setText(example.getName());
        textName.setText(example.getDescription());

        return convertView;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                return null;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

            }
        };
    }


    private class ViewHolder {
        private final TextView textView;
        private final TextView textView1;

        public ViewHolder(TextView textView, TextView textView1) {
            this.textView = textView;
            this.textView1 = textView1;
        }

        public TextView getTextView() {
            return textView;
        }

        public TextView getTextView1() {
            return textView1;
        }


    }
}

