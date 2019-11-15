package com.example.hw3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hw3.activity.CatDetailActivity;
import com.example.hw3.model.Cat;

import java.util.ArrayList;
import java.util.List;

public class FavouritesAdapter extends RecyclerView.Adapter<FavouritesAdapter.FavouritesViewHolder>  {

    private List<Cat> faveCats;

    public FavouritesAdapter(List<Cat> faveCats) {
        this.faveCats = faveCats;

    }

    public FavouritesAdapter() {

    }

    public void setData(List<Cat> faveCats) {
        this.faveCats = faveCats;
    }

    @NonNull
    @Override
    public FavouritesAdapter.FavouritesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.favourites, parent, false);

        FavouritesAdapter.FavouritesViewHolder favouritesViewHolder = new FavouritesAdapter.FavouritesViewHolder(view);
        return favouritesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FavouritesAdapter.FavouritesViewHolder holder, int position) {
        final Cat faveCatAtPosition = faveCats.get(position);

        holder.bind(faveCatAtPosition);
    }

    @Override
    public int getItemCount() {
        return faveCats.size();
    }

    public class FavouritesViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView titleTextView;

        public FavouritesViewHolder(View v) {
            super(v);
            view = v;
            titleTextView = v.findViewById(R.id.fave_title);

        }

        public void bind(final Cat cat) {
            titleTextView.setText(cat.getName());


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();

                    Intent intent = new Intent(context, CatDetailActivity.class);
                    intent.putExtra("id", cat.getId());
                    context.startActivity(intent);
                }
            });

        }

    };


}
