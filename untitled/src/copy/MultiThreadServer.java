package copy;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadServer implements Runnable{
	Socket socket;
	
	public MultiThreadServer(Socket socket) {
		this.socket=socket;
	}
	
	public void run() {
		try {
			/*PrintStream printStream=new PrintStream(socket.getOutputStream());
			for(int i=100; i>=0;i--) {
				printStream.println(i+" ... ");
			}*/
			
			InputStream inputStream=socket.getInputStream();
			DataInputStream in=new DataInputStream(inputStream);
			System.out.println(in.readUTF());
			
		}catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(5050);
		
		while(true) {
			Socket socket=serverSocket.accept();
	        System.out.println("Connected");
			new Thread(new MultiThreadServer(socket));
		}
	}
}
