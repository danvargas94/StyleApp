package com.example.danielavargas.styleapp;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.parse.ParseObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danielavargas on 23/04/17.
 */

public class ViewPagerAdapter extends PagerAdapter{

    private Context context;


    private LayoutInflater layoutInflater;
    private List<ParseObject> images = new ArrayList<ParseObject>();;

    public  ViewPagerAdapter(Context context,List<ParseObject> images){

        this.context = context;
        this.images = images;


    }

    @Override
    public int getCount() {
       return images.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_layout, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);

        //
        ParseObject clothes = images.get(position);

        if(clothes.getParseFile("image") != null){
            System.out.println("Imagen: "+clothes.getParseFile("image").getUrl());
            Glide.with(context).load(clothes.getParseFile("image").getUrl()).into(imageView);
        }

        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);
    }
}
