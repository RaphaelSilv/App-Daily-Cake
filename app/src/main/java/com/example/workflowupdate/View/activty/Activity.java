package com.example.workflowupdate.View.activty


import android.os.Bundle;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.workflowupdate.Model.JSONPost;
import com.example.workflowupdate.Model.Tags;
import com.example.workflowupdate.R;
import com.example.workflowupdate.View.adapter.MainAdapter;
import com.google.gson.JsonArray;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

class Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MainAdapter mainAdapter;
    private ArrayList<JSONPost> jsonPosts;
    private RequestQueue requestQueue;

    protected void onCreate(Bundle savedInstance) {

        super.onCreate(savedInstance);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        jsonPosts = new ArrayList<>();

        requestQueue = Volley.newRequestQueue(this);

        parseJSON();
    }

    private void parseJSON() {

        String url = " ";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {




                    public void onResponse(JSONArray response) {
                        int count = 0;

                        while (count < response.length()) try {

                            JSONObject jsonObject = response.getJSONObject(count);




                            JSONPost currentJSONPost = new JSONPost(jsonObject.getString("title"), jsonObject.getString("website"), jsonObject.getString("authors"),
                                    jsonObject.getString("date"), jsonObject.getString("content"), jsonObject.put("tags", ));



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                error.printStackTrace();
            }
        });


    }

}


