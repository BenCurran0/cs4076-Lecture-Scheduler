package com.mycompany.tcpechoclient;

import java.io.*;
import java.net.*;
import java.util.HashMap;

public class Server_23369205 {
    
    private static final int port = 1234;
    private static HashMap<String, String> courseSchedule = new HashMap<>(); 

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
                    String response = checkRequest(clientRequest);
                    out.println(response);
                }

                clientSocket.close();
                System.out.println("Connection with client is now closed");
            
        } 
        catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        }
        
        finally {
            try {
                if (socket != null  && !socket.isClosed()) {
                    socket.close();
                    System.out.println("Server socket is now closed.");
                }
            } catch (IOException e) {
                System.out.println("Unable to disconnect/close!");
            }
        }
    }


    private static String checkRequest(String request) {

        String[] parts = request.split(" ");

            String command = parts[0].toUpperCase();
            String moduleCode = parts[1];

            switch (command) {
                case "ADD":
                if (parts.length < 4) {
                    return "Invalid ADD format";
                }
                return addLecture(moduleCode, parts[2], parts[3]);

                case "REMOVE":
                    removeLecture(moduleCode);
                        return "Lecture removed: " + moduleCode;
                    
                case "DISPLAY":
                    displaySchedule();
                    
                default:
                    return "Unknown command";
            
        }
    }

    private static String addLecture(String moduleCode, String room, String time) {
        int[] timeSplit  = time.split(-);
        int start = timeSplit[0];
        int end = timeSplit[1];
        courseSchedule.put();
        return "Lecture added: " + moduleCode + " " + room + "  " + time;
    }

    private static String removeLecture(String moduleCode){

    }

    private static String displaySchedule() {

    }
}
