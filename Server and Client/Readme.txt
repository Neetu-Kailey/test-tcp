1. First of all generate byte code for all classes
	javac Connect.java
	javac Server.java
	javac Client.java
	javac Client2.java

1. For server side run the following command in command prompt.
	java Server

2. Then for sending message from first client run the following command in new command prompt.(Don't close the already opened command prompt).
	java Client

 It will ask you to enter an message.Then click Ok.

3. Then again open the third command prompt for 2nd client.
	java Client2
	
 It will display the recieved message from the first client.