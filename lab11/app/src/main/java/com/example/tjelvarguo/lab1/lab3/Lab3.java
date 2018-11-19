package com.example.tjelvarguo.lab1.lab3;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.tjelvarguo.lab1.R;

import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

public class Lab3 extends Activity {

    private PopUpList popUpList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab3);
        popUpList = findViewById(R.id.popuplist);

        ArrayList<String> names = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            names.add("hejgkjhgjkhgjkhgjhk" + i);
        }

        popUpList.setNames(names);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://andla.pythonanywhere.com/getnames/3/Emm";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("dee", "onResponse: " + response.toString());
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });

        queue.add(jsonObjectRequest);


    }
}
