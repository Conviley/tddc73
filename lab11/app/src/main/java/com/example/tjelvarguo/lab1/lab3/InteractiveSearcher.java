package com.example.tjelvarguo.lab1.lab3;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by Tjelvar Guo on 2018-11-19.
 */

public class InteractiveSearcher extends LinearLayout {

    private Context ctx;
    private EditText searchBar;
    private PopUpList popUpList;

    public InteractiveSearcher(Context context) {
        super(context);
        this.ctx = context;
        init();
    }

    public InteractiveSearcher(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.ctx = context;
        init();
    }

    private void init() {
        setOrientation(VERTICAL);
        searchBar = new EditText(ctx);
        popUpList = new PopUpList(ctx);

        this.addView(searchBar);
        this.addView(popUpList);
    }

    public PopUpList getPopUpList() {
        return this.popUpList;
    }

    public EditText getSearchBar() {
        return this.searchBar;
    }
}
