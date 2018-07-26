package com.example.admin.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class cusAd extends ArrayAdapter<contact> {
    private Context context;
    private int res;
    private ArrayList<contact> arr;

    public cusAd(@NonNull Context context, int resource, @NonNull ArrayList<contact> objects) {
        super(context, resource, objects);
        this.context=context;
        this.res=resource;
        this.arr=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        viewHolder viewHolder;
        if(convertView==null){
            viewHolder=new viewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.phone,parent,false);
            viewHolder.texName=convertView.findViewById(R.id.texName);
            viewHolder.texNum=convertView.findViewById(R.id.texNum);
            viewHolder.img=convertView.findViewById(R.id.img);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder= (viewHolder) convertView.getTag();
        }
        contact contact=arr.get(position);
        viewHolder.texName.setText(contact.getTexName());
        viewHolder.texNum.setText(contact.getTexNum());
        viewHolder.img.setImageResource(contact.getImg());

        return convertView;
    }

    private class viewHolder{
        private ImageView img;
        private TextView texName;
        private TextView texNum;
    }
}
