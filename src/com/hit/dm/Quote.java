package com.hit.dm;

public class Quote {
    private String quote;
    private String author;
    private int id;
    private int rating;

    public Quote(String quote, String author , int id , int rating) {
        this.quote = quote;
        this.author = author;
        this.id = id;
        this.rating = rating;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return ("qoute: " + this.getQuote() + " author " + this.getAuthor() + " id " + this.getId() + " rating " + this.getRating());
    }
}
