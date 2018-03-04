import java.io.*;
import java.net.*;
import java.util.*;
public class Server {
    private int currentTot;
    ServerSocket serversocket;
    Socket client;
    Socket client2;
    int bytesRead;
    Connect c = new Connect();
    BufferedReader input;
    PrintWriter output;
 PrintWriter output2;

    public void start() throws IOException{
        System.out.println("Connection Starting on port:" + c.getPort());
        //make connection to client on port specified
        serversocket = new ServerSocket(c.getPort());

        //accept connection from client
        client = serversocket.accept();
        client2 = serversocket.accept();
        System.out.println("Waiting for connection from client");

        try {
            logInfo();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void logInfo() throws Exception{
        //open buffered reader for reading data from client
        input = new BufferedReader(new InputStreamReader(client.getInputStream()));

        String message = input.readLine();
        System.out.println("SERVER SIDE: MESSAGE RECIEVED IN HEX FORMAT  " + message);
    

        //open printwriter for writing data to client
        output = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
output2 = new PrintWriter(new OutputStreamWriter(client2.getOutputStream()));


	/*StringBuilder str = new StringBuilder();
        for (int i = 0; i < message.length(); i+=2) {
            str.append((char) Integer.parseInt(message.substring(i, i + 2), 16));
        }
        String result= str.toString();*/
	output.println("Message succesfully recieved by reciever " );
	output2.println(message);
output.flush();
output.close();
output2.flush();
output2.close();


    }
    public static void main(String[] args){
        Server server = new Server();
        try {
            server.start();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }       
}