package com.example.vikingwarlock.sdcardproject;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.nostra13.universalimageloader.*;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.w3c.dom.Text;

/**
 * Created by vikingwarlock on 16-9-23.
 * This is an adapter that controls gridview's datasource
 */


public class GridItemAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private List<GridItem> gridItemList;


    public GridItemAdapter(String[] titles, int[] images, String[] description, Context context) {
        super();
        inflater = LayoutInflater.from(context);
    }

    public void setupData(List<GridItem> datasource) {
        gridItemList = datasource;

    }

    @Override
    public int getCount() {
        if (gridItemList != null)
            return gridItemList.size();
        else return 0;
    }

    @Override
    public Object getItem(int position) {
        return gridItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        GridItemView item;
        GridItem data = gridItemList.get(position);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.gridviewitem, null);
            item = new GridItemView();
            item.filename = (TextView) convertView.findViewById(R.id.itemName);
            item.imageView = (ImageView) convertView.findViewById(R.id.itemImage);
            convertView.setTag(item);
        } else {
            item = (GridItemView) convertView.getTag();
        }
        ImageLoader.getInstance().displayImage("file://"+data.filepath,item.imageView);
        item.filename.setText(data.filename);
        return convertView;
    }
}
