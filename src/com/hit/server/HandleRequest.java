package com.hit.server;

import com.hit.service.Controller;

public class HandleRequest {
    private Request request;
    private Controller controller;
    private Response response;
    private String action;
    private String parameter;
    private String stringParameter;
    private int intParameter;


    public HandleRequest(Request request) {
        this.request = request;
        action = this.request.getAction();
        parameter = this.request.getParameter();
        stringParameter = this.request.getStringParameter();
        intParameter = this.request.getIntParameter();

        this.controller = new Controller();
        requestsRouter();
    }

    public void requestsRouter(){
        if(this.parameter == null){
            switch (this.action){
                case "get":
                    response = new Response(controller.getAllQuotes());
                    break;
                default:
                    break;
            }
        }else{
            handleParameterRequest();
        }
    }

    public void handleParameterRequest(){
        switch (this.action){
            case "get":
                handleGetRequestWithParams();
                break;
            case "delete":
                handleDeleteById();
                break;
            default:
                break;
        }

    }

    public void handleGetRequestWithParams(){
        // We know this is a get request
        if(this.parameter.matches("id|rating")){
            response = new Response(controller.getDataByParameter(this.parameter , this.intParameter));
        }else{
            response = new Response(controller.getDataByParameter(this.parameter , this.stringParameter));
        }
    }

    public void handleDeleteById(){
        response = new Response(controller.deleteById(this.intParameter));
    }

    public Response getResponse() {
        return response;
    }
}
