import java.io.*;
import java.net.*;
import javax.swing.*;
public class Client2 {
    private final String FILENAME = null;
    Connect c = new Connect();
    Socket socket;
    BufferedReader read;

    public void startClient() throws UnknownHostException, IOException{
        //Create socket connection
        socket = new Socket(c.gethostName(), c.getPort());


        //create Buffered reader for reading response from server
        read = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        //read response from server
        String response = read.readLine();

	StringBuilder str = new StringBuilder();
        for (int i = 0; i < response.length(); i+=2) {
            str.append((char) Integer.parseInt(response.substring(i, i + 2), 16));
        }
        String result= str.toString();

      //  System.out.println("This is the response: " + response);

        //display response
        JOptionPane.showMessageDialog(null, result+ "  (HEX FORMAT : "+response+" )");
    }

   

    public static void main(String args[]){
        Client2 client = new Client2();
        try {
            client.startClient();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}