package com.example.recyclerview2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recyclerview2.adapter.TripsAdapter;
import com.example.recyclerview2.models.Ads;
import com.example.recyclerview2.models.Item;
import com.example.recyclerview2.models.News;
import com.example.recyclerview2.models.Trip;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        List<Item> items = new ArrayList<>();

        Trip trip1 = new Trip(R.drawable.ic_launcher_background, "image1", "image111");
        items.add(new Item(0, trip1));

        Ads ads1 = new Ads("Ad : Nothing", "please..");
        items.add(new Item(1, ads1));

        News news1 = new News("texttttt2", "tteexxxttttt2222222");
        items.add(new Item(2, news1));

        Trip trip2 = new Trip(R.drawable.ic_launcher_background, "image2", "image2222");
        items.add(new Item(0, trip2));

        Ads ads2 = new Ads("2Ad : Nothing", "please..");
        items.add(new Item(1, ads2));

        News news2 = new News("33texttttt3333333", "tteexxxttttt33333333");
        items.add(new Item(2, news2));

        Ads ads3 = new Ads("3Ad : ediffff", "zzazeung");
        items.add(new Item(1, ads3));

        recyclerView.setAdapter(new TripsAdapter(items));
    }
}