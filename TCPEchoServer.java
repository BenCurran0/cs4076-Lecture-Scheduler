
package com.mycompany.tcpechoclient;

import java.io.*;
import java.net.*;

public class TCPEchoServer {
    
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
                String clientMessage;
                
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                
                while ((clientMessage = in.readLine()) != null) {
                    System.out.println("Message from the client: " + clientMessage);
                    out.println(clientMessage);
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
}
