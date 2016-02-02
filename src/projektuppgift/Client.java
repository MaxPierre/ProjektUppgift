/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektuppgift;

import java.io.*;
import java.net.*;

/**
 *
 * @author maxpi
 */
public class Client {

    private String myName;
    private String hostAdress;
    
    private PrintWriter out;
    private BufferedReader in;
    
    private ServerSocket serverSocket;
    private Socket clientSocket;
      
    private String userInput;  
    private BufferedReader stdIn;
    
    public Client() throws IOException{
        
        clientSocket = null;
        out = null;
        in = null;
        hostAdress = ChatStart.ChatInstance.getIP();
        
        try {
            clientSocket = new Socket(hostAdress, 4444);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                                        clientSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host.\n" + e);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                               + "the connection to host.\n" + e);
            System.exit(1);
        }

	System.out.println("Connection successful!");
	stdIn = new BufferedReader(new InputStreamReader(System.in));
        
	while ((userInput = stdIn.readLine()) != null) {
	    out.println(userInput);
	}
        
	out.close();
	in.close();
	stdIn.close();
	clientSocket.close();
    }
}