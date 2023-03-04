package copy;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) throws Exception {
        try{
            Socket socket=new Socket("192.168.0.49",8888);
            DataInputStream inStream=new DataInputStream(socket.getInputStream());
            DataOutputStream outStream=new DataOutputStream(socket.getOutputStream());
            //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            //String clientMessage="",serverMessage="";
            /*while(!clientMessage.equals("bye")){
                System.out.println("Enter number :");
                clientMessage=br.readLine();
                outStream.writeUTF(clientMessage);
                outStream.flush();
                serverMessage=inStream.readUTF();
                System.out.println(serverMessage);
            }*/

            String str="";
            while (!str.equals("exit")){
                Scanner input=new Scanner(System.in);
                str=input.nextLine();
                outStream.writeUTF(str);
                outStream.flush();

                inStream=new DataInputStream(socket.getInputStream());
                System.out.println(inStream.readUTF());
            }
            inStream.close();
            outStream.close();
            socket.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
