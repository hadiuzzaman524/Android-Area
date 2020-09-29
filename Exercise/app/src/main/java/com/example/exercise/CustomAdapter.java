package com.example.exercise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.zip.Inflater;

public class CustomAdapter extends BaseAdapter {
    Context context;
    int pic[];
    CustomAdapter(Context context,int pic[])
    {
        this.context=context;
        this.pic=pic;
    }
    @Override
    public int getCount() {
        return pic.length;
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
            LayoutInflater inflater;
            inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           convertView=inflater.inflate(R.layout.imview,parent,false);
        }
        ImageView imageView=convertView.findViewById(R.id.imageviewid);
        imageView.setImageResource(pic[position]);

        return convertView;
    }
}
