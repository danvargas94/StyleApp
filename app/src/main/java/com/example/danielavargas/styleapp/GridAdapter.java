package com.example.danielavargas.styleapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.parse.ParseObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danielavargas on 04/05/17.
 */

public class GridAdapter extends BaseAdapter {

    private int icons[];
    private List<ParseObject> images = new ArrayList<ParseObject>();;
    private Context context;
    private LayoutInflater inflater;

    public GridAdapter(Context context,List<ParseObject> images){
        this.context = context;
        this.images = images;
        //this.icons = icons;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object getItem(int position) {
        return icons[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View gridView = convertView;
        ImageView img;
        if(convertView == null){
            img = new ImageView(context);
            img.setLayoutParams(new GridView.LayoutParams(200,200));
            img.setScaleType(ImageView.ScaleType.FIT_CENTER);
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            gridView = inflater.inflate(R.layout.grid_layout, null);
        }else{
            img = (ImageView) convertView;
        }

        ParseObject clothes = images.get(position);

        if(clothes.getParseFile("image") != null){
            System.out.println("Imagen: "+clothes.getParseFile("image").getUrl());
            Glide.with(context).load(clothes.getParseFile("image").getUrl()).into(img);
        }

        //img.setImageResource(icons[position]);
        return img;
    }
}
