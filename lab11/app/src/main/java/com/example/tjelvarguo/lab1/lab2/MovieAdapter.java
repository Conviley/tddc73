package com.example.tjelvarguo.lab1.lab2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
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
    private EditText pathDisplay;

    public MovieAdapter(Context ctx, HashMap<String, List<String>> movieCollection,
                        List<String> genres, EditText pathDisplay) {
        this.ctx = ctx;
        this.movieCollection = movieCollection;
        this.genres = genres;
        this.pathDisplay = pathDisplay;
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
    public View getGroupView(int parent, boolean isExpanded, View childView, ViewGroup parentView) {
        String groupTitle = (String) getGroup(parent);
        if (childView == null) {
            LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            childView = inflater.inflate(R.layout.exp_list_parent_view, parentView, false);
        }

        TextView parentText = childView.findViewById(R.id.parent_text);
        parentText.setText(groupTitle);

        return childView;
    }

    @Override
    public View getChildView(final int parent, final int child, boolean lastChild, View childView, final ViewGroup parentView) {
        String childTitle = (String) getChild(parent, child);
        if (childView == null) {
            LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            childView = inflater.inflate(R.layout.exp_list_child_view, parentView, false);
        }
        LinearLayout container = childView.findViewById(R.id.child_container);
        container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pathDisplay.setText("/" + getGroup(parent) + "/" + getChild(parent, child));
                pathDisplay.setSelection(pathDisplay.getText().length());
            }
        });
        TextView childText =  childView.findViewById(R.id.child_text);
        childText.setText(childTitle);

        return childView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
