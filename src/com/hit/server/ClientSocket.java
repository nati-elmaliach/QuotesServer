package com.hit.server;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocket extends Thread {
    private Socket socket;
    private HandleRequest requestHandler;

    public ClientSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            BufferedReader input = new BufferedReader( new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream() , true);
            Gson gson = new Gson();

            // Read the client request
            String inputString = input.readLine();

            // convert the request to a class
            Request request = gson.fromJson(inputString , Request.class);

            this.requestHandler = new HandleRequest(request);

            // format the response to be json
            String jsonResponse = gson.toJson(requestHandler.getResponse());

            // send the json to the client
            System.out.println("sending response for " + request.getAction());
            output.println(jsonResponse);

        }catch (IOException e){
            System.out.println("catch");

            e.getMessage();
        }
        finally {
            try{
                socket.close();
            }catch (IOException e){
                e.getMessage();
            }
        }
    }
}
