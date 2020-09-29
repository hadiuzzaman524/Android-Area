package com.example.acustomadapter;

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
    int flag[];
    LayoutInflater inflater;

    CustomAdapter(Context context,String name[],int flag[])
    {
        this.context=context;
        this.name=name;
        this.flag=flag;
    }
    @Override
    public int getCount() {
        return 2;
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

        if(convertView==null)
        {
            inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
         convertView=   inflater.inflate(R.layout.sample,parent,false);


        }
        ImageView imageView=convertView.findViewById(R.id.imageviewid);
        TextView textView=convertView.findViewById(R.id.countynametextviewid);

        imageView.setImageResource(flag[position]);
        textView.setText(name[position]);

        return convertView;
    }
}
