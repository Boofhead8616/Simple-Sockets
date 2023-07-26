/*
 * File Name: Client.java
 * Author: Shawn Towler
 * Date Modified: 26/07/2023
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try (Socket clientSocket = new Socket("127.0.0.1", 7777);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        ) {
            out.println("HELLO");
            String inputLine;
            while (true){
                inputLine = in.readLine();
                if(inputLine.equals("HI, HOW ARE YOU")){
                    break;
                }
            }
            System.out.println(inputLine);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}