import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import field.Field;
import gamer.Gamer;

class ServerClientThread extends Thread {
    Socket serverClient;
    int clientNo;
    int squre;
    ServerClientThread(Socket inSocket, int counter){
        serverClient = inSocket;
        clientNo=counter;
    }
    public void run(){
        try{
            DataInputStream inStream = new DataInputStream(serverClient.getInputStream());
            DataOutputStream outStream = new DataOutputStream(serverClient.getOutputStream());
            //String clientMessage="", serverMessage="";
            /*while(!clientMessage.equals("bye")){
                clientMessage=inStream.readUTF();
                System.out.println("From Client-" +clientNo+ ": Number is :"+clientMessage);
                squre = Integer.parseInt(clientMessage) * Integer.parseInt(clientMessage);
                serverMessage="From Server to Client-" + clientNo + " Square of " + clientMessage + " is " +squre;
                outStream.writeUTF(serverMessage);
                outStream.flush();
            }*/

            String line = "";
            while (!line.equals("exit")) {
                line = inStream.readUTF();
                System.out.println("Client No:"+clientNo+" "+line);
                outStream.writeUTF(line);
                outStream.flush();
            }
            System.out.println("Close stream");
            inStream.close();
            outStream.close();
            serverClient.close();
        }catch(Exception ex){
            System.out.println(ex);
        }finally{
            System.out.println("Client -" + clientNo + " exit!! ");
        }
    }
}
