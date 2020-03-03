package com.hit.server;

import com.hit.dm.Quote;

import java.util.List;

public class Response {
    private List<Quote> data;
    private boolean atomicAnswer;

    public Response(List<Quote> data) {
        this.data = data;
    }

    public Response(boolean atomicAnswer) {
        this.atomicAnswer = atomicAnswer;
    }

    // return data
    public List<Quote> getData() {
        return data;
    }

    // return true or false
    public boolean getAtomicAnswer() {
        return atomicAnswer;
    }

}
