/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektuppgift;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maxpi
 */
public class Server {
    
    private String myName;
    private int port;
    
    private PrintWriter out;
    private BufferedReader in;
    
    private ServerSocket serverSocket;
    private Socket clientSocket;
    
    public Server() {
        
        clientSocket = null;
        
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException ex) {
            System.out.println("Port failed: " + port);
            System.exit(-1);
        }
        
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.out.println("Accept failed: " + port);
            System.exit(-1);
        }
        
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch(IOException e) {
            System.out.println("getOutputStream failed: " + e);
            System.exit(1);        
        }
        
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch(IOException e) {
            System.out.println("getInputStream failed: " + e);
            System.exit(1);        
        }
        
    }
    
    public PrintWriter getOut(){
        return out;
    }
    
    public BufferedReader getIn(){
        return in;
    }
        
    
}
