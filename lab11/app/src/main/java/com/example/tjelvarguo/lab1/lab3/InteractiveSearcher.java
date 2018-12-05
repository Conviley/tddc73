package com.example.tjelvarguo.lab1.lab3;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;

/**
 * Created by Tjelvar Guo on 2018-11-19.
 */

public class InteractiveSearcher extends LinearLayout {

    private Context ctx;
    private EditText searchBar;
    private PopUpList popUpList;
    private PopupWindow popupWindow;
    private ScrollView scrollView;

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
        scrollView = new ScrollView(ctx);
        popupWindow = new PopupWindow(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.RED));
        popupWindow.setContentView(popUpList);
        //popupWindow.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
        this.addView(searchBar);
        //this.addView(popUpList);
    }

    public PopUpList getPopUpList() {
        return this.popUpList;
    }

    public EditText getSearchBar() {
        return this.searchBar;
    }

    public void showPopupList(){
        popupWindow.showAsDropDown(searchBar);
    }
}
