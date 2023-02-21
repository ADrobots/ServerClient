package copy;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args){
        try {
            ServerSocket serverSocket = new ServerSocket(5050);
            System.out.println("Waiting for a client ...");

            Socket socket=serverSocket.accept();
            System.out.println("Got a client");

            InputStream inputStream=socket.getInputStream();
            OutputStream outputStream=socket.getOutputStream();

            DataInputStream in=new DataInputStream(inputStream);
            DataOutputStream out=new DataOutputStream(outputStream);

            while (true) {            	
                String line = null;
                line = in.readUTF();
                System.out.println(line);
                out.writeUTF(line);
                out.flush();
                socket.close();
            }





        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
