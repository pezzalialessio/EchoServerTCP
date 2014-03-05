package echoserver;

import java.io.*;
import java.net.*;

public class EchoServer extends Thread{
   Socket socket;
   int port=2000;
   InputStream in;
   OutputStream out;
   String messageIn = "ciao";
   PrintWriter pr;
   EchoServer(Socket s){
       socket = s;
       
   }
   public void run(){
       try{
          while(!messageIn.equals("Fine") && !messageIn.equals("fine")){
            in = socket.getInputStream();
            out = socket.getOutputStream();
            pr = new PrintWriter(out);
            BufferedReader buf = new BufferedReader(new InputStreamReader(in));
            messageIn = buf.readLine();
            System.out.println("Messaggio Ricevuto: " + messageIn);
            System.out.println("Risposta inviata");
            pr.println(messageIn);
            pr.flush(); 
            socket.close();
          }  
          System.out.println("Chiusura server in corso..");
          System.exit(0);
       }catch(Exception e){}
       
       
   }
}
