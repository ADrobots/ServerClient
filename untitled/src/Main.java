import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)/*throws Exception*/{
           //System.out.println(System.getProperty("user.dir"));
           //File file=new File(System.getProperty("user.dir"));
           /* File file=new File("./");
           for(File f:file.listFiles()){
                   System.out.println(f.getName());
           }*/

            /*Scanner input=new Scanner(System.in);
            String num=input.nextLine();
            while(!num.equals("exit")) {
                System.out.println(num);
                num = input.nextLine();
            }*/

        Scanner input=new Scanner(System.in);
        String command=input.nextLine();
        while(!command.equals("exit")){

            switch (command){
                case "dir":
                    System.out.println("dir");
                    break;
                case "exit":
                    System.out.println();
                    return;

            }
            command=input.nextLine();
        }

    }
}