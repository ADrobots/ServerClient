import java.net.ServerSocket;
import java.net.Socket;

public class MultithreadedSocketServer {
    public static void main(String[] args) throws Exception {
        try{
            ServerSocket server=new ServerSocket(8888);
            ServerSocket serverGame=new ServerSocket(8088);
            int counter=0;
            System.out.println("Server Started ....");
            while(true){
                counter++;
                System.out.println("start1");
                Socket serverClient=server.accept();  // сервер принимает запрос на подключение клиента
                System.out.println("start2");
                Socket serverGameClient=serverGame.accept();  // сервер принимает запрос на подключение клиента
                System.out.println("start3");
                System.out.println(" >> " + "Client No:" + counter + " started!");
                ServerClientThread sct = new ServerClientThread(serverClient,counter); // отправляем запрос в отдельный поток
                sct.start();
                ServerGameThread sgt=new ServerGameThread(serverGameClient);
                sgt.start();
                
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
