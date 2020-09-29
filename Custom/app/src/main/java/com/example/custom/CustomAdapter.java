package com.example.custom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    Context context;
    String name[];
    int pictures[];
    LayoutInflater inflater;

    CustomAdapter(Context context,String name[],int pictures[])
    {
        this.context=context;
        this.name=name;
        this.pictures=pictures;

    }
    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null)
        {
            inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.customlayout,parent,false);

        }
        ImageView imageView=convertView.findViewById(R.id.imageviewid);
        TextView textView=convertView.findViewById(R.id.textviewid);


       imageView.setImageResource(pictures[position]);
        textView.setText(name[position]);

        return convertView;
    }

}
