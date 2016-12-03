package com.demo.gridview;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by 1027 on 2016-12-03.
 */

public class MyGridAdapter extends BaseAdapter {
    Context context;
    int[] posterID = {
            R.drawable.mov01,R.drawable.mov02,R.drawable.mov03,R.drawable.mov04,R.drawable.mov05,
            R.drawable.mov06,R.drawable.mov07,R.drawable.mov08,R.drawable.mov09,R.drawable.mov10,
            R.drawable.mov11,R.drawable.mov12,R.drawable.mov13,R.drawable.mov14,R.drawable.mov15
    };

    public MyGridAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return posterID.length;
    }

    @Override
    public Object getItem(int i) {
        return posterID[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageview = new ImageView(context);
        imageview.setLayoutParams(new GridView.LayoutParams(100, 150));
        imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageview.setPadding(5, 5, 5, 5);

        imageview.setImageResource(posterID[position]);

        final int pos = position;
        imageview.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                View dialog = View.inflate(context, R.layout.dialog, null);
                AlertDialog.Builder ad = new AlertDialog.Builder(context);
                ImageView iv = (ImageView)dialog.findViewById(R.id.iv_poster);
                iv.setImageResource(posterID[pos]);
                ad.setTitle("MOVIE");
                ad.setIcon(R.drawable.movie_icon);
                ad.setView(dialog);
                ad.setNegativeButton("CLOSE",null);
                ad.show();
            }
        });

        return imageview;
    }
}