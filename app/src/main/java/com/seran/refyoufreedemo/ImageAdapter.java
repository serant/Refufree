package com.seran.refyoufreedemo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by seranthirugnanam on 2016-12-01.
 */

public class ImageAdapter extends BaseAdapter {

    private Context mContext;

    public ImageAdapter(Context c){
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(8, 8, 8, 8);
        } else  {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);

        return imageView;
    }

    private Integer[] mThumbIds = {
            R.drawable.number_1,
            R.drawable.number_2,
            R.drawable.number_3,
            R.drawable.number_4,
            R.drawable.number_5,
            R.drawable.number_6,
            R.drawable.number_7,
            R.drawable.number_8,
            R.drawable.number_9,
            R.drawable.asterisk,
            R.drawable.number_0,
            R.drawable.pound,
            R.drawable.call
    };
}
