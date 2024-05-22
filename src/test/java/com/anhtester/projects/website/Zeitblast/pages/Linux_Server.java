package com.anhtester.projects.website.Zeitblast.pages;

import com.anhtester.constants.FrameworkConstants;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class Linux_Server {
//	  private static final String ipAddress = "54.209.107.103";
//	    private static final String username = "hariharan";
//	    private static final  String password = "ovhari@1324#$";
	    
        
       

	    private Session session;
	    private ChannelExec channel;
	    public void InitiateServer() throws InterruptedException {
	    	int maxRetries = 3;
			int retryInterval = 5000; // 1 second
			int retryCount = 0;
			boolean connected = false;
			while (!connected && retryCount < maxRetries) 
	        try {
	      
	            JSch jsch = new JSch();	        
	            session = jsch.getSession(FrameworkConstants.SERVER_USERNAME, FrameworkConstants.SERVER_IP_ADDRESS, 22);
	            session.setPassword(FrameworkConstants.SERVER_PASSWORD);
	            session.setConfig("StrictHostKeyChecking", "no");
	            session.connect();
	            connected = true;
	      		    } catch (Exception  e) {
	      		        retryCount++;
	      		        Thread.sleep(retryInterval);
	      		    }
	    }  
	    public void commandinserver(String command) {
	        try {
	            // Create SSH channel
	            channel = (ChannelExec) session.openChannel("exec");
	            channel.setCommand(command);

	            // Connect to the channel
	            channel.connect();
	        } catch (JSchException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public void CloseServer() {
	        try {
	            // Disconnect the channel
	            channel.disconnect();

	            // Disconnect SSH session
	            session.disconnect();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
