package com.example.hw3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
//import com.example.hw3.activity.CatDetailActivity;
import com.example.hw3.model.Cat;

import java.util.ArrayList;
import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatViewHolder>  {
    private List<Cat> catsToAdapt;

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

        // Contrast how I wrote this method with the method for ArticleAdapter. They both achieve
        // the same goal, but this way is cleaner. I defined my own method "bind" in the BookViewHolder
        // class, and all the assignment and setup is done in there instead.
        holder.bind(catAtPosition);
    }

    @Override
    public int getItemCount() {
        return catsToAdapt.size();
    }

    public static class CatViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView titleTextView;

        /*public TextView authorTextView;
        public TextView rankTextView;
        public ImageView shareImageView;
        public ImageView bookmarkImageView;
        public ImageView coverImageView;
        public boolean isBookmarked = false;
        */
        // This constructor is used in onCreateViewHolder
        public CatViewHolder(View v) {
            super(v);  // runs the constructor for the ViewHolder superclass
            view = v;
            titleTextView = v.findViewById(R.id.title);
            /*authorTextView = v.findViewById(R.id.tv_author);
            rankTextView = v.findViewById(R.id.tv_rank);
            shareImageView = v.findViewById(R.id.iv_share);
            bookmarkImageView = v.findViewById(R.id.iv_save);
            coverImageView = v.findViewById(R.id.iv_cover);
            */

            /*bookmarkImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(isBookmarked) {
                        bookmarkImageView.setImageResource(R.drawable.ic_bookmark_border_black_24dp);
                    } else {
                        bookmarkImageView.setImageResource(R.drawable.ic_bookmark_black_24dp);
                    }
                    isBookmarked = !isBookmarked;
                }
              */

        }

        public void bind(final Cat cat) {
            titleTextView.setText(cat.getName());
            /*authorTextView.setText(book.getAuthor());
            rankTextView.setText("#" + book.getRank());
            */

            /*
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();

                    Intent intent = new Intent(context, CatDetailActivity.class);
                    intent.putExtra("isbn", cat.getId());
                    context.startActivity(intent);
                }
            });
*/
            /*shareImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(Intent.ACTION_SEND);

                    intent.putExtra(Intent.EXTRA_TEXT, cat.getName());
                    intent.setType("text/plain");
                    context.startActivity(intent);
                }
            });
*/
            String imageUrl = cat.getCatImage();
            //Glide.with(view.getContext()).load(imageUrl).into(coverImageView);
        }


    };
}
