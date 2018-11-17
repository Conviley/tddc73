package com.example.tjelvarguo.lab1.lab2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.tjelvarguo.lab1.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Tjelvar Guo on 2018-11-17.
 */

public class MovieAdapter extends BaseExpandableListAdapter{

    private Context ctx;
    private HashMap<String, List<String>> movieCollection;
    private List<String> genres;

    public MovieAdapter(Context ctx, HashMap<String, List<String>> movieCollection, List<String> genres) {
        this.ctx = ctx;
        this.movieCollection = movieCollection;
        this.genres = genres;
    }

    @Override
    public int getGroupCount() {
        return genres.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return movieCollection.get(genres.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return genres.get(i);
    }

    @Override
    public Object getChild(int parent, int child) {
        return movieCollection.get(genres.get(parent)).get(child);
    }

    @Override
    public long getGroupId(int i) {
        return i;
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
    public View getGroupView(int parent, boolean isExpanded, View convertView, ViewGroup parentView) {
        String groupTitle = (String) getGroup(parent);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.exp_list_parent_view, parentView, false);
        }

        TextView parentText = convertView.findViewById(R.id.parent_text);
        parentText.setText(groupTitle);

        return convertView;
    }

    @Override
    public View getChildView(int parent, int child, boolean lastChild, View convertVIew, ViewGroup parentView) {
        String childTitle = (String) getChild(parent, child);
        if (convertVIew == null) {
            LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertVIew = inflater.inflate(R.layout.exp_list_child_view, parentView, false);
        }

        TextView childText =  convertVIew.findViewById(R.id.child_text);
        childText.setText(childTitle);

        return convertVIew;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
