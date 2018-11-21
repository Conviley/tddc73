package com.example.tjelvarguo.lab1.lab3;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.tjelvarguo.lab1.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

public class Lab3 extends Activity {

    private PopUpList popUpList;
    private EditText searchBar;
    private InteractiveSearcher interactiveSearcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab3);
        interactiveSearcher = findViewById(R.id.interactiveSearcher);
        popUpList = interactiveSearcher.getPopUpList();
        searchBar = interactiveSearcher.getSearchBar();

        final ArrayList<String> names = new ArrayList<>();

        final RequestQueue queue = Volley.newRequestQueue(this);

        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                popUpList.clearNames();

                final String url = "http://andla.pythonanywhere.com/getnames/3/" + charSequence;

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                        (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    JSONArray results = response.getJSONArray("result");
                                    for (int i = 0; i < results.length(); i++) {
                                        names.add(results.get(i).toString());
                                    }
                                    popUpList.setNames(names);
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

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().equals(" ")){
                    popUpList.clearNames();
                }
            }
        });

    }
}
