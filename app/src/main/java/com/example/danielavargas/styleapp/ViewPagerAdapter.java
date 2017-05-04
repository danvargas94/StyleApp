package com.example.danielavargas.styleapp;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by danielavargas on 23/04/17.
 */

public class ViewPagerAdapter extends PagerAdapter{

    private Context context;
    private String tag;
    private String weather;
    private LayoutInflater layoutInflater;
    private Integer [] images = {R.drawable.back, R.drawable.background, R.drawable.fondo};
    private Integer [] upImages = {R.drawable.blusa1, R.drawable.blusa2};
    private Integer [] pantsImages = {R.drawable.falda3, R.drawable.pants1};
    private Integer [] shoesImages = {R.drawable.shoes1, R.drawable.shoes2};

    public  ViewPagerAdapter(Context context, String weather, String tag){
        this.weather = weather;
        this.tag = tag;
        this.context = context;
    }

    @Override
    public int getCount() {
        if (tag.equals("up")){
            return upImages.length;
        }else  if (tag.equals("pants")){
            return pantsImages.length;
        }else {
            return shoesImages.length;
        }
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
        if (tag.equals("up")){
            imageView.setImageResource(upImages[position]);
        }else  if (tag.equals("pants")){
            imageView.setImageResource(pantsImages[position]);
        }else {
            imageView.setImageResource(shoesImages[position]);
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
