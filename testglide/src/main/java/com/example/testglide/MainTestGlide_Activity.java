package com.example.testglide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainTestGlide_Activity extends AppCompatActivity {
    private ImageView imageView;
    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_test_glide);
        imageView = (ImageView) findViewById(R.id.imageView);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        ArrayList imageUrlList = prepareData();
        DataAdapter dataAdapter = new DataAdapter(getApplicationContext(), imageUrlList);
        recyclerView.setAdapter(dataAdapter);
    }
    private ArrayList prepareData() {

// here you should give your image URLs and that can be a link from the Internet
        String imageUrls[] = {
                "https://static.pexels.com/photos/53966/rabbit-palm-hand-snatch-53966.jpeg",
                "https://static.pexels.com/photos/53966/rabbit-palm-hand-snatch-53966.jpeg",
                "https://static.pexels.com/photos/53966/rabbit-palm-hand-snatch-53966.jpeg",
                "https://static.pexels.com/photos/53966/rabbit-palm-hand-snatch-53966.jpeg"};

        ArrayList imageUrlList = new ArrayList<>();
        for (int i = 0; i < imageUrls.length; i++) {
            ImageUrl imageUrl = new ImageUrl();
            imageUrl.setImageUrl(imageUrls[i]);
            imageUrlList.add(imageUrl);
        }
        Log.d("MainActivity", "List count: " + imageUrlList.size());
        return imageUrlList;
    }
}
