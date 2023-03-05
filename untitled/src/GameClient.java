import java.net.Socket;

public class GameClient {
	public static void main(String[] args) {
		 try{
	            Socket socket=new Socket("192.168.0.7",8088);
		 }catch(Exception e) {
			 
		 }
	}
}
