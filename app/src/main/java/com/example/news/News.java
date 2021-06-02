package com.example.news;

public class News {
    private  String author;
    private String title;
    private  String url;
    private String imageUrl;

    public News(){  }
    public News(String title , String author , String imageUrl , String url){
        this.author=author;
        this.title=title;
        this.imageUrl=imageUrl;
        this.url=url;

    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
