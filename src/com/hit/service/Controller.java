package com.hit.service;

import com.hit.dao.QuotesDao;
import com.hit.dm.Quote;

import java.util.List;

public class Controller {

    QuotesDao quotesDao = new QuotesDao();

    public List<Quote> getAllQuotes() {
        return quotesDao.getData();
    }

    public List<Quote> getDataByParameter(String parameter , int intParameterValue){
        return quotesDao.getDataByParameter(parameter , intParameterValue);
    }

    public List<Quote> getDataByParameter(String parameter , String stringParameterValue){
        return quotesDao.getDataByParameter(parameter , stringParameterValue);
    }

    public boolean deleteById(int idToDelete){
        return quotesDao.deleteQuoteById(idToDelete);
    }
}
