package copy;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String address="localhost";
        int serverSocket=5050;
        try {
            InetAddress ipAddress=InetAddress.getByName(address);
            Socket socket=new Socket(ipAddress,serverSocket);

            InputStream inputStream=socket.getInputStream();
            OutputStream outputStream=socket.getOutputStream();

            DataInputStream in=new DataInputStream(inputStream);
            DataOutputStream out=new DataOutputStream(outputStream);

            String str=null;
            while (true){
                Scanner input=new Scanner(System.in);
                str=input.nextLine();
                out.writeUTF(str);
                out.flush();

                in=new DataInputStream(socket.getInputStream());
                System.out.println(in.readUTF());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
