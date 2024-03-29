package com.example.hw3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.hw3.activity.CatDetailActivity;
import com.example.hw3.activity.CatDetailActivity;
import com.example.hw3.model.Cat;

import java.util.ArrayList;
import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatViewHolder>  {
    private List<Cat> catsToAdapt;


    public CatAdapter(List<Cat> catsToAdapt) {
        this.catsToAdapt = catsToAdapt;
    }



    public CatAdapter() {

    }




    public void setData(List<Cat> catsToAdapt) {
        this.catsToAdapt = catsToAdapt;
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.cat, parent, false);

        CatViewHolder catViewHolder = new CatViewHolder(view);
        return catViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position) {
        final Cat catAtPosition = catsToAdapt.get(position);

        holder.bind(catAtPosition);
    }

    @Override
    public int getItemCount() {
        return catsToAdapt.size();
    }

    public class CatViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView titleTextView;

        public CatViewHolder(View v) {
            super(v);  // runs the constructor for the ViewHolder superclass
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

           // String imageUrl = cat.getCatImage();
            //Glide.with(view.getContext()).load(imageUrl).into(catImageView);
        }

    }

    public void filterList(ArrayList<Cat> filteredList) {
        catsToAdapt = filteredList;
        notifyDataSetChanged();
    }
}
