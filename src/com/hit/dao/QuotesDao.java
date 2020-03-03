package com.hit.dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.hit.dm.Quote;
import netscape.javascript.JSObject;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

public class QuotesDao {
    private List<Quote> data;
    private List<Quote> responseData;

    public QuotesDao() {

        Gson gson = new Gson();

        try {
            URL url = getClass().getResource("quotes.json");
            Type REVIEW_TYPE = new TypeToken<List<Quote>>() {}.getType();
            JsonReader reader = new JsonReader(new FileReader(url.getPath()));
            data = gson.fromJson(reader , REVIEW_TYPE);
        }catch(IOException e){
            System.out.println("exception in QuotesDao");
            e.getMessage();
        }
    }

    public List<Quote> getData() {
        return data;
    }

    public List<Quote> getDataByParameter(String parameter , int intParameterValue){
        // We need to filter by id or rating
        switch (parameter){
            case "id":
                this.responseData = data.stream().filter(quote -> quote.getId() == intParameterValue).collect(Collectors.toList());
                break;
            case "rating":
                this.responseData = data.stream().filter(quote -> quote.getRating() >= intParameterValue).collect(Collectors.toList());
                break;
            default:
                break;
        }
        return this.responseData;
    }

    public List<Quote> getDataByParameter(String parameter , String stringParameterValue){
        // We nee to filter by author name
        this.responseData = data.stream().filter(quote -> quote.getAuthor().equals(stringParameterValue)).collect(Collectors.toList());
        return this.responseData;
    }

    public boolean deleteQuoteById(int quoteIdToDelete){
        URL url = getClass().getResource("quotes.json");
        Gson gson = new Gson();

        this.data = data.stream().filter(quote -> quote.getId() != quoteIdToDelete).collect(Collectors.toList());
        try {
            JsonWriter writer = new JsonWriter(new FileWriter(url.getPath()));
            Type REVIEW_TYPE = new TypeToken<List<Quote>>() {}.getType();
            gson.toJson(data , REVIEW_TYPE, writer);
        }catch (IOException e){
            System.out.println("exception in delete from jsom file");
            e.getMessage();
        }
        return true;
    }
}
