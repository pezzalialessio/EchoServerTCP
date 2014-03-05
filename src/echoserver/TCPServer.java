package echoserver;

import java.io.IOException;
import java.net.ServerSocket;

public class TCPServer {
   public static void main(String[] arg) throws IOException{
       int port=2000;
       ServerSocket sSocket;
       try{
           sSocket=new ServerSocket(port);
           System.out.println("Apertura porta n. "+ port);
           while(true){
               new EchoServer(sSocket.accept()).start();
           }
       }catch(IOException e){}
   } 
}
