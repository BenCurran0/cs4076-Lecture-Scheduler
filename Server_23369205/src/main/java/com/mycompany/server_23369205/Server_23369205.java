package com.mycompany.server_23369205;

import java.io.*;
import java.net.*;

public class Server_23369205 {
    
    private static final int port = 1234;
    

    public static void main(String[] args) {
        ServerSocket socket = null;
        
        try {
            socket = new ServerSocket(port);
            System.out.println("Server is waiting for connection from client");

            
                Socket clientSocket = socket.accept();
                System.out.println("Client connected from " + clientSocket.getInetAddress());
                
                BufferedReader in;
                PrintWriter out;
                String clientRequest;
                
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                
                while ((clientRequest = in.readLine()) != null) {
                String response = RequestProcessor.checkRequest(clientRequest);
                out.println(response);
                }
            
        } 
        catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        }
        
        
    }
    
    
   }

    
