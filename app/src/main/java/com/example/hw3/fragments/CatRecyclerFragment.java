package com.example.hw3.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.hw3.CatAdapter;
import com.example.hw3.R;
import com.example.hw3.database.AppDatabase;
import com.example.hw3.model.Cat;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CatRecyclerFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<Cat> catsFromDatabase;

    public CatRecyclerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cat_recycler, container, false);
        recyclerView = view.findViewById(R.id.rv_main);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);

        final CatAdapter catAdapter = new CatAdapter();

        // Start Volley
        // 1. Create request queue.
        // 2. Create response listener and error listener
        // 3. Create Request object using url, response listener, error listener.
        // 4. Put Request object into request queue.

        final RequestQueue requestQueue =  Volley.newRequestQueue(getActivity());

        String url = "https://api.thecatapi.com/v1/breeds";

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Gson gson = new Gson();
                Cat[] objectsArray = gson.fromJson(response, Cat[].class);

                //for (Cat c : objectsArray) { System.out.println(c); }

                List<Cat> objectsList = Arrays.asList(objectsArray);

                //for (Cat c : objectsList) { System.out.println(c); }


                // Save my results to the database
                AppDatabase db = AppDatabase.getInstance(getContext());

                db.catDao().insertAll(objectsList);

                // Get what's in the database now
                List<Cat> listCatsFromDatabase = db.catDao().getAll();

                //for (Cat c : listCatsFromDatabase) { System.out.println(c); }

                // Convert list to array list
                ArrayList<Cat> catsFromDatabase = new ArrayList<Cat>(listCatsFromDatabase);

                //System.out.println(Arrays.toString(catsFromDatabase.toArray()));

                catAdapter.setData(catsFromDatabase);
                recyclerView.setAdapter(catAdapter);

                // Close queue
                requestQueue.stop();
            }


        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(),"The request failed: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                requestQueue.stop();
            }
        };

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, responseListener,
                errorListener);

        requestQueue.add(stringRequest);

        View v = inflater.inflate(R.layout.fragment_cat_recycler,container,false);
        EditText editText = v.findViewById(R.id.edittext);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());

            }
        });

        return view;


    }

    public void filter(String search) {
            ArrayList<Cat> filteredList = new ArrayList<>();
            for(Cat c : catsFromDatabase){
                if (c.getName().toLowerCase().contains(search.toLowerCase())) {
                    filteredList.add(c);
                }
                CatAdapter catAdapter = new CatAdapter();
                catAdapter.filterList(catsFromDatabase);
            }


    }


}
