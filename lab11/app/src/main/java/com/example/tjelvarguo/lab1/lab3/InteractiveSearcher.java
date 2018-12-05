package com.example.tjelvarguo.lab1.lab3;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Tjelvar Guo on 2018-11-19.
 */

public class InteractiveSearcher extends LinearLayout {

    private Context ctx;
    private EditText searchBar;
    private PopUpList popUpList;
    private PopupWindow popupWindow;
    private ScrollView scrollView;
    private int requestId;
    final ArrayList<String> names = new ArrayList<>();
    private RequestQueue queue;
    private boolean markChild = false;

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
        queue = Volley.newRequestQueue(ctx);
        searchBar = new EditText(ctx);

        popUpList = new PopUpList(ctx);
        popUpList.setParent(this);

        scrollView = new ScrollView(ctx);
        scrollView.addView(popUpList);

        popupWindow = new PopupWindow(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        popupWindow.setContentView(scrollView);
        popupWindow.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);

        this.addView(searchBar);

        setUp();
    }

    public void showPopupList(){
        popupWindow.showAsDropDown(searchBar);
    }

    private void setUp() {

        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                getMatchingNames(charSequence.toString(), markChild);
            }

            @Override
            public void afterTextChanged(Editable editable) { }
        });
    }

    public void getMatchingNames(String name, final boolean markChild){
        popUpList.clearNames();
        requestId++;

        final String url = "http://andla.pythonanywhere.com/getnames/" + requestId + '/' + name;

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                    (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                if (response.getInt("id") == requestId) {
                                    JSONArray results = response.getJSONArray("result");
                                    for (int i = 0; i < results.length(); i++) {
                                        names.add(results.get(i).toString());
                                    }
                                    popUpList.setNames(names);


                                    popUpList.markChild(markChild);


                                    showPopupList();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d("dee: ", error.toString());
                        }
                    });

            queue.add(jsonObjectRequest);
    }

    public void fillSearchBar(String name){
        markChild = true;
        searchBar.setText(name);
        searchBar.setSelection(name.length());
    }

    public void setMarkChild() {
        markChild = false;
    }
}
