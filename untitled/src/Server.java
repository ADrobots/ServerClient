import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Server extends Thread{
    private ServerSocket serverSocket;

    public Server(int port) throws IOException {
        serverSocket=new ServerSocket(port);
        serverSocket.setSoTimeout(10000);
    }

    public void run(){
        while(true){
            try{
                Socket server = serverSocket.accept();
                //System.out.println("Порт сервера "+server.getRemoteSocketAddress());
                DataInputStream command=new DataInputStream(server.getInputStream());
                DataOutputStream result=new DataOutputStream(server.getOutputStream());
                //Commands commands=new Commands();
                //String res=commands.readCommands(command.readUTF());

                String com=command.readUTF();
                result.writeUTF(com);
                result.flush();

                /*switch(command.readUTF()){
                    case "dir":
                        File path=new File("./");
                        String files=new String();
                        for(File f:path.listFiles()){
                            files+=f.getName()+"\n";
                        }
                        result.writeUTF(files);
                                break;
                    default:result.writeUTF("no");
                                break;
                }*/
                /*DataOutputStream out=new DataOutputStream(server.getOutputStream());
                File path=new File("./");
                String files=new String();
                for(File f:path.listFiles()){
                    files+=f.getName()+"\n";
                }
                out.writeUTF(files);
                out.writeUTF("Hello from Server");*/
            } catch (SocketTimeoutException e) {
                System.out.println("Время сокета истекло");
            }catch (IOException e){
                e.printStackTrace();
                break;
            }

        }
    }

    public static void main(String[] args) {
        try{
            Thread server=new Server(5050);
            server.start();
        }catch (IOException e){

        }
    }
}
