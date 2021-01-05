package com.example.recylerviewexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyRecyclerAdapter.MyRecyclerViewClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 7. 리사이클러뷰 가져오기
        RecyclerView recyclerView = findViewById(R.id.recycler_View);

        // 리사이클러뷰 자체를 리스트뷰, 그리드뷰 처럼 가능
        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        // 이거 안하면 안 나온다
        recyclerView.setLayoutManager(layoutManager);

        // 가상 데이터 생성
        List<CardItem> dataList =new ArrayList<>();
        dataList.add(new CardItem("번째", "설명\n설명\n설명 "));
        dataList.add(new CardItem("번째", "설명설명설명 "));
        dataList.add(new CardItem("번째", "설명\n설명\n설명 "));
        dataList.add(new CardItem("번째", "설명설명설명 "));
//        for (int i = 0; i < 10; i++) {
//            dataList.add(new CardItem(i+"번째", "설명 " + i));
//        }

        // 어댑터 생성
        MyRecyclerAdapter adapter = new MyRecyclerAdapter(dataList);
        recyclerView.setAdapter(adapter);

        // 리사이클러뷰에는 따로 온아이템클릭리스너가 없어서 따로 어댑터에 구현해야한다
        // 5) 리사이클러 어댑터에는 셋온클릭리스너 있당
        adapter.setOnClickListener(this);
    }


    // 6) implements
    @Override
    public void onItemClicked(int position) {
        Toast.makeText(this, " " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSharedButtonClicked(int position) {
        Toast.makeText(this, "Share " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLearnMoreButtonClicked(int position) {
        Toast.makeText(this, "More " + position, Toast.LENGTH_SHORT).show();
    }
}