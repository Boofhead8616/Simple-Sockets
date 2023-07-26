/*
 * File Name: Server.java
 * Author: Shawn Towler
 * Date Modified: 26/07/2023
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(7777);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        ){
            System.out.println("CONNECTION OPEN");
            String inputString;
            while (true){
                inputString = in.readLine();
                if (inputString.equals("HELLO")) {
                    break;
                }
            }
            System.out.println(inputString);
            out.println("HI, HOW ARE YOU");
        } catch (IOException e) {
            System.err.println("Error when listening on or connecting to port: 7777");
        }
    }
}