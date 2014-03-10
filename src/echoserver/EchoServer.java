package echoserver;

import java.io.*;
import java.net.*;

public class EchoServer extends Thread{
   Socket socket;
   int port=2000;
   InputStream in;
   OutputStream out;
   String messageIn = "ciao", messageOut;
   PrintWriter pr;
   static boolean maiusc = false;
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
            if(messageIn.equals("Maiuscolo: on")){
                 maiusc = true;
                 System.out.println(maiusc);
                 pr.println("Attivato");
                 pr.flush();
            }else{
                if(messageIn.equals("Maiuscolo: off")){
                    maiusc = false;
                    System.out.println(maiusc);
                    pr.println("Disattivato");
                    pr.flush();
                }else{
                   if(maiusc == true){
                        System.out.println(messageIn);
                        messageOut = messageIn.toUpperCase();
                        System.out.println(messageOut);
                        pr.println(messageOut);
                        pr.flush(); 
                    }
                    else{
                        System.out.println(messageIn);
                        messageOut = messageIn;
                        System.out.println(messageOut);
                        pr.println(messageOut);
                        pr.flush(); 
                    }  
                } 
            }
        }
        socket.close();
        System.out.println("socket chiusa..");
       }catch(Exception e){}
       
       
   }
}
