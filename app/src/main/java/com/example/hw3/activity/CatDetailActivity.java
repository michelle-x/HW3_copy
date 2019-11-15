package com.example.hw3.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.hw3.FavouritesAdapter;
import com.example.hw3.R;
import com.example.hw3.database.AppDatabase;
import com.example.hw3.model.Cat;

import java.util.List;

public class CatDetailActivity  extends AppCompatActivity {

    ConstraintLayout catConstraintLayout;
    TextView nameTextView;
    TextView descTextView;
    TextView weightTextView;
    TextView tempTextView;
    TextView originTextView;
    TextView lifeTextView;
    TextView wikiTextView;
    TextView dogTextView;
    ImageView catImageView;

    private List<Cat> faveCats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_detail);

        catConstraintLayout = findViewById(R.id.cat);
        nameTextView = catConstraintLayout.findViewById(R.id.detail_name);
        descTextView = catConstraintLayout.findViewById(R.id.detail_desc);
        weightTextView = catConstraintLayout.findViewById(R.id.detail_weight);
        tempTextView = catConstraintLayout.findViewById(R.id.detail_temp);
        originTextView = catConstraintLayout.findViewById(R.id.detail_origin);
        lifeTextView = catConstraintLayout.findViewById(R.id.detail_life);
        wikiTextView = catConstraintLayout.findViewById(R.id.detail_wiki);
        dogTextView = catConstraintLayout.findViewById(R.id.detail_dog);

        final Intent intent = getIntent();

        final String id = intent.getStringExtra("id");
        final AppDatabase db = AppDatabase.getInstance(this);
        final Cat cat = db.catDao().findCatById(id);

        nameTextView.setText(cat.getName());
        descTextView.setText(cat.getDescription());
        weightTextView.setText(cat.getWeight_imperial());
        tempTextView.setText(cat.getTemperament());
        originTextView.setText(cat.getOrigin());
        lifeTextView.setText(cat.getLife_span());
        wikiTextView.setText(cat.getWikipedia_url());
        dogTextView.setText(cat.getDog_friendly());

        //String imageUrl = cat.getCatImage();
        //Glide.with(this).load(imageUrl).into(catImageView);


        Button clickFave = (Button)findViewById(R.id.favebtn);
        clickFave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //How to add this cat to array of fave cats
                faveCats.add(cat);

                FavouritesAdapter favouritesAdapter = new FavouritesAdapter();
                favouritesAdapter.setData(faveCats);

            }
        });

    }



}
