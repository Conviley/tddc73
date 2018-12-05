package com.example.tjelvarguo.lab1.lab3;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tjelvar Guo on 2018-11-19.
 */

public class PopUpList extends LinearLayout {

    private Context ctx;
    private List<String> names = new ArrayList<>();
    private List<NameRow> nameRows = new ArrayList<>();
    private InteractiveSearcher parent;


    public  PopUpList(Context context) {
        super(context);
        this.ctx = context;
        init();
    }

    public PopUpList(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.ctx = context;
        init();
    }

    private void init(){
        this.setOrientation(VERTICAL);

        fillView();
    }

    private void fillView(){
        this.removeAllViews();
        nameRows.clear();
        int longestNameLength = 0;
        String longestName = "";

        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).length() > longestNameLength) {
                longestName = names.get(i);
                longestNameLength = names.get(i).length();
            }
        }
        for (int i = 0; i < names.size(); i++) {
            NameRow nameRow = new NameRow(ctx);
            nameRow.setName(names.get(i));
            nameRow.setParent(this);
            nameRows.add(nameRow);
            nameRow.setViewWidth(longestName);
            this.addView(nameRow);
        }


    }

    private void reDraw() {
        fillView();
        invalidate();
        requestLayout();
    }

    public void setNames(List<String> names){
        this.names = names;
        reDraw();
    }

    public void clearNames() {
        this.names.clear();
        reDraw();
    }

    public void setParent(InteractiveSearcher interactiveSearcher) {
        this.parent = interactiveSearcher;
    }

    public void selectChild(String name){
        parent.fillSearchBar(name);
    }

    public void markChild(boolean markChild){
        if (markChild) {
            nameRows.get(0).setBackgroundColor(Color.GRAY);
            parent.setMarkChild();
        }
    }
}
