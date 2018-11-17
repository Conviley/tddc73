package com.example.tjelvarguo.lab1.lab2;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Tjelvar Guo on 2018-11-17.
 */

public class MovieAdapter extends BaseExpandableListAdapter{

    private Context ctx;
    private HashMap<String, List<String>> movieCategories;
    private List<String> movieList;

    public MovieAdapter(Context ctx, HashMap<String, List<String>> movieCategories, List<String> movieList) {
        this.ctx = ctx;
        this.movieCategories = movieCategories;
        this.movieList = movieList;
    }

    @Override
    public int getGroupCount() {
        return 0;
    }

    @Override
    public int getChildrenCount(int i) {
        return 0;
    }

    @Override
    public Object getGroup(int i) {
        return null;
    }

    @Override
    public Object getChild(int parent, int child) {
        return movieCategories.get(movieList.get(parent)).get(child);
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int parent, int child) {
        return child;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        return null;
    }

    @Override
    public View getChildView(int parent, int child, boolean lastChild, View convertVIew, ViewGroup parentView) {
        String childTitle = (String) getChild(parent, child);
        if (convertVIew == null) {
            LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        return null;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
