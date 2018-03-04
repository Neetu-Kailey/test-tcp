import java.io.*;
import java.math.BigInteger;
import java.net.*;
import javax.swing.*;
public class Client {
    private final String FILENAME = null;
    Connect c = new Connect();
    Socket socket;
    BufferedReader read;
    PrintWriter output;

    public void startClient() throws UnknownHostException, IOException{
        //Create socket connection
        socket = new Socket(c.gethostName(), c.getPort());

        //create printwriter for sending login to server
        output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

        //prompt for user name
        String message = JOptionPane.showInputDialog(null, "Enter Your message:");

	
	String []b=message.split(":");
	message = b[2];
	//convert to hexadecimal
	String message2=String.format("%040x", new BigInteger(1, message.getBytes(/*YOUR_CHARSET?*/)));
        //send user name to server
	
        output.println(message2);

    
        output.flush();

        //create Buffered reader for reading response from server
        read = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        //read response from server
        String response = read.readLine();
        System.out.println("This is the response: " + response);

        //display response
       /* JOptionPane.showMessageDialog(null, response);*/
    }

    public void fileInfo(){

    }

    public static void main(String args[]){
        Client client = new Client();
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