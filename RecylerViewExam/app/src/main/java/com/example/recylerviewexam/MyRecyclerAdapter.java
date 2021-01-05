package com.example.recylerviewexam;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder>{

    private final List<CardItem> mDataList;

    // 1) 인터페이스로 리스너 구현
    public interface  MyRecyclerViewClickListener {
        // 내가 누른 아이템의 포지션을 외부에서 알 수 있도록 한다
        void onItemClicked(int position);
        void onSharedButtonClicked(int position);
        void onLearnMoreButtonClicked(int position);
    }

    // 2) 인터페이스를 내부에서 하나 들고 있어야함
    private MyRecyclerViewClickListener mListener;

    // 3) 인터페이스를 외부에서 접근할 수 있도록 함
    // 외부에서 리스너 지정할 수 있도록 함
    // 4) 외부에서 연결이 되면, 실제 클릭이 일어나는 부분은 BindViewHolder에서 처리한다
    public void setOnClickListener(MyRecyclerViewClickListener listener) {
        mListener = listener;
    }


    // 3. 외부에서 데이터를 받을 수 있게 constructor 생성
    // 4. 아이템 정의하기
    public MyRecyclerAdapter(List<CardItem> dataList) {
        mDataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 2. 뷰홀더를 만드는 부분 (뷰 얻기)
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // 위에서 리턴해주면, 뷰홀더가 들어와서 데이터를 바인드 해주는 부분.
        // 6. 데이터 세팅
        CardItem item = mDataList.get(position); // 아이템 얻어오기

        // holder에 데이터 넣기
        holder.title.setText(item.getTitle());
        holder.contents.setText(item.getContents());

        // 4) 외부에서 리스너를 연결했다면,
        if (mListener != null) {
            // 현재 위치
            final int pos = position;
            // 전체 아이템을 눌렀을 때, mListener의 onItemClicked로 position값을 던져주자
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onItemClicked(pos);
                    // 또는 밑에처럼 해도 가능
//                    mListener.onItemClicked(holder.getAdapterPosition());
                }
            });
            holder.share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onSharedButtonClicked(pos);
                }
            });
            holder.more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onLearnMoreButtonClicked(pos);
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        // 5. 어댑터가 갖는 아이템의 갯수 지정
        return mDataList.size();
    }

    // 1. 제일 먼저 뷰홀더 만들기
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, contents;
        // 5) shared, more Button도 추가!
        Button share, more;
        public ViewHolder(@NonNull View itemView) {
            // 생성자
            super(itemView);
            title = itemView.findViewById(R.id.title_text);
            contents = itemView.findViewById(R.id.contents_text);
            share = itemView.findViewById(R.id.share_button);
            more = itemView.findViewById(R.id.more_button);
        }
    }
}
