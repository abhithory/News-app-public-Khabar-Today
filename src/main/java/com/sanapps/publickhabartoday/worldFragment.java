package com.sanapps.publickhabartoday;

import android.os.Bundle;

import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class worldFragment extends Fragment {
    RecyclerView recyclerView;
    LinearLayoutManager manager;
    recyclerViewAdapter adapter;
    List<Posts> posts = new ArrayList<>();
    ShimmerFrameLayout pkt_shimmer;
    Boolean isScrollling = false;
    int currentItems, totalItems, scrollOutItems;
    String token = "";
    NestedScrollView nestedScrollView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_world, container, false);

        recyclerView = rootview.findViewById(R.id.world_reView);
        pkt_shimmer = rootview.findViewById(R.id.world_shimmerlayout);

        nestedScrollView = rootview.findViewById(R.id.nested_view_world);


        manager = new LinearLayoutManager(getActivity());
        adapter = new recyclerViewAdapter(getActivity(), posts);

        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

                if (scrollY == v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight()) {

                    getAllPosts();

                }
            }
        });

        getAllPosts();

        return rootview;
    }

    private void getAllPosts() {

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(getActivity());

        String url = "Your api ";

        if (token != "") {
            url = url + "&pageToken=" + token;
        }
        if (token == null) {
            return;
        }


// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        Gson gson = (new GsonBuilder()).create();

                        fullJsonObject fullJsonObject = gson.fromJson(response, fullJsonObject.class);

                        token = fullJsonObject.getNextPageToken();

                        posts.addAll(fullJsonObject.getItems());

                        adapter.notifyDataSetChanged();

                        try {
                            pkt_shimmer.stopShimmer();
                            pkt_shimmer.setVisibility(View.GONE);
                        } catch (Exception e) {

                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), "error", Toast.LENGTH_SHORT).show();


                //textView.setText("That didn't work!");
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);


    }
}