import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client extends Thread{
    private static String serverName="192.168.0.7";
    private Socket client;

    private DataOutputStream out;
    private DataInputStream in;

    private Commands commands=new Commands();

    public Client() throws IOException{
        client=new Socket(serverName, 5050);
    }


    public void run(){
        while(true){
            Scanner input=new Scanner(System.in);
            String command=input.nextLine();


            try {
                out=new DataOutputStream(client.getOutputStream());
                //out.writeUTF(commands.readCommands(command));
                out.writeUTF(command);
                in=new DataInputStream(client.getInputStream());
                System.out.println(in.readUTF());

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            //command=input.nextLine();
            /*switch (command){
                case "dir":
                    try {
                        out=new DataOutputStream(client.getOutputStream());
                        out.writeUTF("dir");
                        in=new DataInputStream(client.getInputStream());
                        System.out.println(in.readUTF());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "exit":
                    return;

            }*/

        }
    }

    public static void main(String[] args){
        try {
            Client client=new Client();
            client.start();
        }catch (IOException e){

        }
        /*try{
            System.out.println("Подключение к серверу "+serverName+" на порту "+5050);
            Socket client=new Socket(serverName, 5050);
            OutputStream outputStream= client.getOutputStream();
            DataOutputStream command=new DataOutputStream(outputStream);
            command.writeUTF("lss");

            DataInputStream in=new DataInputStream(client.getInputStream());
            System.out.println(in.readUTF());


        }catch(IOException e){
            e.printStackTrace();
        }*/
    }

}
