package copy;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadServer implements Runnable{
	Socket socket;
	
	public MultiThreadServer(Socket socket) {
		this.socket=socket;
	}
	
	public void run() {
		try {
			PrintStream printStream=new PrintStream(socket.getOutputStream());
			for(int i=100; i>=0;i--) {
				printStream.println(i+" ... ");
			}
			
		}catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(5050);
		
		while(true) {
			Socket socket=serverSocket.accept();
	        System.out.println("Connected");
			InputStream inputStream=socket.getInputStream();
			OutputStream outputStream=socket.getOutputStream();

			DataInputStream in=new DataInputStream(inputStream);
			DataOutputStream out=new DataOutputStream(outputStream);

			String line = null;
			line = in.readUTF();
			System.out.println(line);
			out.writeUTF(line);
			out.flush();


			new Thread(new MultiThreadServer(socket));
		}
	}
}
