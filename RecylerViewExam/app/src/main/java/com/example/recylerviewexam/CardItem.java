package com.example.recylerviewexam;

public class CardItem {
    // 4. 아이템 정의
    // 데이터 클래스 만들기
    private String title;
    private String contents;

    public CardItem(String title, String contents) {
        // 생성자
        this.title = title;
        this.contents = contents;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "CardItem{" +
                "title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                '}';
    }
}
